package mySentenceAnalyzer.Elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mySentenceAnalyzer.visitors.Visitor;

public class MyArrayList implements MyElement {

    private List<String> myElement = new ArrayList<>();

    private String allSentenceString;

    public MyArrayList(List<String> myElementIn, String allSentenceStringIn){
        myElement = myElementIn;
        allSentenceString = allSentenceStringIn;
    }

    public String getAllSentenceString(){
        return allSentenceString;
    }

    public Iterator<String> getIterator(){

        return myElement.iterator();
    }

    public void accept(Visitor visitor){
        visitor.visit(this);
    }
    
}
