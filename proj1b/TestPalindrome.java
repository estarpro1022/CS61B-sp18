import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome1() {
        assertTrue("heh is palindrome.", palindrome.isPalindrome("heh"));
        assertTrue("level is palindrome.", palindrome.isPalindrome("level"));
        assertTrue("hhhhhh is palindrome.", palindrome.isPalindrome("hhhhhh"));
    }

    @Test
    public void testIsPalindrome2() {
        assertTrue("empty string is palindrome.", palindrome.isPalindrome(""));
        assertTrue("single character is palindrome.", palindrome.isPalindrome("e"));
    }

    @Test
    public void testIsPalindrome4() {
        assertFalse("stranger is not palindrome.", palindrome.isPalindrome("stranger"));
        assertFalse(palindrome.isPalindrome("apple"));
    }

    @Test
    public void testIsPalindromeByOne1() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", cc));
        assertTrue(palindrome.isPalindrome("a%&b", cc));
        assertTrue(palindrome.isPalindrome("", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
    }

    @Test
    public void testIsPalindromeByOne2() {
        CharacterComparator cc = new OffByOne();
        assertFalse(palindrome.isPalindrome("abcd", cc));
        assertFalse(palindrome.isPalindrome("%%%", cc));
    }
}
