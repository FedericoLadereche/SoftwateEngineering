package interviewquestions.codesignal.alternatingsort;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;    
    
public class AlternatingSortTest {
    AlternatingSort solution;

    @Before
    public void setup(){
        solution = new AlternatingSort();
    }
        
    @Test
    public void test() {
       assertTrue(solution.alternatingSort(new int[]{1}));
       assertTrue(solution.alternatingSort(new int[]{1, 2}));
       assertFalse(solution.alternatingSort(new int[]{2, 1}));
       assertTrue(solution.alternatingSort(new int[]{1, 3, 2}));
       assertFalse(solution.alternatingSort(new int[]{1, 3, 6, 5, 4}));
       assertTrue(solution.alternatingSort(new int[]{1, 4, 6, 5, 3}));
       assertTrue(solution.alternatingSort(new int[]{1, 3, 5, 6, 4, 2}));
       assertFalse(solution.alternatingSort(new int[]{1, 4, 5, 6, 3}));
    }
}
    