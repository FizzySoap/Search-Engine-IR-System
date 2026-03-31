
package searchengine;

public class TextProcessor {
 
    private MyList<String> stopWords;

    public TextProcessor(MyList<String> stopWords) {
        this.stopWords = stopWords;
    }

    public MyList<String> processText(String text) {
        MyList<String> words = new MyList<>(10);
        text = text.toLowerCase().replaceAll("[^a-z0-9\\s]", ""); // Remove punctuation
        String[] splitWords = text.split("\\s+");

        for (String word : splitWords) {
            if (!isStopWord(word) && !word.isEmpty()) {
                words.add(word);
           
            }
        }
        return words;
    }

    private boolean isStopWord(String word) {
        for (int i = 0; i < stopWords.size(); i++) {
            if (stopWords.get(i).equals(word)) return true;
        }
        return false;
    }
}

