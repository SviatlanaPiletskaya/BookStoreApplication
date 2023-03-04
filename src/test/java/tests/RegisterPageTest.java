package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;
import runner.BaseTest;

public class RegisterPageTest extends BaseTest {

    @Test
    public void testErrorMessageWhenCreatingNewAccountWithoutCaptcha() {
        final String expectedReCaptchaErrorMessage = "Please verify reCaptcha to register!";
        final String expectedURL = "https://demoqa.com/register";

        RegisterPage registerPage = openBaseURL()
                .clickLoginButton()
                .scrollByNewUserButton()
                .clickNewUserButtonOnLoginPage()
                .inputFirstNameInRegister("Test")
                .inputLastNameInRegister("Test")
                .inputUserNameInRegister("test")
                .inputPasswordInRegister("1000Test!")
                .scrollByRegisterButton()
                .clickRegisterButton();

        String actualReCaptchaErrorMessage = registerPage.getErrorMessageAboutCaptcha();

        Assert.assertEquals(actualReCaptchaErrorMessage, expectedReCaptchaErrorMessage);
        Assert.assertEquals(registerPage.getCurrentURL(), expectedURL);
    }

//    @Test
//    public void testCreatingNewAccountWithoutCaptcha() {
//        final String expectedURL = "https://demoqa.com/register";
//
//        RegisterPage registerPage = openBaseURL()
//                .scrollByNewUserButton()
//                .clickNewUserButtonOnLoginPage()
//                .scrollByCaptchaButton()
//                .clickReCaptchaCheckbox()
//                .inputFirstNameInRegister("Test")
//                .inputLastNameInRegister("Test")
//                .inputUserNameInRegister("test")
//                .inputPasswordInRegister("1000Test!!")
//                .scrollByRegisterButton()
//                .clickRegisterButton();
//
//        Assert.assertEquals(registerPage.getCurrentURL(), expectedURL);
//    }

}
