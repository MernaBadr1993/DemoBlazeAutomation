package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static pageObjects.PageNavigator.wait;

public class RegistrationPage {
    private WebDriver driver;

    @FindBy(id = "sign-username")
    private WebElement usernameTxtField;
    @FindBy(id = "sign-password")
    private WebElement passwordTxtField;
    @FindBy(xpath = "//div[@id='signInModal']//button[contains(@class,'btn-primary')]")
    private WebElement signUpBtn;
    @FindBy(xpath = "//div[@id='signInModal']//button[contains(@class,'btn-secondary')]")
    private WebElement closeBtn;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String username){
        usernameTxtField.sendKeys(username);
    }

    public String getUsername(){
        return usernameTxtField.getText();
    }

    public void setPassword(String password){
        passwordTxtField.sendKeys(password);
    }

    public String getPassword(){
        return passwordTxtField.getText();
    }

    public void clickSignUpButton() {
        signUpBtn.click();
    }

    public void signUp(String username, String password) throws InterruptedException {
        setUsername(username);
        setPassword(password);
        clickSignUpButton();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}
