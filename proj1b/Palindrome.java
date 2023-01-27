public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        // 蛮神奇的写法
        Deque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    private boolean isPalindrome(Deque<Character> d) {
        if (d.size() <= 1) {
            return true;
        }

        if (d.removeFirst() != d.removeLast()) {
            return false;
        }
        return isPalindrome(d);
    }

    public boolean isPalindrome(String word) {
        return isPalindrome(wordToDeque(word));
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> q = wordToDeque(word);
        for (int i = 0; i < q.size() / 2; i++) {
            if (!cc.equalChars(q.get(i), q.get(q.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

}
