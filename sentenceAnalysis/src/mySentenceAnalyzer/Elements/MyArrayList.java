package mySentenceAnalyzer.Elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mySentenceAnalyzer.visitors.Visitor;

public class MyArrayList implements MyElement {

    List<String> myElement = new ArrayList<>();

    public MyArrayList(List<String> myElementIn){
        myElement = myElementIn;
    }

    public Iterator getIterator(){

        return myElement.iterator();
    }

    public void accept(Visitor visitor){
        visitor.visit(this);
    }
    
}
