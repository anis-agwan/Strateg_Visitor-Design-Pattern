package mySentenceAnalyzer.visitors;

import mySentenceAnalyzer.Elements.MyArrayList;
import mySentenceAnalyzer.Elements.MyElement;

public interface Visitor {
    
    public void visit(MyArrayList myElement);
}
