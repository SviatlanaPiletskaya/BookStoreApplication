package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends BasePage{
    @FindBy(xpath ="//button[@id=\"login\"]")
    private WebElement loginButtonOnBooksPage;


    public BooksPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLoginButton() {
        click(loginButtonOnBooksPage);

        return new LoginPage(getDriver());
    }
}
