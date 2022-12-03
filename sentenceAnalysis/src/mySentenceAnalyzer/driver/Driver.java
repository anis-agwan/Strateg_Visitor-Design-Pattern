package mySentenceAnalyzer.driver;

/**
 * @author placeholder
 *
 */
public class Driver {

	public static String errorLogFileName;

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

		System.out.println("Hello ! Lets start the assignment. Args length = "+ args.length);
	}
}
