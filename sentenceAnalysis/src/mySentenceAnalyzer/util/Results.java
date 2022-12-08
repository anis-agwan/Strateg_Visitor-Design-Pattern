package mySentenceAnalyzer.util;

import mySentenceAnalyzer.driver.Driver;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	
    public void displayKMostFreqWords(String word, int count) {
        System.out.println(word + ": " + count);
    }

    public void displaySpellCheck(String sentences) {
        System.out.println(sentences);
        System.out.println("\n\n");
    }

    public void writeKMostFreqWords(String word, int count) {
        try {
            //System.out.println(Driver.kMostFile.getName());
            //new FileWriter(Driver.kMostFile, false).close();
            FileWriter fileWriter = new FileWriter(Driver.kMostFile, true);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            //System.out.println(resString);
            String resString = String.format("%s: %d", word, count);
            bufferWriter.write(resString);
            bufferWriter.write("\n");
            bufferWriter.close();
            fileWriter.close();

        } catch (FileNotFoundException err) {
            //errorCheck.logError(errors, err.toString());
            String errMessage = err.toString() + " : " + err.getStackTrace()[4];
            //errorCheck.printError(errMessage.toString());
        } catch (IOException err) {
            //errorCheck.logError(errors, err.toString());
            String errMessage = err.toString() + " : " + err.getStackTrace()[4];
            //errorCheck.printError(errMessage.toString());
        }
    }

    public void writeSpellCheck(String sentences) {
        try {
            //System.out.println(Driver.kMostFile.getName());
            //new FileWriter(Driver.kMostFile, false).close();
            FileWriter fileWriter = new FileWriter(Driver.spellCheckFile, true);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            //System.out.println(resString);
            bufferWriter.write(sentences);
            bufferWriter.write("\n\n");
            bufferWriter.close();
            fileWriter.close();

        } catch (FileNotFoundException err) {
            //errorCheck.logError(errors, err.toString());
            String errMessage = err.toString() + " : " + err.getStackTrace()[4];
            //errorCheck.printError(errMessage.toString());
        } catch (IOException err) {
            //errorCheck.logError(errors, err.toString());
            String errMessage = err.toString() + " : " + err.getStackTrace()[4];
            //errorCheck.printError(errMessage.toString());
        }
    }



}
