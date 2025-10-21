package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTests {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

    }

    @BeforeMethod
    public void goToGoogleHome() {
        driver.get("https://www.google.com/");

    }

    @Test
    public void testGoogleLogo() {

        Assert.assertTrue(driver.findElement(By.cssSelector("img.lnXdpd")).isDisplayed());
    }

    @Test
    public void testGoogleTitle() {
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }


}
