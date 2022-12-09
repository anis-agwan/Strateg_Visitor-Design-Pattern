package mySentenceAnalyzer.visitors;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

import mySentenceAnalyzer.Elements.MyArrayList;
import mySentenceAnalyzer.driver.Driver;
import mySentenceAnalyzer.util.FileDisplayInterface;
import mySentenceAnalyzer.util.Results;
import mySentenceAnalyzer.util.StdoutDisplayInterface;
import mySentenceAnalyzer.util.WordComparator;

public class KMostFrequentWordsVisitor implements Visitor{

    FileDisplayInterface fileDisplayInterface = new Results();

    StdoutDisplayInterface stdoutDisplayInterface = new Results();

    @Override
    public void visit(MyArrayList myElement) {

        Iterator<String> elemIterator = myElement.getIterator();

        Map<String, Integer> mp = new HashMap<String, Integer>();

        while(elemIterator.hasNext()) {
            String sentence = (String)elemIterator.next();

            String[] words = sentence.trim().split(" ");

            for (String word : words) {

                mp.put(word, mp.getOrDefault(word, 0)+1);
            }

        }

        PriorityQueue<Map.Entry<String, Integer> > pq = new PriorityQueue<>(new WordComparator());

        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
                pq.offer(entry);
        }

        System.out.println("Displaying " + Driver.kNumber + " most frequent words\n");        
        for (int i = 0; i < Driver.kNumber; i++) {

            if( pq.peek() != null){
                Map.Entry<String, Integer> word = pq.poll();
                
                stdoutDisplayInterface.displayKMostFreqWords(word.getKey(), word.getValue());
                fileDisplayInterface.writeKMostFreqWords(word.getKey(), word.getValue());
            }else{
                break;
            }
        }

    }
    
}
