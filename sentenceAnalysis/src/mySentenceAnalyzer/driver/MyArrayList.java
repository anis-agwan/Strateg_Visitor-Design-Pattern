package mySentenceAnalyzer.driver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mySentenceAnalyzer.visitors.Visitor;

public class MyArrayList {

    List<String> myElement = new ArrayList<>();

    public Iterator getIterator(){

        return myElement.iterator();
    }

    public void accept(Visitor visitor){
        // call visitor method and pass this in the argument
    }
    
    
}