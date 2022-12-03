package mySentenceAnalyzer.visitors;

import mySentenceAnalyzer.Elements.MyElement;

public interface Visitor {
    
    public void visit(MyElement myElement);
}
