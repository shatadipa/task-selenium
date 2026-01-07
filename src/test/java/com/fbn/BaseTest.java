package com.fbn;

import com.fbn.utils.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {

    // Driver should be available to all inheriting test classes
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Ideally this should come from a BrowserFactory class
        // The factory would run the correct browser driver based on parameter from suite xml file
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Config.TIMEOUT_IN_SECONDS));
        driver.get(Config.BASE_URL);
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }
}