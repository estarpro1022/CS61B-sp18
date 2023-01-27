import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.

    @Test
    public void testOffByOne1() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('n', 'm'));
        assertTrue(offByOne.equalChars('%', '&'));
    }

    @Test
    public void testOffByOne2() {
        assertFalse(offByOne.equalChars('m', 'm'));
        assertFalse(offByOne.equalChars('%', '%'));
        assertFalse(offByOne.equalChars('c', 'm'));
    }
}
