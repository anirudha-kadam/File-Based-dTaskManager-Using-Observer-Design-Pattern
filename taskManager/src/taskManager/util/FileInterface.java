package taskManager.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 * 
 * @author Anirudha
 * provides interface for methods related to file operations
 */
public interface FileInterface {

	/**
	 * reads a line from file
	 * @return
	 */
	public String readFromFile();
	
	/**
	 * writes to file
	 * @param output
	 */
	public void writeToFile(String output);
	
	/**
	 * opens file to be read from
	 * @param br
	 */
	public void openInputFile();
	
	/**
	 * opens file to write to
	 * @param bw
	 */
	public void openOutputFile();
	
	/**
	 * closes file currently reading from
	 * @param br
	 */
	public void closeInputFile();
	
	/**
	 * closes file currently writing to
	 * @param bw
	 */
	public void closeOutputFile();
	
}
