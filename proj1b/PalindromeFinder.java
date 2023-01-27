/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        Palindrome palindrome = new Palindrome();

        int maxWordNum = 0;
        int maxN = 0;
        for (int n = 0; n < 26; n++) {
            In in = new In("../library-sp18/data/words.txt");
            CharacterComparator cc = new OffByN(n);
            int wordNum = 0;
            while (!in.isEmpty()) {
                String word = in.readString();
                if (word.length() >= minLength && palindrome.isPalindrome(word, cc)) {
                    wordNum++;
                }
            }
            System.out.println("N is " + n + ": " + wordNum);
            if (wordNum > maxWordNum) {
                maxWordNum = wordNum;
                maxN = n;
            }
        }
        System.out.println("When off by " + maxN + ", palindrome number is biggest. " + maxWordNum);
    }
}
