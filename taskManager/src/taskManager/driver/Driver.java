package taskManager.driver;

import taskManager.filter.DashboardFilter;
import taskManager.observers.DefaultTab;
import taskManager.observers.DefaultTabFilterImpl;
import taskManager.observers.Observer;
import taskManager.observers.PerformanceTab;
import taskManager.observers.PerformanceTabFilterImpl;
import taskManager.observers.ProcessesTab;
import taskManager.observers.ProcessesTabFilterImpl;
import taskManager.observers.UsersTab;
import taskManager.observers.UsersTabFilterImpl;
import taskManager.subject.DashBoardSubject;
import taskManager.subject.Subject;
import taskManager.util.FileInterface;
import taskManager.util.FileProcessor;
import taskManager.util.MyLogger;

/**
 * 
 * @author Anirudha Kadam
 * {@link Driver} class responsible to validate arguments, register observers-filters, start processing 
 *
 */
public class Driver {

	/**
	 * {@link Driver} class default constructor
	 */
	public Driver(){
		MyLogger.singletonMyLogger().printToStdOut(2, "Driver class default constructor has been called\n");
	}
	
	/**
	 * method to validate arguments. returns true if arguments are valid 
	 * @param arguments
	 * @return boolean 
	 */
	static boolean validateArguments(String arguments[]){
		MyLogger.singletonMyLogger().printToStdOut(3, "Driver class validateArguments(String arguments[]) method has been called\n");
		if(arguments.length != 3){
			System.err.println("expected number of arguments are 3");
			return false;
		}	
		if(!arguments[0].endsWith(".txt") || !arguments[1].endsWith(".txt")){
			System.err.println("file names should have .txt extension");
			return false;
		}
		try {
			Integer.parseInt(arguments[2]);
		} catch (NumberFormatException e) {
			System.err.println("debug value should be an integer: "+e.getMessage());
			return false;
		}finally{
			
		}
		return true;	
	}
	
	/**
	 * main function
	 * @param args
	 */
	public static void main(String[] args) {
		if(validateArguments(args)){
			
			String inputFileName = args[0], outputFileName = args[1];
			int debugValue = Integer.parseInt(args[2]);
			MyLogger.setDEBUG_VALUE(debugValue);
			
			FileInterface fileProcessor = new FileProcessor(inputFileName, outputFileName);
			Subject dashboardSubject = new DashBoardSubject(fileProcessor);
			Observer observers[] = {new PerformanceTab(fileProcessor), new ProcessesTab(fileProcessor), new UsersTab(fileProcessor), new DefaultTab(fileProcessor)};
			DashboardFilter filters[] = {new PerformanceTabFilterImpl(), new ProcessesTabFilterImpl(), new UsersTabFilterImpl(), new DefaultTabFilterImpl()};
			
			for(int i = 0; i < observers.length; i++){
				dashboardSubject.registerObserver(observers[i], filters[i]);
			}
			
			((DashBoardSubject)dashboardSubject).startProcessing();
			
		}else{
			System.exit(0);
		}
		
	}

}
