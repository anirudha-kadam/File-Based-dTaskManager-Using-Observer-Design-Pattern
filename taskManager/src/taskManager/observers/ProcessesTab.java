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
 * @author Anirudha Kadam
 * Implements {@link Observer} {@link DisplayFile} interface
 */
public class ProcessesTab implements Observer, DisplayFile{

	/**
	 * List to store updates from subject
	 */
	private List<String[]> processesTabList = null;
	
	private FileInterface fileProcessor = null;
	
	private int indexAfterLastTab = 0;
	
	/**
	 * getter method for processesTabList
	 * @return List
	 */
	public List<String[]> getProcessesTabList() {
		MyLogger.singletonMyLogger().printToStdOut(3, "ProcessesTab class getProcessesTabList() method has been called\n");
		return processesTabList;
	}

	/**
	 * 
	 * {@link ProcessesTab} class default constructor
	 */
	public ProcessesTab(){
		MyLogger.singletonMyLogger().printToStdOut(2, "ProcessesTab class default constructor has been called\n");
	}
	
	/**
	 * {@link ProcessesTab} class parameterized constructor
	 * Initializes {@link FileProcessor} class object
	 * Initializes processesTabList object
	 * @param fileProcessorIn 
	 */
	public ProcessesTab(FileInterface fileProcessorIn){
		MyLogger.singletonMyLogger().printToStdOut(2, "ProcessesTab class parameterized constructor has been called\n");
		fileProcessor = fileProcessorIn;
		processesTabList = new ArrayList<String[]>();
	}
	
	/**
	 * processes update message and stores in List
	 * @param tabInfoIn
	 */
	private void processAndStoreInfo(String tabInfoIn){
		MyLogger.singletonMyLogger().printToStdOut(3, "ProcessesTab class processAndStoreInfo(String tabInfoIn) method has been called\n");
		String tabInfo = tabInfoIn.replaceFirst("Processes:", "");
		String processes[] = tabInfo.split("-");
		String processInfo[] = null;
		indexAfterLastTab = getProcessesTabList().size();
		for(int i = 0; i < processes.length; i++){
			processInfo = processes[i].split(":");
			getProcessesTabList().add(processInfo);
		}
	}
	
	/**
	 * method to update message to observers
	 * @param message
	 */
	public void update(UpdateMessageFormat message) {
		MyLogger.singletonMyLogger().printToStdOut(3, "ProcessesTab class update(UpdateMessageFormat message) method has been called\n");
		processAndStoreInfo(message.getMessage());
		displayToDashBoard(message.getTabDecider());
	}
	
	/**
	 * method to format output and display to dashboard
	 * @param tabDecider decides whether to begin or end the tab
	 */
	public void displayToDashBoard(int tabDecider){
		MyLogger.singletonMyLogger().printToStdOut(3, "ProcessesTab class displayToDashBoard(int tabDecider) method has been called\n");
		StringBuilder displayInfo = new StringBuilder();
		Formatter f = new Formatter(displayInfo, Locale.getDefault());
		if(tabDecider == 0 || tabDecider == 2){
			displayInfo.append("---TAB(s) BEGIN---");
			displayInfo.append(System.getProperty("line.separator"));
		}
		displayInfo.append("---PROCESSES---");
		displayInfo.append(System.getProperty("line.separator"));
		f.format("%5s%-1s%-7s%-9s%-8s%-1s%4s%-1s%4s%n","PID", " ", "COMMAND", " ", "USER", " ", "%CPU", " ", "%MEM");
		for(int i = indexAfterLastTab; i < getProcessesTabList().size(); i++){
			String pid = getProcessesTabList().get(i)[0];
			String command = getProcessesTabList().get(i)[1];
			String user = getProcessesTabList().get(i)[2];
			String percCPU = getProcessesTabList().get(i)[3];
			String percMem = getProcessesTabList().get(i)[4];
			f.format("%5s%-1s%-11s%-5s%-8s%-1s%4s%-1s%4s", pid, " ", command, " ", user, " ", percCPU, " ", percMem);
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
	 * {@link ProcessesTab} class toString() method
	 */
	public String toString() {
		MyLogger.singletonMyLogger().printToStdOut(3, "ProcessesTab class toString() method has been called\n");
		return getProcessesTabList().toString();
	}

	
}
