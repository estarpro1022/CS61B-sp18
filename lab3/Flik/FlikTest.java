import org.junit.Test;
import static org.junit.Assert.*;


public class FlikTest {

    @Test
    public void test() {
        Flik f = new Flik();
        for (int i = 0, j = 0; i < 500; i++, j++) {
            assertTrue("Error occurs at " + i, Flik.isSameNumber(i, j));
        }
    }
}
