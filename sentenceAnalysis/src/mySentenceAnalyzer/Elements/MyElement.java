package mySentenceAnalyzer.Elements;

import mySentenceAnalyzer.visitors.Visitor;

public interface MyElement {
    
    public void accept(Visitor visitor);

}
