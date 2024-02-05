package AllureReports;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tests {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
    }


    @Test(priority = 1, description = "Verify logo presence on Home Page")
    @Description("Verify that logo is presence on HomePage")
    @Epic("EP001")
    @Feature("Feature :: Logo1")
    @Story("Story :: Logo Presence")
    @Step("Step :: Verify logo")
    @Severity(SeverityLevel.MINOR)
    public void logoPresence() {

        WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        boolean logoDisplayed = logo.isDisplayed();
        Assert.assertEquals(logoDisplayed, true);


    }

    @Test(priority = 2)
    @Description("Verify that user is loginto system after providing correct credentials")
    @Epic("EP002")
    @Feature("Feature :: Login")
    @Story("Story :: Login Presence")
    @Step("Step :: Verify login")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest() {

        WebElement loginLink = driver.findElement(By.xpath("//a[normalize-space()='Log in']"));
        loginLink.click();
        WebElement emaildIdTextBox = driver.findElement(By.xpath("//a[normalize-space()='Log in']"));
        emaildIdTextBox.sendKeys("abc@abc.com");
        WebElement passWordTextBox = driver.findElement(By.xpath("//input[@id='Password']"));
        passWordTextBox.sendKeys("abc@abc.com");

        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");
    }

    @Test(priority = 3)
    @Description("Verify that user is Registration system after providing correct credentials")
    @Epic("EP003")
    @Feature("Feature :: Registration")
    @Story("Story :: Registration")
    @Step("Step :: Verify registration")
    @Severity(SeverityLevel.CRITICAL)
    public void registrationTest() {
        throw new SkipException("Skipping this test");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
