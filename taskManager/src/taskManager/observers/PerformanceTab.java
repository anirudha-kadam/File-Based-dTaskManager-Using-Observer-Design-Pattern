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
public class PerformanceTab implements Observer, DisplayFile{

	/**
	 * List to store updates from subject
	 */
	private List<String[]> performanceTabList = null; 
	
	private FileInterface fileProcessor = null;
	
	private int indexAfterLastTab = 0;
			
	/**
	 * getter method for performanceTabList
	 * @return List
	 */
	public List<String[]> getPerformanceTabList() {
		MyLogger.singletonMyLogger().printToStdOut(3, "PerformanceTab class List<String[]> getPerformanceTabList() method has been called\n");
		return performanceTabList;
	}
	
	/**
	 * 
	 * {@link PerformanceTab} class default constructor
	 */
	public PerformanceTab(){
		MyLogger.singletonMyLogger().printToStdOut(2, "PerformanceTab class default constructor has been called\n");
	}

	/**
	 * {@link PerformanceTab} class parameterized constructor
	 * Initializes {@link FileProcessor} class object
	 * Initializes performanceTabList object
	 * @param fileProcessorIn 
	 */
	public PerformanceTab(FileInterface fileProcessorIn){
		MyLogger.singletonMyLogger().printToStdOut(2, "PerformanceTab class parameterized constructor has been called\n");
		fileProcessor = fileProcessorIn;
		performanceTabList = new ArrayList<String[]>();
	}
	
	/**
	 * processes update message and stores in List
	 * @param tabInfoIn
	 */
	private void processAndStoreInfo(String tabInfoIn){
		MyLogger.singletonMyLogger().printToStdOut(3, "PerformanceTab class processAndStoreInfo(String tabInfoIn) method has been called\n");
		String tabInfo = tabInfoIn.replaceFirst("Performance:", "");
		String performance[] = tabInfo.split("-");
		String performanceInfo[] = null;
		indexAfterLastTab = getPerformanceTabList().size();
		for(int i = 0; i < performance.length; i++){
			performanceInfo = performance[i].split(":");
			getPerformanceTabList().add(performanceInfo);
		}
	}
	
	/**
	 * method to update message to observers
	 * @param message
	 */
	public void update(UpdateMessageFormat message) {
		MyLogger.singletonMyLogger().printToStdOut(3, "PerformanceTab class update(UpdateMessageFormat message) method has been called\n");
		processAndStoreInfo(message.getMessage());
		displayToDashBoard(message.getTabDecider());
	}

	/**
	 * method to format output and display to dashboard
	 * @param tabDecider decides whether to begin or end the tab
	 */
	public void displayToDashBoard(int tabDecider){
		MyLogger.singletonMyLogger().printToStdOut(3, "PerformanceTab class displayToDashBoard(int tabDecider) method has been called\n");
		StringBuilder displayInfo = new StringBuilder();
		Formatter f = new Formatter(displayInfo, Locale.getDefault());
		if(tabDecider == 0 || tabDecider == 2){
			displayInfo.append("---TAB(s) BEGIN---");
			displayInfo.append(System.getProperty("line.separator"));
		}
		displayInfo.append("---PERFORMANCE---");
		displayInfo.append(System.getProperty("line.separator"));
		for(int i = indexAfterLastTab; i < getPerformanceTabList().size(); i++){
			String totalMem = getPerformanceTabList().get(i)[0];
			String usedMem = getPerformanceTabList().get(i)[1];
			String freeMem = getPerformanceTabList().get(i)[2];
			String cachedMem = getPerformanceTabList().get(i)[3];
			String cpuIdle = getPerformanceTabList().get(i)[4];
			String cpuUsrLevel = getPerformanceTabList().get(i)[5];
			String cpuSysLevel = getPerformanceTabList().get(i)[6];
			f.format("%-13s%-1s%s%-2s%-12s%-1s%s%-2s%-13s%-1s%s%-2s%-15s%-1s%s", "Memory Total:", " ", totalMem, " ", "Memory Used:", " ", usedMem, " ", "Memory  Free:", " ", freeMem,
					 " ", "Memory  Cached:", " ", cachedMem);
			displayInfo.append(System.getProperty("line.separator"));
			f.format("%-9s%-1s%s%-2s%-15s%-1s%s%-2s%-17s%-1s%s", "CPU Idle:", " ", cpuIdle, " ", "CPU User Level:", " ", cpuUsrLevel,
					 " ", "CPU System Level:", " ", cpuSysLevel);
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
	 * {@link PerformanceTab} class toString() method
	 */
	public String toString() {
		MyLogger.singletonMyLogger().printToStdOut(3, "PerformanceTab class toString() method has been called\n");
		return getPerformanceTabList().toString();
	}
	
	
}
