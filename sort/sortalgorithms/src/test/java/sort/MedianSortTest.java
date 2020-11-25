package sort;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MedianSortTest {
    int[] array;
    
    @Before
    public void setup(){
        array = new int[] {15, 9, 8, 1, 4, 11, 7, 12, 13, 6, 5, 3, 16, 2, 14};
    }
        
    @Test
    public void testPartition() {
       //assertEquals(5, MedianSort.partition(array, 0, 14, 9));
       //assertEquals(6, MedianSort.partition(array, 0, 14, 6));
    }

    @Test
    public void testMedianSort() {
        assertEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}, 
        MedianSort.medianSort(array));
    }

    @Test
    public void orderedArrayBruteForceTest() {
        int[] result = MedianSort.medianSort(array);
        int expectedValue = 1;
        
        for (int actualValue : result) {
           assertEquals(expectedValue++, actualValue); 
        }
    }
}