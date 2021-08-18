# Pet clinic Web Testing Report
Objective
To create a automated test suite for testing the pet clinic application testing for the requirements for adding an owner, pet, visit and update them.

Approach
Created a simple TestNG based framework on Selenium with Page Factory design approach for setting up regression testing. Each of the test cases are logically created based on the core requirements
The tests now cover the positive flows.
Framework Details: 
TestNG.xml- All test cases are listed here as classes
Page factory classes- Each page class has object locators and supporting methods for each of the pages - Owner, PET, Visit, Vetenenarian
Reporter class- A simple Extent Report is integrated to report the final results
Driver Settings - The driver settings and launch are controlled here, for now it is catering to chrome but can extended to multiple browsers
How to run the cases?
Right click on the TestNG.xml and click on run.
Prerequisite : Install JAVA JDK- 11.0.6" Install Intellij/Eclipse- a suitable IDE Install GIT bash/GIT GUI to pull my repo If your IDE does not have MAVEN already available you can get it from marketplace . You also need TestNG if not already present. You can get it marketplace.
Steps to Run the test
Create a folder on your local where you want to download the project Clone the project from GIT with command git clone https://github.com/madhulikamitra/petClinicTesting
Once cloned successfully open your IDE and import the project as a Maven project. Your path should be until where the pom.xml resides Build with Maven-Install, once the project is imported. Wait for all dependencies to get downloaded Ensure you see no errors in your project, maybe i missed some prerequisite step, so for any issues let me know :) 
Right click and Run the TestNG.xml file under the main project directory
Techstack Java, Maven, TestNG,Extent Reports,PageFactory
Once you run your tests, the report will be generated under the target folder
GIT Repo:https://github.com/madhulikamitra/petClinicTesting
The report is available at https://github.com/madhulikamitra/petClinicTesting/tree/main/target/FinalReport.html

Issues Observed:
The helper errors are not very graceful.  They seem raw text-e.g.numeric value out of bounds (<10 digits>.<0 digits> expected)
The older errors are not removed- and we see multiple errors for the same text box
While adding the owner, while empty text is not allowed, blank spaces are allowed to save an owner
If we add an owner name with random number and text the app crashes and we are on the error page

Enhancement:
On adding visits or pets, it should ordered in the order of addition. Currently its randomized
