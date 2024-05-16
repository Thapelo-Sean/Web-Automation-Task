import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTest {
    private WebDriver driver;
    private static ExtentReports extent;
    private static ExtentSparkReporter spark;

    // Constants
    private static final String BASE_URL = "https://www.way2automation.com/angularjs-protractor/webtables/";
    private static final String EXPECTED_TITLE = "Protractor practice website - WebTables";
    private static final String REPORT_PATH = "./Reports/Web-Automation_Task.html";

    // User-related variables
    private static final String USER_1_USERNAME = "User1";
    private static final String USER_2_USERNAME = "User2";
    private static final String username = "User";

    @BeforeSuite
    public void setUpExtentReports() {
        //Extent report setup
        extent = new ExtentReports();
        spark = new ExtentSparkReporter(REPORT_PATH);
        extent.attachReporter(spark);
        spark.config().setReportName("Web Automation Test Report");
        spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a");
    }

    @BeforeTest
    public void setUpWebDriver() {
        // WebDriver setup
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void navigateToUrl() {
        // Navigate to base url
        driver.get(BASE_URL);
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(EXPECTED_TITLE)) {
            // Create a pass test in the extent report and log the result
            extent.createTest("Navigate to Web Tables")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.PASS, "Successfully navigated to Web Tables");
        } else {
            // Create a fail test in the extent report and log the result
            extent.createTest("Navigate to Web Tables")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.FAIL, "Failed to navigate to Web Tables");
        }
        Assert.assertEquals(actualTitle, EXPECTED_TITLE);
    }

    //Test method to validate the User List Table
    @Test(priority = 2)
    public void validateUserListTable() {
        // Get the actual title of the page
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(EXPECTED_TITLE)) {
            // Create a successful test in the extent report and log the result
            extent.createTest("Validate User List Table")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.PASS, "Successfully validated User List Table");
        } else {
            // Create a failed test in the extent report and log the result
            extent.createTest("Validate User List Table")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.FAIL, "Failed to validate User List Table");
        }
        // Check if the actual title matches the expected title
        Assert.assertEquals(actualTitle, EXPECTED_TITLE);
    }

    @Test(priority = 3)
    public void clickAddUser() {
        try {
            // Find the "Add User" button using XPath and click on it
            driver.findElement(By.xpath("/html/body/table/thead/tr[2]/td/button")).click();

            // Create a successful test in the extent report and log the validation result
            extent.createTest("Click add user")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.PASS, "Add User button successfully clicked");
        } catch (Exception e) {
            extent.createTest("Click add user")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.FAIL, "Failed to click Add User button: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 4)
    public void addUser1() {
        try {
            // Locate elements and Fill in user details
            driver.findElement(By.name("FirstName")).sendKeys("FName1");
            driver.findElement(By.name("LastName")).sendKeys("LName1");
            driver.findElement(By.name("UserName")).sendKeys("User1");
            driver.findElement(By.name("Password")).sendKeys("Pass1");
            driver.findElement(By.cssSelector("input[type='radio'][value='15']")).click();

            // Find the dropdown element by its name
            WebElement dropdown = driver.findElement(By.name("RoleId"));

            // Click on the dropdown to open the options
            dropdown.click();

            // Find all the options within the dropdown
            List<WebElement> options = driver.findElements(By.cssSelector("select[name='RoleId'] option"));

            // Select the last option by its index and click
            WebElement lastOption = options.get(options.size() - 1);
            lastOption.click();

            //Locate elements and Fill in user details
            driver.findElement(By.name("Email")).sendKeys("admin@mail.com");
            driver.findElement(By.name("Mobilephone")).sendKeys("082555");
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/button[2]")).click();

            // Create a successful test in the extent report and log the validation result
            extent.createTest("Add user1")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.PASS, "User 1 successfully added");
        } catch (Exception e) {
            // Create a failed test in the extent report and log the validation result
            extent.createTest("Add user1")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.FAIL, "Failed to add user1: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 5)
    public void addUser2() {
        try {
            //Locate the element and click the button to add a new user
            driver.findElement(By.xpath("/html/body/table/thead/tr[2]/td/button")).click();

            //Locate elements, clear the input field and Fill in user2 details
            WebElement firstName = driver.findElement(By.name("FirstName"));
            firstName.clear();
            firstName.sendKeys("FName2");

            WebElement lastName = driver.findElement(By.name("LastName"));
            lastName.clear();
            lastName.sendKeys("LName2");

            WebElement userName = driver.findElement(By.name("UserName"));
            userName.clear();
            userName.sendKeys("User2");

            WebElement password = driver.findElement(By.name("Password"));
            password.clear();
            password.sendKeys("Pass2");

            // Select the role as Customer from the dropdown
            driver.findElement(By.cssSelector("input[type='radio'][value='16']")).click();

            WebElement dropdown = driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/table/tbody/tr[6]/td[2]/select"));

            // Find the dropdown element by its name
            dropdown = driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/table/tbody/tr[6]/td[2]/select"));

            // Click on the dropdown to open the options
            dropdown.click();

            // Select the second option "Customer" by its index (index starts from 0)
            WebElement secondOption = driver.findElements(By.cssSelector("select[name='RoleId'] option")).get(1);
            secondOption.click();

            //Locate elements, clear the input field and Fill in user2 details
            WebElement email = driver.findElement(By.name("Email"));
            email.clear();
            email.sendKeys("cusomter@mail.com");

            WebElement mobilephone = driver.findElement(By.name("Mobilephone"));
            mobilephone.clear();
            mobilephone.sendKeys("083333");

            //Click on the Save button
            driver.findElement(By.xpath("/html/body/div[2]/div[3]/button[2]")).click();

            // Create a successful test in the extent report and log the validation result
            extent.createTest("Add user2")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.PASS, "User 2 successfully added");
        } catch (Exception e) {
            // Create a failed test in the extent report and log the validation result
            extent.createTest("Add user2")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.FAIL, "Failed to add user2: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 6)
    public void verifyUsername() {
        try {
            Assert.assertNotEquals(USER_1_USERNAME, USER_2_USERNAME, "Usernames for user1 and user2 should be different");

            // Create a successful test in the extent report and log the validation result
            extent.createTest("Verify usernames are unique")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.PASS, "Successfully verified username");
        } catch (AssertionError e) {
            // Create a failed test in the extent report and log the validation result
            extent.createTest("Verify usernames are unique")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.FAIL, "Failed to verify usernames: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 7)
    public void verifyUsers() {

        try{
            // Locate search input field perform a search in the table for the added user
            WebElement searchField = driver.findElement(By.xpath("/html/body/table/thead/tr[1]/td/input"));

            // Enter the username in the search field
            searchField.sendKeys(username);

            // Submit the search
            searchField.sendKeys(Keys.ENTER);

            // Locate elements of both users
            WebElement user1 = driver.findElement(By.xpath("//td[text()='User1']"));
            WebElement user2 = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[3]"));

            // Check if both User1 and User2 elements are visible
            boolean isUser1Visible = user1.isDisplayed();
            boolean isUser2Visible = user2.isDisplayed();

            // Check if both users are visible
            if (isUser1Visible && isUser2Visible) {
                Assert.assertTrue(true, "User1 is visible on the page.");
                Assert.assertTrue(true, "User2 is visible on the page.");

                // Create a successful test in the extent report and log the validation result
                extent.createTest("Verify users")
                        .assignAuthor("Thapelo Matji")
                        .log(Status.PASS, "Successfully verified users");
            } else {
                Assert.assertFalse(isUser1Visible, "User1 is not visible on the page.");
                Assert.assertFalse(isUser2Visible, "User2 is not visible on the page.");

                // Create a failed test in the extent report and log the validation result
                extent.createTest("Verify users")
                        .assignAuthor("Thapelo Matji")
                        .log(Status.FAIL, "Users are not visible on the page");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //This method is executed after each test to close the WebDriver if it's not null.
    @AfterTest
    public void tearDownWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    //This method flushes the extent reports after running all test suites.
    @AfterSuite
    public void flushExtentReports() {
        extent.flush();
    }
}