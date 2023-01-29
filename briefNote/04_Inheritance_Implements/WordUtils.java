public class WordUtils {
    private SLList<String> words;

    public WordUtils(String[] w) {
        words = new SLList<>();
        for (int i = w.length - 1; i >= 0; i--) {
            words.addFirst(w[i]);
        }
    }

    public String longestString() {
        String longest = "";
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() > longest.length()) {
                longest = words.get(i);
            }
        }
        return longest;
    }
}
