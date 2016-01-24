package taskManager.subject;

import java.util.HashMap; 
import java.util.Map;

import taskManager.filter.DashboardFilter;
import taskManager.observers.Observer;
import taskManager.observers.UpdateMessageFormat;
import taskManager.util.FileInterface;
import taskManager.util.FileProcessor;
import taskManager.util.MyLogger;

/**
 * 
 * @author Anirudha Kadam 
 * represents subject. 
 * implements {@link Subject} interface 
 */
public class DashBoardSubject implements Subject{

	/**
	 * Map to store Observer as a key and respective filter as value
	 */
	private Map<Observer, DashboardFilter> registeredObserverFilterMap = null;
	
	/**
	 * String represents state of a subject 
	 */
	private String tabsData = "";
	
	private FileInterface fileProcessor = null; 
	
	/**
	 * getter method for registeredObserverFilterMap
	 * @return Map
	 */
	public Map<Observer, DashboardFilter> getRegisteredObserverFilterMap() {
		return registeredObserverFilterMap;
	}

	/**
	 * {@link DashBoardSubject} class default constructor
	 */
	public DashBoardSubject(){
		MyLogger.singletonMyLogger().printToStdOut(2, "DashBoardSubject class default constructor has been called\n");
	}
	
	/**
	 * {@link DashBoardSubject} class parameterized constructor
	 * Initializes {@link FileProcessor} class object
	 * @param fileProcessorIn
	 */
	public DashBoardSubject(FileInterface fileProcessorIn) {
		MyLogger.singletonMyLogger().printToStdOut(2, "DashBoardSubject class parameterized constructor has been called\n");
		registeredObserverFilterMap = new HashMap<Observer, DashboardFilter>();
		fileProcessor = fileProcessorIn;
	}
	
	/**
	 * starts processing
	 * fetches input, Updates state, calls notifyAllObservers();
	 */
	public void startProcessing() {
		MyLogger.singletonMyLogger().printToStdOut(3, "DashBoardSubject class startProcessing() method has been called\n");
		fileProcessor.openInputFile();
		while((tabsData = fileProcessor.readFromFile()) != null){
			notifyAllObservers();
		}
		fileProcessor.closeInputFile();
	}
	

	/**
	 * registers observer with respective filter
	 * @param observer
	 * @param filter
	 */
	public void registerObserver(Observer observer, DashboardFilter filter) {
		MyLogger.singletonMyLogger().printToStdOut(3, "DashBoardSubject class registerObserver(Observer observer, DashboardFilter filter) method has been called\n");
		getRegisteredObserverFilterMap().put(observer, filter);
	}

	/**
	 * deletes observer
	 * @param observer
	 */
	public void deleteObserver(Observer observer) {
		MyLogger.singletonMyLogger().printToStdOut(3, "DashBoardSubject class deleteObserver(Observer observer) method has been called\n");
		getRegisteredObserverFilterMap().remove(observer);
	}

	/**
	 * notifies observers with filtered updates
	 */
	public void notifyAllObservers() {
		MyLogger.singletonMyLogger().printToStdOut(3, "DashBoardSubject class notifyAllObservers() method has been called\n");
		String tabs[] = tabsData.split("\\*");
		for(int i = 0; i < tabs.length; i++){
			int tabDecider = 3;
			for (Map.Entry<Observer, DashboardFilter> entry : getRegisteredObserverFilterMap().entrySet()) {
			    Observer observer = entry.getKey();
			    DashboardFilter filter = entry.getValue();
			    if(filter.check(tabs[i])){
			    	if(tabs.length == 1)
			    		tabDecider = 2;
			    	else if(i == 0)
			    		tabDecider = 0;
			    	else if(i == tabs.length - 1)
			    		tabDecider = 1;
			    	UpdateMessageFormat message = new UpdateMessageFormat(tabs[i], tabDecider);
			    	observer.update(message);
			    }
			}
		}
	}

	/**
	 * {@link DashBoardSubject} class toString() method
	 */
	public String toString() {
		MyLogger.singletonMyLogger().printToStdOut(3, "DashBoardSubject class toString() method has been called\n");
		return "DashBoardSubject [registeredObserverFilterMap="
				+ registeredObserverFilterMap + ", tabsData=" + tabsData + "]";
	}
	
	

}
