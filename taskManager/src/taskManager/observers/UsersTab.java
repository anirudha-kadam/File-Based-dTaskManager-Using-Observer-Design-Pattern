package taskManager.observers;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

import taskManager.display.DisplayFile;
import taskManager.util.FileInterface;
import taskManager.util.FileProcessor;
import taskManager.util.MyLogger;

/**
 * 
 * @author Anirudha
 * Implements {@link Observer} {@link DisplayFile} interface
 */
public class UsersTab implements Observer, DisplayFile{

	/**
	 * List to store updates from subject
	 */
	private List<String[]> usersTabList = null;
	
	private FileInterface fileProcessor = null;
	
	private int indexAfterLastTab = 0;
	
	/**
	 * getter method for usersTabList
	 * @return List
	 */
	public List<String[]> getUsersTabList() {
		return usersTabList;
	}

	/**
	 * 
	 * {@link UsersTab} class default constructor
	 */
	public UsersTab(){
		MyLogger.singletonMyLogger().printToStdOut(2, "UsersTab class default constructor has been called\n");
	}
	
	/**
	 * {@link UsersTab} class parameterized constructor
	 * Initializes {@link FileProcessor} class object
	 * Initializes usersTabList object
	 * @param fileProcessorIn 
	 */
	public UsersTab(FileInterface fileProcessorIn){
		MyLogger.singletonMyLogger().printToStdOut(2, "UsersTab class parametarized constructor has been called\n");
		fileProcessor = fileProcessorIn;
		usersTabList = new ArrayList<String[]>();
	}
	
	/**
	 * processes update message and stores in List
	 * @param tabInfoIn
	 */
	private void processAndStoreInfo(String tabInfoIn){
		MyLogger.singletonMyLogger().printToStdOut(3, "UsersTab class processAndStoreInfo(String tabInfoIn) method has been called\n");
		String tabInfo = tabInfoIn.replaceFirst("Users:", "");
		//System.out.println(tabInfo);
		String users[] = tabInfo.split("-");
		String userInfo[] = null;
		indexAfterLastTab = getUsersTabList().size();
		for(int i = 0; i < users.length; i++){
			userInfo = users[i].split(":");
			getUsersTabList().add(userInfo);
		}
	}
	
	/**
	 * method to update message to observers
	 * @param message
	 */
	public void update(UpdateMessageFormat message) {
		MyLogger.singletonMyLogger().printToStdOut(3, "UsersTab class update(UpdateMessageFormat message) method has been called\n");
		processAndStoreInfo(message.getMessage());
		displayToDashBoard(message.getTabDecider());
	}

	/**
	 * method to format output and display to dashboard
	 * @param tabDecider decides whether to begin or end the tab
	 */
	public void displayToDashBoard(int tabDecider){
		MyLogger.singletonMyLogger().printToStdOut(3, "UsersTab class displayToDashBoard(int tabDecider) method has been called\n");
		StringBuilder displayInfo = new StringBuilder();
		Formatter f = new Formatter(displayInfo, Locale.getDefault());
		if(tabDecider == 0 || tabDecider == 2){
			displayInfo.append("---TAB(s) BEGIN---");
			displayInfo.append(System.getProperty("line.separator"));
		}
		displayInfo.append("---USERS---");
		displayInfo.append(System.getProperty("line.separator"));
		for(int i = indexAfterLastTab; i < getUsersTabList().size(); i++){
			String userName = getUsersTabList().get(i)[0];
			String userStatus = getUsersTabList().get(i)[1];
			f.format("%-5s%-1s%s%-2s%-7s%-1s%s", "User:", " ", userName, " ", "Status:", " ", userStatus);
			displayInfo.append(System.getProperty("line.separator"));
		}
		if(tabDecider == 1 || tabDecider == 2){
			displayInfo.append(System.getProperty("line.separator"));
			displayInfo.append("---TAB(s) END---");
			displayInfo.append(System.getProperty("line.separator"));
		}else{
			displayInfo.append(System.getProperty("line.separator"));
		}
		MyLogger.singletonMyLogger().printToStdOut(1, displayInfo.toString());
		fileProcessor.openOutputFile();
		fileProcessor.writeToFile(displayInfo.toString());
		fileProcessor.closeOutputFile();
	}

	/**
	 * {@link UsersTab} class toString() method
	 */
	public String toString() {
		MyLogger.singletonMyLogger().printToStdOut(3, "UsersTab class toString() method has been called\n");
		return getUsersTabList().toString();
	}
	
	
}
