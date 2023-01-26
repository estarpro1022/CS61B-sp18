import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {
    @Test
    public void testSort() {
        String[] input = {"trust", "Don't", "strangers"};
        String[] expected = {"Don't", "strangers", "trust"};

        Sort.sort(input);

        org.junit.Assert.assertArrayEquals(expected, input);
    }

    /** Test the Sort.testFindSmallest method. */
    @Test
    public void testFindSmallestIndex() {
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;

        int actual = Sort.findSmallestIndex(input, 0);

        org.junit.Assert.assertEquals(expected, actual);

        String[] input2 = {"talk", "with", "me"};
        int expected2 = 2;

        int actual2 = Sort.findSmallestIndex(input2, 0);

        org.junit.Assert.assertEquals(expected2, actual2);
    }

    /** Test the Sort.swap method */
    @Test
    public void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "have", "i", "egg"};

        Sort.swap(input, 0, 2);

        org.junit.Assert.assertArrayEquals(expected, input);
    }
}
