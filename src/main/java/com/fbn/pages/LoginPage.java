package com.fbn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    // All locators should ideally be private.
    // Actions performed from tests should use public methods and not the locators directly.
    private By countrySelect = By.cssSelector(".mat-form-field-infix:has(*[formcontrolname='country'])");
    private String countryOptionFormat = ".mat-option:has(img[src*=%s])";
    private By userNameTextInput = By.cssSelector("input[formcontrolname='userName']");
    private By pinTextInput = By.cssSelector("input[formcontrolname='pin']");
    private By tokenTextInput = By.cssSelector("input[formcontrolname='token']");
    private By loginButton = By.className("login-btn");
    private By toastContainer = By.id("toast-container");

    /**
     * This method selects the country from the dropdown
     * The method constructs the selector dynamically from the given country name.
     *
     * @param country to select
     */
    public void selectCountry(String country){
        click(countrySelect);
        By countryOption = By.cssSelector(String.format(countryOptionFormat, country.toLowerCase()));
        click(countryOption);
    }

    public void enterUserName(String userName){
        sendKeys(userNameTextInput, userName);
    }

    public void enterPin(String pin){
        sendKeys(pinTextInput, pin);
    }

    public void enterToken(String token){
        sendKeys(tokenTextInput, token);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public String getToastMessage(){
        return driver.findElement(toastContainer).getText();
    }


    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
