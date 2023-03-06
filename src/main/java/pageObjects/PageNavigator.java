package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageNavigator {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public WebDriver initializingDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\JetBrains\\DemoBlazeAutomation\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 50);
        return driver;
    }

    @FindBy(id = "login2")
    private WebElement loginPage;

    @FindBy(id = "signin2")
    private WebElement registrationPage;

    @FindBy(id = "cartur")
    private WebElement cartPage;

    public PageNavigator() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage(){
        loginPage.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='logInModal']//div[@class='modal-content']"))));
    }

    public void navigateToRegistrationPage(){
        registrationPage.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='signInModal']//div[@class='modal-content']"))));

    }

    public void navigateToCartPage(){
        cartPage.click();
    }

}
