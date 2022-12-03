package mySentenceAnalyzer.visitors;

import mySentenceAnalyzer.Elements.MyArrayList;

public interface Visitor {
    
    public void visit(MyArrayList myElement);
}
