package mySentenceAnalyzer.Elements;

import java.util.Iterator;

import mySentenceAnalyzer.visitors.Visitor;

public interface MyElement {
    
    public void accept(Visitor visitor);

    public Iterator<String> getIterator();

    public String getAllSentenceString();


}
