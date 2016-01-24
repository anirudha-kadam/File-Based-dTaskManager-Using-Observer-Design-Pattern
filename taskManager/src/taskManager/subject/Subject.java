package taskManager.subject;

import taskManager.filter.DashboardFilter;
import taskManager.observers.Observer;

/**
 * 
 * @author Anirudha Kadam
 * provides methods registerObserver(Observer observer, DashboardFilter filter),
 * deleteObserver(Observer observer), notifyAllObservers();
 */
public interface Subject {
	
	/**
	 * registers observer with respective filter
	 * @param observer
	 * @param filter
	 */
	public void registerObserver(Observer observer, DashboardFilter filter);
	
	/**
	 * deletes observer
	 * @param observer
	 */
	public void deleteObserver(Observer observer);
	
	/**
	 * notifies observers with filtered updates
	 */
	public void notifyAllObservers();
}
