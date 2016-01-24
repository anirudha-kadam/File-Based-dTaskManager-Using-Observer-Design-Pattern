package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.util.MyLogger;

/**
 * 
 * @author Anirudha Kadam
 * provides filter implementation for for {@link UsersTab} class
 * implements {@link DashboardFilter} interface
 */
public class UsersTabFilterImpl implements DashboardFilter{
	
	/**
	 * {@link UsersTabFilterImpl} class default constructor
	 */
	public UsersTabFilterImpl(){
		MyLogger.singletonMyLogger().printToStdOut(2, "UsersTabFilterImpl class default constructor has been called\n");
	}
	

	/**
	 * check(String filterString) provides filter implementation.
	 * returns true if filter string is for the particular observer
	 * @param filterString
	 * @return boolean
	 */
	public boolean check(String filterString){
		MyLogger.singletonMyLogger().printToStdOut(3, "UsersTabFilterImpl class check(String filterString) method has been called\n");
		if(filterString.startsWith(DashboardFilter.USERS))
			return true;
		else
			return false;
	}

	/**
	 * {@link UsersTabFilterImpl} class toString() method
	 */
	public String toString() {
		MyLogger.singletonMyLogger().printToStdOut(3, "UsersTabFilterImpl class toString() method has been called\n");
		return "UsersTabFilterImpl [getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
