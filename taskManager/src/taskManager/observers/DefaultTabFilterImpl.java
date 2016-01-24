package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.util.MyLogger;

/**
 * 
 * @author Anirudha Kadam
 * provides filter implementation for for {@link DefaultTab} class
 * implements {@link DashboardFilter} interface
 */
public class DefaultTabFilterImpl implements DashboardFilter{
	
	/**
	 * {@link DefaultTabFilterImpl} class default constructor
	 */
	public DefaultTabFilterImpl(){
		MyLogger.singletonMyLogger().printToStdOut(2, "DefaultTabFilterImpl class default constructor has been called\n");
	}

	/**
	 * check(String filterString) provides filter implementation.
	 * returns true if filter string is for the particular observer
	 * @param filterString
	 * @return boolean
	 */
	public boolean check(String filterString) {
		MyLogger.singletonMyLogger().printToStdOut(3, "DefaultTabFilterImpl class check(String filterString) method has been called\n");
		if(filterString.trim().isEmpty()){
			MyLogger.singletonMyLogger().printToStdOut(4, "empty line has been found\n");
			return true;
		}
		else
			return false;
	}

	/**
	 * {@link DefaultTabFilterImpl} class toString() method
	 */
	public String toString() {
		MyLogger.singletonMyLogger().printToStdOut(3, "DefaultTabFilterImpl class toString() method has been called\n");
		return "DefaultTabFilterImpl [getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
