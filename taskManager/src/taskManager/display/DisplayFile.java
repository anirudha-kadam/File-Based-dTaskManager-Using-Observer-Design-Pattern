package taskManager.display;

/**
 * @author Anirudha Kadam
 * provides method displayToDashBoard(int tabDecider) to display info to dashboard
 */
public interface DisplayFile {
	
	/**
	 * method to format output and display to dashboard
	 * @param tabDecider decides whether to begin or end the tab
	 */
	public void displayToDashBoard(int tabDecider);
}
