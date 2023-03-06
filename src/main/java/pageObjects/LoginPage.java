package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "loginusername")
    private WebElement usernameTxtField;
    @FindBy(id = "loginpassword")
    private WebElement passwordTxtField;
    @FindBy(xpath = "//div[@id='logInModal']//button[contains(@class,'btn-primary')]")
    private WebElement loginBtn;
    @FindBy(xpath = "//div[@id='logInModal']//button[contains(@class,'btn-secondary')]")
    private WebElement closeBtn;

    public LoginPage(WebDriver driver) {
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

    public void clickLoginButton() {
        loginBtn.click();
    }

    public void login(String username, String password){
        setUsername(username);
        setPassword(password);
        clickLoginButton();
    }

}
