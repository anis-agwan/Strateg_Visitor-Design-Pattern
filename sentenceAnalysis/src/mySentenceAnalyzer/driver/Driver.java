package mySentenceAnalyzer.driver;

import java.util.Arrays;
import mySentenceAnalyzer.Elements.MyArrayList;
import mySentenceAnalyzer.util.FileProcessor;
import mySentenceAnalyzer.util.FileProcessorInterface;
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
	
	public static String english_american_spelling_inputFile;
	
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

		kNumber = Integer.parseInt(args[2]);

		english_american_spelling_inputFile = args[1];

		// KMostFrequentWords Visitor object created
		Visitor kMostFrequentWordsVisitor = new KMostFrequentWordsVisitor();

		// SpellCheckVisitorCreated
		Visitor spellCheckVisitor = new SpellCheckVisitor();

		FileProcessorInterface fileProcessor = new FileProcessor();
		
        String inputData = fileProcessor.readInputFile(args[0]);

        MyArrayList myArrayList = new MyArrayList( Arrays.asList( inputData.split("\\.") ), inputData );

		myArrayList.accept(kMostFrequentWordsVisitor);

		myArrayList.accept(spellCheckVisitor);

		System.out.println("\nThank you! Have a Nice Day!");
	}
}
