package taskManager.filter;

/**
 * 
 * @author Anirudha
 * provides check(String filterString) for filter implementation,
 * Static String constants as as filter criteria 
 */
public interface DashboardFilter {
	/**
	 * check(String filterString) provides filter implementation.
	 * returns true if filter string is for the particular observer
	 * @param filterString
	 * @return boolean
	 */
	public boolean check(String filterString);
	
	/**
	 * filter criteria for Performance tab
	 */
	public static final String PERFORMANCE = "Performance";
	
	/**
	 * filter criteria for Processes tab
	 */
	public static final String PROCESSES = "Processes";
	
	/**
	 * filter criteria for Users tab
	 */
	public static final String USERS = "Users";
}
