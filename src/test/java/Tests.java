import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;

public class Tests extends PageNavigator{
    PageNavigator pageNavigator;
    RegistrationPage register;
    LoginPage login;
    HomePage home;
    CartPage cart;


    @BeforeTest
    public void initialize(){
        driver = initializingDriver();
        pageNavigator = new PageNavigator();
        login = new LoginPage(driver);
        home = new HomePage(driver);
        register = new RegistrationPage(driver);
        cart = new CartPage(driver);
        driver.get("https://www.demoblaze.com/");
    }

    @Test
    public void testCase1_SignUpAndLogin() throws InterruptedException {
        pageNavigator.navigateToRegistrationPage();
        register.signUp("selim11", "12345");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("login2"))));
        pageNavigator.navigateToLoginPage();
        login.login("selim11", "12345");
    }

    @Test
    public void testCase2_CheckingItemsInCategories() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[contains(@class,'list-group')]")));
        Assert.assertTrue(home.isPhonesCategoryNotEmpty());
        Assert.assertTrue(home.isLaptopsCategoryNotEmpty());
        Assert.assertTrue(home.isMonitorsCategoryNotEmpty());

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
