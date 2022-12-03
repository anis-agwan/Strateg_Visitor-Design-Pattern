package mySentenceAnalyzer.object;

public class WordItem {
    private String word;
    private int count;

    public WordItem(String wordString, int wordCount) {
        word = wordString;
        count = wordCount;
    }

    public String getWord() {
        return word;
    }    

    public int getWordCount() {
        return count;
    }

    public void setWord(String newWord) {
        word = newWord;
    }

    public void setWordCount(int newCount) {
        count = newCount;
    }

}
