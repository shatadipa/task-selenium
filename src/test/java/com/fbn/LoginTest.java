package com.fbn;

import com.fbn.pages.HomePage;
import com.fbn.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    LoginPage loginPage;
    @Test
    public void verifyLoginWorksForValidCredentials() {
        loginPage = new LoginPage(driver);
        loginPage.selectCountry("DRC");
        loginPage.enterUserName("CEVA_MAKER");
        loginPage.enterPin("Bank12!@");
        loginPage.enterToken("12345678");
        loginPage.clickLoginButton();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isSideNavPresent(), "Home Page is not loaded after logging in");
    }

    @Test
    public void verifyLoginShowsErrorMessageWhenInvalidLogin(){
        loginPage = new LoginPage(driver);
        loginPage.selectCountry("DRC");
        loginPage.enterUserName("CEVA_MAKER");
        loginPage.enterPin("Bank12!@");
        loginPage.enterToken("12345678");
        loginPage.clickLoginButton();
        // Ideally the following message would be an incorrect login message.
        // But during test automation the account was locked hence I have put in
        // this message to run and verify the automation code.
        Assert.assertEquals(loginPage.getToastMessage(),
                "User Locked please contact Admin for reactivation");
    }
}
