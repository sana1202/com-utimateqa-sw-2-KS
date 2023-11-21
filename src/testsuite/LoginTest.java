package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";//assigning the default Url to open
    @Before
    public void setUp(){openBrowser(baseUrl);}
    @Test
    public void userShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        //finding the sign in link button and click on it
//        WebElement signinLink = driver.findElement(By.xpath("//a[@href='/users/sign_in']"));
//        signinLink.click();

        // to reduce code/fine tuning we can use in this way as well
        driver.findElement(By.xpath("//a[@href='/users/sign_in']")).click();

        String expectedWelcomeMessage = "Welcome Back!";
        //find the actual message element and get the text
        String actualWelcomeMessage = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();

        Assert.assertEquals(expectedWelcomeMessage,actualWelcomeMessage);

        // find the username element and send the input
        driver.findElement(By.xpath("//input[@id='user[email]' or @name='user[email']")).sendKeys("abcd@gmail.com");
        //find the password element and send the input
        driver.findElement(By.xpath("//input[@id='user[password]' or @name='user[password']")).sendKeys("12345");
        //find the sign in element and send the input
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(8000);

        String expectedErrorMessage = "Invalid email or password.";
        //find the error message and get the text
        String actualErrorMessage = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();

        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);

    }
    @After
    public void closeDown(){closeBrowser();}

}
