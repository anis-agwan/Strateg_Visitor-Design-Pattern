package mySentenceAnalyzer.strategies;

public class spellCheckAmerican_CaseInsensitive implements Strategy {

    @Override
    public String checkAndUpdate(String newWord, String oldWord, String sentences) {

        String sentence = sentences.replaceAll( "(?i)"+oldWord.trim(), newWord.trim());

        return sentence;
    }
    
}
