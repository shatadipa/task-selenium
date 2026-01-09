package com.fbn;

import com.fbn.pages.HomePage;
import com.fbn.pages.LoginPage;
import com.fbn.testdata.models.LoginData;
import com.fbn.testdata.utils.TestDataLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    LoginPage loginPage;
    @Test
    public void verifyLoginWorksForValidCredentials() {
        LoginData validLoginData = TestDataLoader.get(
                "login.json",
                "validUser",
                LoginData.class
        );
        loginPage = new LoginPage(driver);
        loginPage.selectCountry(validLoginData.getCountry());
        loginPage.enterUserName(validLoginData.getUsername());
        loginPage.enterPin(validLoginData.getPassword());
        loginPage.enterToken(validLoginData.getToken());
        loginPage.clickLoginButton();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isSideNavPresent(), "Home Page is not loaded after logging in");
    }

    @Test
    public void verifyLoginShowsErrorMessageWhenInvalidLogin(){
        LoginData invalidLoginData = TestDataLoader.get(
                "login.json",
                "invalidUser",
                LoginData.class
        );
        loginPage = new LoginPage(driver);
        loginPage.selectCountry(invalidLoginData.getCountry());
        loginPage.enterUserName(invalidLoginData.getUsername());
        loginPage.enterPin(invalidLoginData.getPassword());
        loginPage.enterToken(invalidLoginData.getToken());
        loginPage.clickLoginButton();

        // Ideally the following message would be an incorrect login message.
        // But during test automation the account was locked hence I have put in
        // this message to run and verify the automation code.
        Assert.assertEquals(loginPage.getToastMessage(),
                "Incorrect username or password");
    }
}
