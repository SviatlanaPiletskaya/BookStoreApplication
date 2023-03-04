package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProfilePage;
import runner.BaseTest;

public class ProfilePageTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        final String expectedUrl = "https://demoqa.com/profile";
        final String expectedLoginBanner =  "tester@gmail.com";

        ProfilePage profilePage = openBaseURL()
                .clickLoginButton()
                .inputCorrectUserNameOnLoginPage("tester@gmail.com")
                .inputCorrectPasswordOnLoginPage("Tester123$")
                .scrollByLoginButton()
                .clickLoginButtonOnLoginPageWithCorrectDate();

        String actualLoginBanner = profilePage.getValueUserNameProfile();

        Assert.assertEquals(actualLoginBanner, expectedLoginBanner);
        Assert.assertEquals(profilePage.getCurrentURL(), expectedUrl);
    }

}
