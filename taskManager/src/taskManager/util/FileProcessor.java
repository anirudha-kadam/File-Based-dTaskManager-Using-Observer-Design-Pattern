package taskManager.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Anirudha Kadam
 * provides implementation of openFile(), readFromFile(), 
 * writeToFile(), closeFile() methods
 * implements {@link FileInterface}
 */
public class FileProcessor implements FileInterface{
	
	String inputFileName, outputFileName;
	
	private BufferedWriter bw = null;
	private BufferedReader br = null;
	
	/**
	 * {@link FileProcessor} class default constructor
	 */
	public FileProcessor(){
		MyLogger.singletonMyLogger().printToStdOut(2, "FileProcessor class default constructor has been called\n");
	}
	
	/**
	 * {@link FileProcessor} class parameterized constructor
	 * @param inputFileNameIn
	 * @param outputFileNameIn
	 */
	public FileProcessor(String inputFileNameIn, String outputFileNameIn){
		MyLogger.singletonMyLogger().printToStdOut(2, "FileProcessor class parameterized constructor has been called\n");
		inputFileName = inputFileNameIn;
		outputFileName = outputFileNameIn;
	}
	
	/**
	 * reads line from file
	 */
	public String readFromFile() {
		MyLogger.singletonMyLogger().printToStdOut(3, "FileProcessor class readFromFile() method has been called\n");
		String currentLine = null;
		try {
			currentLine = br.readLine();
		} catch (IOException e) {
			System.err.println("Caught IOException: "+e.getMessage());
			System.exit(0);
		}finally{
			
		}
		return currentLine;
	}

	/**
	 * writes to file
	 * @param output String
	 */
	public void writeToFile(String output) {
		MyLogger.singletonMyLogger().printToStdOut(3, "FileProcessor class writeToFile(String output) method has been called\n");
		try {
			bw.write(output);
		} catch (IOException e) {
			System.err.println("Caught IOException: "+e.getMessage());
			System.exit(0);
		}finally{
			
		}
		
	}
	

	/**
	 * {@link FileProcessor} class toString() method
	 */
	public String toString() {
		MyLogger.singletonMyLogger().printToStdOut(3, "FileProcessor class toString() method has been called\n");
		return "FileProcessor [inputFileName=" + inputFileName
				+ ", outputFileName=" + outputFileName + "]";
	}


	/**
	 * opens file to be read from
	 * @param br
	 */
	public void openInputFile() {
		MyLogger.singletonMyLogger().printToStdOut(3, "FileProcessor class openFile(BufferedReader br) method has been called\n");
		try {
			File file = new File(inputFileName);
			if(file.exists() && file.length() == 0){
				System.err.println("File is empty!");
				System.exit(0);
			}
			br = new BufferedReader(new FileReader(inputFileName));
		} catch (FileNotFoundException e) {
			System.err.println("Caught FileNotFoundException: "+e.getMessage());
			System.exit(0);
		}finally{
			
		}	
	}

	/**
	 * opens file to write to
	 * @param bw
	 */
	public void openOutputFile() {
		MyLogger.singletonMyLogger().printToStdOut(3, "FileProcessor class openFile(BufferedWriter bw) method has been called\n");
		try {
			bw = new BufferedWriter(new FileWriter(outputFileName,true));
		} catch (IOException e) {
			System.err.println("Caught IOException: "+e.getMessage());
			System.exit(0);
		}finally{
			
		}
	}

	/**
	 * closes file currently reading from
	 * @param br
	 */
	public void closeInputFile() {
		MyLogger.singletonMyLogger().printToStdOut(3, "FileProcessor class closeFile(BufferedReader br) method has been called\n");
		try {
			br.close();
		} catch (IOException e) {
			System.err.println("Caught IOException: "+e.getMessage());
			System.exit(0);
		}finally{
			
		}
	}

	/**
	 * closes file currently writing to
	 * @param bw
	 */
	public void closeOutputFile() {
		MyLogger.singletonMyLogger().printToStdOut(3, "FileProcessor class closeFile(BufferedWriter bw) method has been called\n");
		try {
			bw.close();
		} catch (IOException e) {
			System.err.println("Caught IOException: "+e.getMessage());
			System.exit(0);
		}finally{
			
		}
	}
	
}
