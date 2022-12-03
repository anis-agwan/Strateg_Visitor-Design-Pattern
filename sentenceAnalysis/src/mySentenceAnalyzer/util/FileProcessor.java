
package mySentenceAnalyzer.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor implements FileProcessorInterface{
    
    public String readInputFile(String inputFile){

        String inputData = "";

        BufferedReader bufferedReader = null;

        try {

            File file = new File(inputFile);

            // FileReader class throws IOException
            FileReader fileReader = new FileReader(file);

            bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                // logic for each line breakdown
                // retrieveCourseInfo(line);
                inputData = inputData + line;
            }

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
        
        return inputData;
    }
}

