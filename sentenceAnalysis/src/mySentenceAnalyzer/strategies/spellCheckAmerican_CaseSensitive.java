package mySentenceAnalyzer.strategies;

public class spellCheckAmerican_CaseSensitive implements Strategy{

    @Override
    public String checkAndUpdate(String newWord, String oldWord, String sentences) {

        String sentence = sentences.replaceAll(oldWord.trim(), newWord.trim());

        return sentence;
    }
    
}
