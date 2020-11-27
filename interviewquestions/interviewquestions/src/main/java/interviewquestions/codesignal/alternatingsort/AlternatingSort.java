package interviewquestions.codesignal.alternatingsort;

public class AlternatingSort {
    /** 
     * Iterative solution.
     * O(n) time (n can be array length / 2) | O(1) space.
     * We iterate over array 'a' accessing virtual array 'b' locations. If we find values out of order quit returning false, 
     * otherwise true.
     * In order to avoid useless computations we can skip array 'b' creation since we have a mapping algorithm to go from array 'a' to array 'b'.
     * So we can create a virtual array 'b' in the sense that we can access to the specified locations in array 'a' and do the right comparisons.
     * We must take into account that an array 'a' is considered to be ordered if and only if every element on the sequence is greater
     * than the next and lesser than the previous (a[x] < a[x + 1]). 
     * Because the nature of the comparisons (two on two) we must be careful when checking this condition on virtual array
     * 'b' doing forward and backward comparisons to assure the right order.
     * @param a
     * @return boolean
     */
    public boolean alternatingSort(int[] a) {

        int currentIterations = 0; // Current number of iterations traversing array 'a'.
        int halfArray = (a.length + 1) / 2; // Maximum iterations because we compare 2 locations simultaneously of same array each time unrolling it.
        int currentIndex = 0;// Index to access array 'a' values in sequence.
        int lastCurrentIndex = a.length - 1;// Index to access array 'a' values from back to front.

        while(currentIterations < halfArray && lastCurrentIndex > currentIndex) { // "lastCurrentIndex > currentIndex" handles the case when array length its not even.
            
            // Compare natural ascendent order forwards (must a[x] < a[x + 1]).
            if(a[currentIndex] > a[lastCurrentIndex])
                return false;
            
            // Compare natural ascendent order backwards (must a[x] > a[x - 1]).
            if(currentIndex > 0 && (a[currentIndex] < a[lastCurrentIndex + 1]))
                return false;
            
            // Move by the specified algorithm of array 'b' creation.
            currentIterations++;
            currentIndex++;
            lastCurrentIndex--;
        }

        if(currentIndex > 0 && (a[currentIndex] < a[lastCurrentIndex + 1]))
                return false;
                
        return true;
    }
}
