import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "form#new_user input#user_email")
    WebElement userName;
    @FindBy(css = "form#new_user input#user_password")
    WebElement userPassword;
    @FindBy(css = "form#new_user input[type='submit']")
    WebElement buttonSubmit;
    @FindBy(css = "form#new_user ul#parsley-id-5")
    WebElement textUnderEmail;
    @FindBy(css = "form#new_user ul#parsley-id-7")
    WebElement textUnderPassword;

    public LoginPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    public void loginWithWrongUserName(String login, String password) {
        wait.until(ExpectedConditions.visibilityOf(userName));
        wait.until(ExpectedConditions.visibilityOf(userPassword));
        wait.until(ExpectedConditions.visibilityOf(buttonSubmit));

        userName.sendKeys(login);
        userPassword.sendKeys(password);
        buttonSubmit.click();
    }

    public void loginWithoutPassword(String login) {
        wait.until(ExpectedConditions.visibilityOf(userName));
        wait.until(ExpectedConditions.visibilityOf(buttonSubmit));

        userName.sendKeys(login);
        buttonSubmit.click();
    }

    public String checkTextUnderUserName(){
       return wait.until(ExpectedConditions.visibilityOf(textUnderEmail)).getText();
    }

    public String checkTextUnderPassword(){
        return wait.until(ExpectedConditions.visibilityOf(textUnderPassword)).getText();
    }
}
