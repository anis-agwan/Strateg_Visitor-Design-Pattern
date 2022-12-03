package mySentenceAnalyzer.visitors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

import mySentenceAnalyzer.Elements.MyArrayList;
import mySentenceAnalyzer.driver.Driver;
import mySentenceAnalyzer.object.WordItem;
import mySentenceAnalyzer.util.WordComparator;

public class KMostFrequentWordsVisitor implements Visitor{

    @Override
    public void visit(MyArrayList myElement) {
        // TODO Auto-generated method stub
        Iterator elemIterator = myElement.getIterator();

        Map<String, Integer> mp = new HashMap<String, Integer>();

        // PriorityQueue<WordItem> wordItems = new PriorityQueue<>(new WordComparator());

        while(elemIterator.hasNext()) {
            String sentence = (String)elemIterator.next();

            String[] words = sentence.trim().split(" ");

            // words -> arraylist 

            for (String word : words) {

                mp.put(word, mp.getOrDefault(word, 0)+1);

                
            }

            // if (wordItems.size() > -1) {
            //     System.out.println("SIZE GREATER THAN 0\n");
                
            // }

        }

        PriorityQueue<Map.Entry<String, Integer> > pq = new PriorityQueue<>(new WordComparator());

        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
                pq.offer(entry);
        }

        for (int i = 0; i < Driver.kNumber; i++) {

            Map.Entry<String, Integer> wordIt = pq.poll();
            System.out.println(wordIt.getKey() + ": " + wordIt.getValue());
        }

    }
    
}
