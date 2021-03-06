import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test(timeout = 1000)
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.
    @Test(timeout = 1000)
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("lladll"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("did"));
        assertFalse(palindrome.isPalindrome(""));
        CharacterComparator offByOne = new OffByOne();
        assertTrue(palindrome.isPalindrome("cad", offByOne));
        assertFalse(palindrome.isPalindrome("bob", offByOne));
        assertFalse(palindrome.isPalindrome("noon", offByOne));
        assertTrue(palindrome.isPalindrome("a", offByOne));
        assertTrue(palindrome.isPalindrome("ccdd", offByOne));
        assertFalse(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome("AABB", offByOne));
        assertTrue(palindrome.isPalindrome("%7", offByOne));
    }
}
