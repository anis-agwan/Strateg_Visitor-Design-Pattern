package mySentenceAnalyzer.driver;

import java.io.File;
import java.util.Arrays;
import mySentenceAnalyzer.Elements.MyArrayList;
import mySentenceAnalyzer.Elements.MyElement;
import mySentenceAnalyzer.util.FileProcessor;
import mySentenceAnalyzer.util.FileProcessorInterface;
import mySentenceAnalyzer.util.MyLogger;
import mySentenceAnalyzer.visitors.KMostFrequentWordsVisitor;
import mySentenceAnalyzer.visitors.SpellCheckVisitor;
import mySentenceAnalyzer.visitors.Visitor;

/**
 * @author placeholder
 *
 */
public class Driver {

	public static String errorLogFileName;

	public static Integer kNumber;

	public static String inputFile;
	
	public static String english_american_spelling_inputFile;

	public static File kMostFile;

	public static File spellCheckFile;
	
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */

	    if (args.length != 6 || args[0].equals("${arg0}") || args[1].equals("${arg1}")
		|| args[2].equals("${arg2}") || args[3].equals("${arg3}") || args[4].equals("${arg4}")
		|| args[5].equals("${arg5}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 6 argumnets.");
			System.exit(0);
		}

		String kMostFileName = args[3];
		String spellCheckFileName = args[4];

		kMostFile = new File(kMostFileName);
		spellCheckFile = new File(spellCheckFileName);

		if(kMostFile.delete()) {
			//System.out.println("Deleted");
		} else {
			//System.out.println("Failed");
		}

		if(spellCheckFile.delete()) {
			//System.out.println("Deleted");
		} else {
			//System.out.println("Failed");
		}

		inputFile = args[0];

		english_american_spelling_inputFile = args[1];

		kNumber = Integer.parseInt(args[2]);

		// checking valid value of variable kNumber
		if ( kNumber <= 0){
			System.out.println("Pass valid value for K variable. K > 0");
			System.exit(1);
		}

		//setting debug level
		MyLogger.setDebugValue(Integer.parseInt(args[5]));

		// KMostFrequentWords Visitor object created
		Visitor kMostFrequentWordsVisitor = new KMostFrequentWordsVisitor();

		// SpellCheckVisitorCreated
		Visitor spellCheckVisitor = new SpellCheckVisitor();

		FileProcessorInterface fileProcessor = new FileProcessor();
		
		/**
		 * reading input file
		 */
        String inputData = fileProcessor.readInputFile(inputFile);

        MyElement myArrayList = new MyArrayList( Arrays.asList( inputData.split("\\.") ), inputData );

		myArrayList.accept(kMostFrequentWordsVisitor);

		System.out.println("\n\n-----------------------------------------------------------");

		myArrayList.accept(spellCheckVisitor);

		System.out.println("\nThank you! Have a Nice Day!");
	}
}
