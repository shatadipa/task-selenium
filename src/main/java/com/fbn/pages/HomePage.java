package com.fbn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private By sideNav = By.className("sidenav");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSideNavPresent(){
        return driver.findElements(sideNav).size()>0 &&
                driver.findElement(sideNav).isDisplayed();
    }
}
