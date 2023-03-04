package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(className = "search-dropdown-menu")
    private WebElement loginWrapper;

    @FindBy(xpath="//*[@id=\"userForm\"]/div[1]/h5")
    private WebElement userForm;

    @FindBy(xpath="//*[@id=\"userName\"]")
    private WebElement userNameInput;

    @FindBy(id="password")
    private WebElement passwordInput;

    @FindBy(id="login")
    private WebElement buttonLogin;

    @FindBy(id="newUser")
    private WebElement newUserButton;

    @FindBy(xpath="//*[@id=\"output\"]//*[@id=\"name\"]")
    private WebElement errorMessage;

    @FindBy(xpath="//button[@id=\"newUser\"]")
    private WebElement buttonNewUser;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getErrorMessage(){

        return getText(errorMessage);
    }

    public LoginPage clickLoginButtonOnLoginPage() {
        click(buttonLogin);

        return this;
    }

    public ProfilePage clickLoginButtonOnLoginPageWithCorrectDate() {
        click(buttonLogin);

        return new ProfilePage(getDriver());
    }

    public RegisterPage clickNewUserButtonOnLoginPage() {
        click(newUserButton);

        return new RegisterPage(getDriver());
    }
    
    public LoginPage inputIncorrectUserNameOnLoginPage(String nameIncorrect){
        input(nameIncorrect, userNameInput);

        return this;
    }

    public LoginPage inputIncorrectPasswordOnLoginPage(String passwordIncorrect){
        input(passwordIncorrect, passwordInput);

        return this;
    }

    public LoginPage inputCorrectUserNameOnLoginPage(String nameCorrect){
        input(nameCorrect, userNameInput);

        return this;
    }

    public LoginPage inputCorrectPasswordOnLoginPage(String passwordCorrect){
        input(passwordCorrect, passwordInput);

        return this;
    }

    public LoginPage scrollByLoginButton() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", buttonLogin);

        return this;
    }

    public LoginPage scrollByNewUserButton() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", buttonNewUser);

        return this;
    }

}
