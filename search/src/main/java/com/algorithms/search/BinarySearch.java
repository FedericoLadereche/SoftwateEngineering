package com.algorithms.search;

public class BinarySearch<T extends Comparable<T>> {

    /**
     * Best: O(1) Average: O(log n) Worst: O(log n) Space: O(log n) recursions on stack
     * 
     * @param searchArray
     * @param value
     * @return boolean
     */
    public boolean searchRecursive(T[] searchArray, T value) {

        // IT CAN BE HANDLED AS A PRECONDITION
        if (searchArray == null) {
            throw new NullPointerException("Boom! Null array baby");
        }

        // IT CAN BE HANDLED AS A PRECONDITION
        if (searchArray.length == 0) {
            return false;
        }

        int firstSearchIndex = (searchArray.length - 1) / 2;
        double logN = Math.log(searchArray.length);//Maximum trials

        return recursive(searchArray, firstSearchIndex, value, logN);
    }

    private boolean recursive(T[] searchArray, int index, T value, double logN) {
        int comparision = searchArray[index].compareTo(value);

        // 404 not found :(
        if (logN < 0) {
            return comparision == 0;
        }

        // Base condition, value found
        if (comparision == 0) {
            return true;
        }

        // Value is greater than value stored at index, go to right
        if (comparision < 0) {
            return recursive(searchArray, (index + searchArray.length) / 2, value, --logN);
        }
        // Value is lesser, go to left
        else {
            return recursive(searchArray, (index + 1) / 2, value, --logN);
        }
    }


    
    /** 
     * Best: O(1) Average: O(log n) Worst: O(log n) Space: O(1) because constant operations on iterative process
     * @param searchArray
     * @param value
     * @return boolean
     */
    public boolean searchIterative(T[] searchArray, T value) {
        // IT CAN BE HANDLED AS A PRECONDITION
        if (searchArray == null) {
            throw new NullPointerException("Boom! Null array baby");
        }

        // IT CAN BE HANDLED AS A PRECONDITION
        if (searchArray.length == 0) {
            return false;
        }

        int low = 0;
        int high = searchArray.length - 1;
        //Maximum number of comparisons
        double logN = Math.log(searchArray.length);

        while (!(logN < -1)) {//Same condition as (low <= high)
            logN--;
            int index = (low + high) / 2;
            int comparision = searchArray[index].compareTo(value);

            //Number greater than found at index
            if (comparision < 0) {
                low = index + 1;
            } else if (comparision > 0) {
                high = index - 1;
            } else
                //Value found
                return true;
        }

        //404 Not found :(
        return false;

    }

}