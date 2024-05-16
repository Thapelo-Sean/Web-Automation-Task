Web Automation Test Suite
This test suite is designed to automate the testing of a web application using Selenium and TestNG frameworks. It performs various tests on the user interface of the web application, validates functionality, and generates detailed test reports using ExtentReports.

Prerequisites
Ensure that you have the following prerequisites installed on your system:

Java Development Kit (JDK)
Maven
Google Chrome

Setup
Clone this repository to your local machine.
Install dependencies by running mvn clean install.
Run the tests using TestNG or your preferred test runner.

Running the Tests
To run the test suite, follow these steps:

1.Open a terminal or command prompt.
2.Navigate to the root directory of the cloned repository.
3.Run the tests using the command mvn test.

Test Cases
1. Navigate to Web Tables
Description: Navigates to the web tables page of the application.
Expected Outcome: The page should load successfully.
Test Priority: High

2. Validate User List Table
Description: Validates the presence of the user list table.
Expected Outcome: The user list table should be present on the page.
Test Priority: High

3. Click Add User Button
Description: Clicks the "Add User" button on the page.
Expected Outcome: The "Add User" button should be successfully clicked.
Test Priority: Medium

4. Add User 1
Description: Adds a new user with specific details.
Expected Outcome: User 1 should be successfully added to the system.
Test Priority: High

5. Add User 2
Description: Adds another user with specific details.
Expected Outcome: User 2 should be successfully added to the system.
Test Priority: High

6. Verify Username Uniqueness
Description: Verifies that usernames for User 1 and User 2 are unique.
Expected Outcome: Usernames should be unique.
Test Priority: Medium

7. Verify Users in User List
Description: Verifies the presence of both users in the user list.
Expected Outcome: Both users should be visible in the user list.
Test Priority: High

Report Generation
After running the test suite, detailed test reports are generated using ExtentReports. The reports provide information about test execution status, authorship, and timestamps.

