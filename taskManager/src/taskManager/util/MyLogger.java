package taskManager.util;

/**
 * 
 * @author Anirudha Kadam
 * Logger class
 */
public class MyLogger {
	
	private static int DEBUG_VALUE = 0;
    
	private static MyLogger uniqueInstance = null;
	
	/**
	 * getter method for DEBUG_VALUE
	 * @return int DEBUG_VALUE
	 */
	public static int getDEBUG_VALUE() {
		MyLogger.singletonMyLogger().printToStdOut(3, "MyLogger class getDEBUG_VALUE() method has been called\n");
		return DEBUG_VALUE;
	}

	/**
	 * setter method for DEBUG_VALUE
	 * @return void
	 */
	public static void setDEBUG_VALUE(int dEBUG_VALUE) {
		MyLogger.singletonMyLogger().printToStdOut(3, "MyLogger class setDEBUG_VALUE(int dEBUG_VALUE) method has been called\n");
		DEBUG_VALUE = dEBUG_VALUE;
	}
	
	/**
	 * {@link MyLogger} class default constructor
	 */
	private MyLogger(){
		
	}
	
	/**
	 * method that returns single instance of a MyLogger class
	 * @return uniqueInstance
	 */
	public static MyLogger singletonMyLogger(){
		if(uniqueInstance == null){
			uniqueInstance = new MyLogger();
		}
		return uniqueInstance;
	} 
	
	/**
	 * logs message corresponding to current DEBUG_VALUE
	 * @param level
	 * @param debugMessage 
	 */
	public void printToStdOut(int debugLevel, String debugMessage){
		if(debugLevel == DEBUG_VALUE){
			System.out.print(debugMessage);
		}
	}

	/**
	 * {@link MyLogger} class toString() method
	 */
	public String toString() {
		MyLogger.singletonMyLogger().printToStdOut(3, "MyLogger class toString() method has been called\n");
		return "DEBUG_VALUE= "+getDEBUG_VALUE();
	}	
	
	
}
