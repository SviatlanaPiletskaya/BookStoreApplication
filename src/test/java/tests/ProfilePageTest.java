package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProfilePage;
import runner.BaseTest;

public class ProfilePageTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        final String expectedUrl = "https://demoqa.com/books";
        final String expectedLoginBanner =  "tester@gmail.com";
        final String expectedHeaderName = "Book Store";

        ProfilePage profilePage = openBaseURL()
                .clickLoginButton()
                .inputCorrectUserNameOnLoginPage("tester@gmail.com")
                .inputCorrectPasswordOnLoginPage("Tester123$")
                .scrollByLoginButton()
                .clickLoginButtonOnLoginPageWithCorrectDate();

        String actualLoginBanner = profilePage.getValueUserNameProfile();

        Assert.assertEquals(actualLoginBanner, expectedLoginBanner);
        Assert.assertEquals(profilePage.getHeaderName(), expectedHeaderName);
        Assert.assertEquals(profilePage.getCurrentURL(), expectedUrl);
    }

}
