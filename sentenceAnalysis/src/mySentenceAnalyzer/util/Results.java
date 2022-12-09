package mySentenceAnalyzer.util;

import mySentenceAnalyzer.driver.Driver;
import mySentenceAnalyzer.util.MyLogger.DebugLevel;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	
    @Override
    public void displayKMostFreqWords(String word, int count) {
        MyLogger.writeMessage("LOGGER: "+word + ": " + count, DebugLevel.RESULTS);
    }

    @Override
    public void displaySpellCheck(String sentences) {
        MyLogger.writeMessage("LOGGER: \n"+sentences, DebugLevel.RESULTS);
    }

    @Override
    public void writeKMostFreqWords(String word, int count) {

        FileWriter fileWriter = null;;

        BufferedWriter bufferWriter = null;
        try {

            fileWriter = new FileWriter(Driver.kMostFile, true);
            bufferWriter = new BufferedWriter(fileWriter);
                
            // checking if there are no empty words written in file
            if( word.trim() != ""){

                String resString = String.format("%s: %d", word, count);

                bufferWriter.write(resString);
                bufferWriter.write("\n");
            }

            bufferWriter.close();
            fileWriter.close();

        } catch (FileNotFoundException err) {
            err.printStackTrace();

            System.out.println("----------------Exiting System due to Exception");
            // exit the system
            System.exit(1);
        } catch (IOException err) {
            err.printStackTrace();

            System.out.println("----------------Exiting System due to Exception");
            // exit the system
            System.exit(1);
        }catch (Exception e) {
            e.printStackTrace();
            
            System.out.println("----------------Exiting System due to Exception");
            // exit the system
            System.exit(1);
        } finally {
            if (bufferWriter != null) {
                try {
                    bufferWriter.close();
                } catch (IOException io) {
                    io.printStackTrace();
                   
                    System.out.println("----------------Exiting System due to Exception");
                    // exit the system
                    System.exit(1);
                }
            }
        }
    }

    @Override
    public void writeSpellCheck(String sentences) {

        FileWriter fileWriter = null;

        BufferedWriter bufferWriter = null;

        try {

            fileWriter = new FileWriter(Driver.spellCheckFile, true);
            bufferWriter = new BufferedWriter(fileWriter);

            bufferWriter.write(sentences);
            bufferWriter.write("\n\n");
            
            bufferWriter.close();
            fileWriter.close();

        } catch (FileNotFoundException err) {
            err.printStackTrace();

            System.out.println("----------------Exiting System due to Exception");
            // exit the system
            System.exit(1);
        } catch (IOException err) {
            err.printStackTrace();

            System.out.println("----------------Exiting System due to Exception");
            // exit the system
            System.exit(1);
        }catch (Exception e) {
            e.printStackTrace();
            
            System.out.println("----------------Exiting System due to Exception");
            // exit the system
            System.exit(1);
        } finally {
            if (bufferWriter != null) {
                try {
                    bufferWriter.close();
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
