package taskManager.observers;

/**
 * 
 * @author Anirudha Kadam
 * provides update(UpdateMessageFormat message) method to update observers 
 */
public interface Observer {
	
	/**
	 * method to update message to observers
	 * @param message
	 */
	public void update(UpdateMessageFormat message);
}
