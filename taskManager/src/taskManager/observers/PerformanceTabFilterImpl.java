package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.util.MyLogger;

/**
 * 
 * @author Anirudha Kadam
 * provides filter implementation for for {@link PerformanceTab} class
 * implements {@link DashboardFilter} interface
 */
public class PerformanceTabFilterImpl implements DashboardFilter {

	/**
	 * {@link PerformanceTabFilterImpl} class default constructor
	 */
	public PerformanceTabFilterImpl(){
		MyLogger.singletonMyLogger().printToStdOut(2, "PerformanceTabFilterImpl class default constructor has been called\n");
	}
	
	/**
	 * check(String filterString) provides filter implementation.
	 * returns true if filter string is for the particular observer
	 * @param filterString
	 * @return boolean
	 */
	public boolean check(String filterString){
		MyLogger.singletonMyLogger().printToStdOut(3, "PerformanceTabFilterImpl class check(String filterString) method has been called\n");
		if(filterString.startsWith(DashboardFilter.PERFORMANCE))
			return true;
		else
			return false;
	}

	/**
	 * {@link PerformanceTabFilterImpl} class toString() method
	 */
	public String toString() {
		MyLogger.singletonMyLogger().printToStdOut(3, "PerformanceTabFilterImpl class toString() method has been called\n");
		return "PerformanceTabFilterImpl [getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
