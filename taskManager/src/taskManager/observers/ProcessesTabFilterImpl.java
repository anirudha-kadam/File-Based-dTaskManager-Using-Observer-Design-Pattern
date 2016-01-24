package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.util.MyLogger;

/**
 * 
 * @author Anirudha Kadam
 * provides filter implementation for for {@link ProcessesTab} class
 * implements {@link DashboardFilter} interface
 */
public class ProcessesTabFilterImpl implements DashboardFilter{

	/**
	 * {@link ProcessesTabFilterImpl} class default constructor
	 */
	public ProcessesTabFilterImpl(){
		MyLogger.singletonMyLogger().printToStdOut(2, "ProcessesTabFilterImpl class default constructor has been called\n");
	}
	
	/**
	 * check(String filterString) provides filter implementation.
	 * returns true if filter string is for the particular observer
	 * @param filterString
	 * @return boolean
	 */
	public boolean check(String filterString){
		MyLogger.singletonMyLogger().printToStdOut(3, "ProcessesTabFilterImpl class check(String filterString) method has been called\n");
		if(filterString.startsWith(DashboardFilter.PROCESSES))
			return true;
		else
			return false;
	}

	/**
	 * {@link ProcessesTabFilterImpl} class toString() method
	 */
	public String toString() {
		MyLogger.singletonMyLogger().printToStdOut(3, "ProcessesTabFilterImpl class toString() method has been called\n");
		return "ProcessesTabFilterImpl [getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
