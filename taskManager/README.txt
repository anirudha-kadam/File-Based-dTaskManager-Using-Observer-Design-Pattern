CS542 Design Patterns
Spring 2015
PROJECT 3 README FILE

Due Date: Friday, April 3, 2015
Submission Date: Friday, April 3, 2015
Grace Period Used This Project: 0 Days
Grace Period Remaining: 0 Days
Author(s): Anirudha Kadam 
e-mail(s): akadam3@binghamton.edu 


PURPOSE:

[
  To simulate taskManager using files and apply observer pattern as a design backbone.
]

PERCENT COMPLETE:

[
  I believe I have completed 100% of this project.
]

PARTS THAT ARE NOT COMPLETE:

[
  None.
]

BUGS:

[
  None.
]

FILES:

[
  DisplayFile.java 
  Driver.java 
  DashboardFilter.java 
  DefaultTab.java
  DefaultTabFilterImpl.java
  Observer.java
  PerformanceTab.java
  PerformanceTabFilterImpl.java
  ProcessesTab.java
  ProcessesTabFilterImpl.java
  UpdateMessageFormat.java
  UsersTab.java
  UsersTabFilterImpl.java
  DashBoardSubject.java
  Subject.java
  FileInterface.java
  FileProcessor.java
  MyLogger.java
  input and output files 
]

SAMPLE OUTPUT:

[
   
     [java] ---TAB(s) BEGIN---
     [java] ---USERS---
     [java] User: (unknown)  Status: inactive
     [java] User: root  Status: inactive
     [java] User: dgolemb1  Status: active
     [java] User: mslocum1  Status: active
     [java] User: ndangwa1  Status: active
     [java] User: awiesin1  Status: active
     [java] User: bsendir1  Status: active
     [java] User: tkargul1  Status: active
     [java] User: rashong1  Status: active
     [java] User: dgolemb1  Status: active
     [java] User: cigdebe1  Status: active
     [java] 
     [java] ---TAB(s) END---

]

TO COMPILE:

[
  Extract.
  Follow Path: kadam_anirudha_assign3/taskManager/
  Assuming you are in the directory containing this README

  ## To compile: 
  ant -buildfile src/build.xml all
]

TO RUN:

[
  Assuming you are in the directory containing this README:
  
  ## To run
  ant -buildfile src/build.xml run -Darg0=<inputFileName.txt> -Darg1=<outputFileName.txt> -Darg2=<debugValue> 
]

TO CLEAN:

[ 
  Assuming you are in the directory containing this README:
  
  ## To clean:
  ant -buildfile src/build.xml clean
]

NOTE:

[
   DEBUG_VALUE mappings
   0 = no output
   1 = output from dashboard
   2 = constructor calls
   3 = method calls
   4 = prints message on empty line    	
]


BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.
Anirudha Kadam

[
  
]

ACKNOWLEDGEMENT:

[
  N/A
]
