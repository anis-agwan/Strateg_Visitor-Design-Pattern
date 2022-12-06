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

public class SpellCheckVisitor implements Visitor{

    Strategy caseSensitive_strategy = new spellCheckAmerican_CaseSensitive();

    Strategy caseInsensitive_strategy = new spellCheckAmerican_CaseInsensitive();

    @Override
    public void visit(MyArrayList myElement) {

        // checkSpellFromInputFileAndUpdate(Driver.english_american_spelling_inputFile, caseInsensitive_strategy, myElement.getAllSentenceString());

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

                // System.out.println(english_american_words[0] + " -> " + english_american_words[1]);
                
                //traverse over input file for each word and then replace it with other word
                allSentenceStringIn = strategy.checkAndUpdate(english_american_words[1], english_american_words[0], allSentenceStringIn);
            
            }

            System.out.println(allSentenceStringIn);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // write this error in error log file
            // fileDisplayInterface.writeErrorLog(
            //         "Error : File "+ fileName +" could not be found and throws Exception = " + e.getMessage());
            System.out.println("----------------Exiting System due to Exception");
            // exit the system
            System.exit(1);
        }catch (IOException io) {
            io.printStackTrace();
            // write this error in error log file
            // fileDisplayInterface
            //         .writeErrorLog("Error : File Reader could not read file properly and thows IOException.");
            System.out.println("----------------Exiting System due to Exception");
            // exit the system
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            // write this error in error log file
            // fileDisplayInterface.writeErrorLog(
            //         "Error : File Reader could not read file properly and throws Exception = " + e.getMessage());
            System.out.println("----------------Exiting System due to Exception");
            // exit the system
            System.exit(1);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException io) {
                    io.printStackTrace();
                    // write this error in error log file
                    // fileDisplayInterface
                    //         .writeErrorLog("Error : Buffered Reader close method could not close properly.");
                    System.out.println("----------------Exiting System due to Exception");
                    // exit the system
                    System.exit(1);
                }
            }
        }
        

        // write this string to output file
    }
    
}
