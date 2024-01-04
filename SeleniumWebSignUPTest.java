import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SeleniumWebSignUPTest {
    // Import the Selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void Start () throws InterruptedException {
        // locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver-win64/chromedriver.exe");
        //1. Open your Chrome Browser
        driver = new ChromeDriver();
        //2.Input your selenium Demo page URL (https://selenium-blog-herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com/");
        //Test 1 Verify the user input the right URL and is on the right page
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
            //pass
            System.out.println("current Webpage");
        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
        //3. Maximise the browser
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }

     @Test (priority = 0)
     public void SignUp () throws InterruptedException {
         //4. Click on Signup button to open the Signup page
         driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
         //Test2.Verify that when user click on the SignUP button,the user is directed to the SignUP page
         String expectedUrl =  "https://selenium-blog.herokuapp.com/signup";
         String actualUrl = driver.getCurrentUrl();
         if(actualUrl.contains(expectedUrl))
             //pass
             System.out.println("Correct WebPage");
         else
             //fail
             System.out.println("Wrong WebPage");
         Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void PositiveSignUp() throws InterruptedException {
        //Test3. Verify that user is successfully signed UP when valid details are inputted
        //5.Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Taiwo12");
        //6. Input an Email address in the email field
        driver.findElement(By.id("user_email")).sendKeys("taiwobunmi12@gmail.com");
        //7. Input a password in the password field
        driver.findElement(By.id("user_password")).sendKeys("Adekunle11");
        //8. Click on SignUp button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void UserOneItem() throws InterruptedException {
        //9.Click on User1 Item on the list page
        driver.findElement((By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a"))).click();
        //Test4.Verify that user item is present on the Item list page
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //pass
            System.out.println("Correct WebPage");
        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
    }

    @Test (priority = 3)
    public void VerifyItem() throws InterruptedException {
        //10.Search for an item (Using Python with Selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        //Test5.Verify that the item searched for on the User1Page is present
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //pass
            System.out.println("Correct WebPage");
        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
    }

    @Test (priority = 4)
    public void LogOutSuccessful() throws InterruptedException {
        //11. Click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test6.Verify that when user logout,he/she is directed to the login page
        String expectedTitle = "AlphaBlog";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle))
            //pass
            System.out.println("Correct WebPage");
        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
    }

    @Test (priority = 5)
    public void NegativeSignUp() throws InterruptedException {
        //1. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Test7.Verify that user cannot Sign UP with username less than 3 characters
        //2. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("SA");
        //3. Input an Email address in the email field
        driver.findElement(By.id("user_email")).sendKeys("ayo@gmail.com");
        //4. Input Your password in the password field
        driver.findElement(By.id("user_password")).sendKeys("Abe");
        //5. Click on Signup button
        driver.findElement(By.id("submit")).click();
        //6. Click on Login button
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 6)
    public void NegativeSignUp1() throws InterruptedException {
        //1. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        //Test8.Verify that user cannot Sign UP with either/all the fields blank
        //2. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Busola11");
        //Test9.Verify that user cannot Sign UP with invalid email address
        //3. Input an Email address in the email field
        driver.findElement(By.id("user_email")).sendKeys("tunde.com");
        //Test10.Verify that user cannot login with password less than or equal to one character
        //4. Input Your password in the password field
        driver.findElement(By.id("user_password")).sendKeys("Adebimbo");
        //5. Click on Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        //6. Click on Login button
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void CloseBrowser(){
        //12. Quit the browser
        driver.quit();
    }








    }


































