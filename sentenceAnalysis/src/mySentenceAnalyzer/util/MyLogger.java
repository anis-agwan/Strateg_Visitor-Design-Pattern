
package mySentenceAnalyzer.util;

public class MyLogger{

    //enum values for different classes
    public static enum DebugLevel {NONE, CONSTRUCTOR, RESULTS, FILE_PROCESSOR, DRIVER};

    private static DebugLevel debugLevel;


    //switch cases for all the levels
    public static void setDebugValue (int levelIn) {
        switch (levelIn) {
        case 2: debugLevel = DebugLevel.RESULTS; break;
        case 1: debugLevel = DebugLevel.DRIVER; break;
        default: debugLevel = DebugLevel.NONE; break;
        }
    }

    public static void setDebugValue (DebugLevel levelIn) {
	    debugLevel = levelIn;
    }

    public static void writeMessage (String     message  ,
                                     DebugLevel levelIn ) {
        if ( levelIn == DebugLevel.DRIVER)
            System.out.println(message);
        

        if (levelIn == debugLevel)
            System.out.println(message);
    }

    public String toString() {
	    return "The debug level has been set to the following " + debugLevel;
    }
}
