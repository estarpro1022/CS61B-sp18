import org.junit.Test;
import static org.junit.Assert.*;


public class TestWordUtils {
    @Test
    public void testConstructor() {
        String[] words = new String[] {"hello", "world1", "no", "zip", "smell"};
        WordUtils wu = new WordUtils(words);
    }

    @Test
    public void testLongestString1() {
        String[] words = new String[] {"hello", "world1", "no", "zip", "smell"};
        WordUtils wu = new WordUtils(words);
        assertEquals(wu.longestString(), "world1");
    }
}
