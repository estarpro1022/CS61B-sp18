import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    CharacterComparator offByN = new OffByN(3);

    @Test
    public void test1() {
        assertTrue(offByN.equalChars('a', 'd'));
        assertTrue(offByN.equalChars('C', 'F'));
    }

    @Test
    public void test2() {
        assertFalse(offByN.equalChars('m', 'm'));
        assertFalse(offByN.equalChars('a', 'b'));
    }
}
