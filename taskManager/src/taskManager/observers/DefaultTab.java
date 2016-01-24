package taskManager.observers;

import taskManager.display.DisplayFile;
import taskManager.util.FileInterface;
import taskManager.util.FileProcessor;
import taskManager.util.MyLogger;

/**
 * @author Anirudha Kadam
 * Provides implementation to handle updates irrelevant to  registered observers
 * implements {@link Observer}, {@link DisplayFile} interface
 */
public class DefaultTab implements  Observer, DisplayFile{

	private FileInterface fileProcessor = null;
	
	/**
	 * {@link DefaultTab} class default constructor
	 */
	public DefaultTab(){
		MyLogger.singletonMyLogger().printToStdOut(2, "DefaultTab class default constructor has been called\n");
	}
	
	/**
	 * {@link DefaultTab} class parameterized constructor. 
	 * Initializes {@link FileProcessor} class object
	 * @param fileProcessorIn
	 */
	public DefaultTab(FileInterface fileProcessorIn){
		MyLogger.singletonMyLogger().printToStdOut(2, "DefaultTab class parameterized constructor has been called\n");
		fileProcessor = fileProcessorIn;
	}
	
	/**
	 * method to update message to observers
	 * @param message
	 */
	public void update(UpdateMessageFormat message) {
		MyLogger.singletonMyLogger().printToStdOut(3, "DefaultTab class update(UpdateMessageFormat message) method has been called\n");
		displayToDashBoard(message.getTabDecider());
	}

	/**
	 * method to format output and display to dashboard
	 * @param tabDecider decides whether to begin or end the tab
	 */
	public void displayToDashBoard(int tabDecider){
		MyLogger.singletonMyLogger().printToStdOut(3, "DefaultTab class displayToDashBoard(int tabDecider) method has been called\n");
		String displayInfo = "---TAB(s) BEGIN---"+System.getProperty("line.separator") +"---TAB(s) END---"+System.getProperty("line.separator");
		MyLogger.singletonMyLogger().printToStdOut(1, displayInfo);
		fileProcessor.openOutputFile();
		fileProcessor.writeToFile(displayInfo);
		fileProcessor.closeOutputFile();
	}

	/**
	 * {@link DefaultTab} class toString() method
	 */
	public String toString() {
		MyLogger.singletonMyLogger().printToStdOut(3, "DefaultTab class toString() method has been called\n");
		return "This is a DefaultTab class object";
	}
	
	
}
