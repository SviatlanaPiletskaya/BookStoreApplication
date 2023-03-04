package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

    @FindBy(id="firstname")
    private WebElement userFirstNameInput;

    @FindBy(id="lastname")
    private WebElement userLastNameInput;

    @FindBy(id="userName")
    private WebElement userNameInput;

    @FindBy(id="password")
    private WebElement passwordInput;

    @FindBy(xpath="//p[@id=\"name\"]")
    private WebElement messageAboutReCaptcha;

    @FindBy(xpath = "//button[@id=\"register\"]")
    private WebElement buttonRegister;

    @FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]/div[3]")
    private WebElement reCaptchaCheckbox;


    protected RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage inputFirstNameInRegister(String firstName){
        input(firstName, userFirstNameInput);

        return this;
    }

    public RegisterPage inputLastNameInRegister(String lastName){
        input(lastName, userLastNameInput);

        return this;
    }

    public RegisterPage inputUserNameInRegister(String userName){
        input(userName, userNameInput);

        return this;
    }

    public RegisterPage inputPasswordInRegister(String password){
        input(password, passwordInput);

        return this;
    }

    public RegisterPage clickRegisterButton() {
        click(buttonRegister);

        return this;
    }

    public RegisterPage clickReCaptchaCheckbox() {
        click(reCaptchaCheckbox);

        return this;
    }

    public String getErrorMessageAboutCaptcha(){

        return getText(messageAboutReCaptcha);
    }

    public RegisterPage scrollByRegisterButton() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", buttonRegister);

        return this;
    }

    public RegisterPage scrollByCaptchaButton() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", reCaptchaCheckbox);

        return this;
    }

}
