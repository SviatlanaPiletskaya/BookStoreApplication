package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import runner.BaseTest;

public class LoginPageTest extends BaseTest {

    @Test
    public void testInvalidCredentials() {
        // Username and Password Incorrect
        final String expectedErrorMessage = "Invalid username or password!";
        final String expectedURL = "https://demoqa.com/login";

        LoginPage loginPage = openBaseURL()
                .clickLoginButton()
                .inputIncorrectUserNameOnLoginPage("tester")
                .inputIncorrectPasswordOnLoginPage("000test")
                .scrollByLoginButton()
                .clickLoginButtonOnLoginPage();

        String actualErrorMessage = loginPage.getErrorMessage();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        Assert.assertEquals(loginPage.getCurrentURL(), expectedURL);
    }

    @Test
    public void testLoginWithoutPassword() {
        // Enter correct username and Incorrect password
        final String expectedErrorMessage = "Invalid username or password!";
        final String expectedURL = "https://demoqa.com/login";

        LoginPage loginPage = openBaseURL()
                .clickLoginButton()
                .inputCorrectUserNameOnLoginPage("tester@gmail.com")
                .inputIncorrectPasswordOnLoginPage("000test")
                .scrollByLoginButton()
                .clickLoginButtonOnLoginPage();

        String actualErrorMessage = loginPage.getErrorMessage();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        Assert.assertEquals(loginPage.getCurrentURL(), expectedURL);
    }

    @Test
    public void testLoginWithoutUsername() {
        // Enter correct password and incorrect username
        final String expectedErrorMessage = "Invalid username or password!";
        final String expectedURL = "https://demoqa.com/login";

        LoginPage loginPage = openBaseURL()
                .clickLoginButton()
                .inputIncorrectUserNameOnLoginPage("t0000")
                .inputCorrectPasswordOnLoginPage("Tester123$")
                .scrollByLoginButton()
                .clickLoginButtonOnLoginPage();

        String actualErrorMessage = loginPage.getErrorMessage();
        
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        Assert.assertEquals(loginPage.getCurrentURL(), expectedURL);
    }

    @Test
    public void testLoginWithoutUserNameAndPassword() {
        // Login without date
        final String expectedURL = "https://demoqa.com/login";

        LoginPage loginPage = openBaseURL()
                .clickLoginButton()
                .scrollByLoginButton()
                .clickLoginButtonOnLoginPage();

        Assert.assertEquals(loginPage.getCurrentURL(), expectedURL);
    }

    @Test
    public void testLogoutFromProfilePage() {
        //  ????????????????, ?????? ???????????????????????? ?????????????????????????? ???? ???????????????? ???????????? ?????????? ????????????????????????????
        final String expectedURL = "https://demoqa.com/login";
        final String expectedHeaderName = "Login";
        final String expectedUrl = "https://demoqa.com/login";

        LoginPage loginPage = openBaseURL()
                .clickLoginButton()
                .inputCorrectUserNameOnLoginPage("tester@gmail.com")
                .inputCorrectPasswordOnLoginPage("Tester123$")
                .scrollByLoginButton()
                .clickLoginButtonOnLoginPageWithCorrectDate()
                .scrollByLogOutButton()
                .clickLogOutButtonOnProfilePage();

        String actualURL = loginPage.getCurrentURL();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(loginPage.getHeaderName(), expectedHeaderName);
        Assert.assertEquals(loginPage.getCurrentURL(), expectedUrl);
    }
}
