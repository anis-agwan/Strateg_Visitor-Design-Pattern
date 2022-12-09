package mySentenceAnalyzer.visitors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import mySentenceAnalyzer.Elements.MyArrayList;
import mySentenceAnalyzer.driver.Driver;
import mySentenceAnalyzer.strategies.Strategy;
import mySentenceAnalyzer.strategies.spellCheckAmerican_CaseInsensitive;
import mySentenceAnalyzer.strategies.spellCheckAmerican_CaseSensitive;
import mySentenceAnalyzer.util.FileDisplayInterface;
import mySentenceAnalyzer.util.Results;
import mySentenceAnalyzer.util.StdoutDisplayInterface;

public class SpellCheckVisitor implements Visitor{

    FileDisplayInterface fileDisplayInterface = new Results();

    StdoutDisplayInterface stdoutDisplayInterface = new Results();

    Strategy caseSensitive_strategy = new spellCheckAmerican_CaseSensitive();

    Strategy caseInsensitive_strategy = new spellCheckAmerican_CaseInsensitive();

    @Override
    public void visit(MyArrayList myElement) {

        System.out.println("\n\nDisplaying " + Driver.inputFile + " file content after applying 2 strategies.");
        System.out.println("1. Case sensitive checking\n");

        checkSpellFromInputFileAndUpdate(Driver.english_american_spelling_inputFile, caseInsensitive_strategy, myElement.getAllSentenceString());

		System.out.println("\n-----------------------------------------------------------");
        System.out.println("2. Case In-sensitive checking\n");

        checkSpellFromInputFileAndUpdate(Driver.english_american_spelling_inputFile, caseSensitive_strategy, myElement.getAllSentenceString());
        
    }

    private void checkSpellFromInputFileAndUpdate(String inputFileName, Strategy strategy, String allSentenceStringIn){

        BufferedReader bufferedReader = null;

        try {

            File file = new File(inputFileName);

            // FileReader class throws IOException
            FileReader fileReader = new FileReader(file);

            bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                
                // logic for each line breakdown

                String[] english_american_words = line.split(":");

                //traverse over input file for each word and then replace it with other word
                allSentenceStringIn = strategy.checkAndUpdate(english_american_words[1], english_american_words[0], allSentenceStringIn);
            
            }

            stdoutDisplayInterface.displaySpellCheck(allSentenceStringIn);
            fileDisplayInterface.writeSpellCheck(allSentenceStringIn);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            
            System.out.println("----------------Exiting System due to Exception");
            // exit the system
            System.exit(1);
        }catch (IOException io) {
            io.printStackTrace();
            
            System.out.println("----------------Exiting System due to Exception");
            // exit the system
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            
            System.out.println("----------------Exiting System due to Exception");
            // exit the system
            System.exit(1);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException io) {
                    io.printStackTrace();
                   
                    System.out.println("----------------Exiting System due to Exception");
                    // exit the system
                    System.exit(1);
                }
            }
        }
        
    }
    
}
