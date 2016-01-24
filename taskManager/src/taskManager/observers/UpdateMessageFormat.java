package taskManager.observers;

import taskManager.util.MyLogger;

/**
 * 
 * @author Anirudha Kadam
 * defines observer message format
 */
public class UpdateMessageFormat {
	
	/**
	 * Message for observer
	 */
	private String message;

	/**
	 * variable to decide Tab
	 */
	private int tabDecider;
	
	/**
	 * {@link UpdateMessageFormat} class default constructor
	 */
	public UpdateMessageFormat(){
		MyLogger.singletonMyLogger().printToStdOut(2, "UpdateMessageFormat class default constructor has been called\n");
	}
	
	/**
	 * {@link UpdateMessageFormat} class parameterized constructor
	 * @param messageIn
	 * @param tabDeciderIn
	 */
	public UpdateMessageFormat(String messageIn, int tabDeciderIn){
		MyLogger.singletonMyLogger().printToStdOut(2, "UpdateMessageFormat class parameterized constructor has been called\n");
		message = messageIn;
		tabDecider = tabDeciderIn;
	}
	
	/**
	 * getter method for message
	 * @return String message
	 */
	public String getMessage() {
		MyLogger.singletonMyLogger().printToStdOut(3, "UpdateMessageFormat class getMessage() method has been called\n");
		return message;
	}
	
	/**
	 * getter method for tabDecider
	 * @return int tabDecider
	 */
	public int getTabDecider() {
		MyLogger.singletonMyLogger().printToStdOut(3, "UpdateMessageFormat class getTabDecider() method has been called\n");
		return tabDecider;
	}

	/**
	 * {@link UpdateMessageFormat} class toString() method 
	 */
	public String toString() {
		MyLogger.singletonMyLogger().printToStdOut(3, "UpdateMessageFormat class toString() method has been called\n");
		return "message=" + message + ", tabDecider="+ tabDecider;
	}
	
	
}
