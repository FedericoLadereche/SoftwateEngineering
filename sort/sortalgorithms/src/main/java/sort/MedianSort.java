package sort;

public class MedianSort {

    private MedianSort() {}

    //Public API
    public static int[] medianSort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        return mediansort(array, left, right);
    }

    //Sort array ar[left,right] using medianSort method.
    private static int[] mediansort(int[] array, int left, int right) {
        // If the subarray to be sorted has 1 (or fewer!) elements, done.
        if (right <= left) {
            return array;
        }

        // Get midpoint and median element position (1<=k<=right-left-1)
        int mid = (right - left + 1) / 2;
        int me = selectKth(array, mid + 1, left, right);

        mediansort(array, left, left + mid - 1);
        mediansort(array, left + mid + 1, right);

        return array;
    }

    /**
     * Average-case linear time recursive algorithm to find position of kth element
     * in ar, which is modified as this computation proceeds. Note 1 <= k <=
     * right-left+1. The comparison function, cmp, is needed to properly compare
     * elements. Worst-case is quadratic, O(n^2).
     */
    public static int selectKth(int[] subArray, int k, int left, int right) {
        int idx = selectPivotIndex(subArray, left, right);
        int pivotIndex = partition(subArray, left, right, idx);
        if (left + k - 1 == pivotIndex) {
            return pivotIndex;
        }

        //Continue the loop, narrowing the range as appropriate.
        //If we are within the left-hand side of the pivot then k can stay the same.
        if (left + k - 1 < pivotIndex) {
            return selectKth(subArray, k, left, pivotIndex - 1);
        } else {
            return selectKth(subArray, k - (pivotIndex - left + 1), pivotIndex + 1, right);
        }
    }

    private static int selectPivotIndex(int[] subArray, int left, int right) {
        return left;
    }
    /**
     * In linear time, group the subarray ar[left, right] around a pivot element
     * pivot=ar[pivotIndex] by storing pivot into its proper location, store, within
     * the subarray (whose location is returned by this function) and ensuring that
     * all ar[left,store) <= pivot and all ar[store+1,right] > pivot.
     */
    private static int partition(int[] subArray, int left, int right, int pivotIndex) {
        int pivot = subArray[pivotIndex];

        // Move pivot to the end of the array. Swap with rightmost
        int tmp = subArray[right];
        subArray[right] = subArray[pivotIndex];
        subArray[pivotIndex] = tmp;

        int store;
        store = left;

        // All values <= pivot are moved to front of array and pivot inserted just after them.
        for (int idx = left; idx < right; idx++) {
            if (subArray[idx] <= pivot) {
                tmp = subArray[idx];
                subArray[idx] = subArray[store];
                subArray[store] = tmp;
                store++;
            }
        }

        // Last swap to move pivot to its sequence position
        tmp = subArray[right];
        subArray[right] = subArray[store];
        subArray[store] = tmp;

        // Pivot value position
        return store;
    }
}