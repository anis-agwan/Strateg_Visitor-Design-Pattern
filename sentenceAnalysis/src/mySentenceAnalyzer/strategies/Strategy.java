package mySentenceAnalyzer.strategies;

public interface Strategy {
    
    public String checkAndUpdate(String newWord, String oldWord, String sentences);
}
