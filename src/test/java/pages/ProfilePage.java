package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{

    @FindBy(id="userName-value")
    private WebElement userNameProfile;

    @FindBy(xpath = "//button[@id=\"submit\"]")
    private WebElement logOutButtonOnPageProfile;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getValueUserNameProfile(){

        return getText(userNameProfile);
    }

    public LoginPage clickLogOutButtonOnProfilePage() {
        click(logOutButtonOnPageProfile);

        return new LoginPage(getDriver());
    }

    public ProfilePage scrollByLogOutButton() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", logOutButtonOnPageProfile);

        return this;
    }


}
