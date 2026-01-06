package com.fbn;

import com.fbn.utils.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public abstract class BaseTest {

    // Driver should be avalilable to all inheriting test classes
    protected WebDriver driver;

    @BeforeClass
    public void setup(){
        // Ideally this would come from a BrowserFactory class
        // The factory would run the correct browser driver based on a parameter
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Config.TIMEOUT_IN_SECONDS));
        driver.get(Config.BASE_URL);
    }

    @AfterClass
    public void cleanup(){
        driver.quit();
    }
}