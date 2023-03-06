package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {

    @FindBy(xpath = "//div[@class='list-group']//a[text()='Phones']")
    private WebElement phones;

    @FindBy(xpath = "//div[@class='list-group']//a[text()='Laptops']")
    private WebElement laptops;

    @FindBy(xpath = "//div[@class='list-group']//a[text()='Monitors']")
    private WebElement monitors;

    @FindBy(id = "tbodyid")
    private WebElement itemList;

    @FindBy(xpath = "//a[@class='hrefch']")
    private List<WebElement> items;

    @FindBy(xpath = "//a[contains(@class,'btn-success')]")
    private WebElement addToCartBtn;

    private WebDriverWait wait;
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPhonesCategoryNotEmpty(){
        phones.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='tbodyid']")));
        List<WebElement> availableItems = itemList.findElements(By.xpath("//div[contains(@class,'col')]"));
        return !availableItems.isEmpty();
    }

    public boolean isLaptopsCategoryNotEmpty(){
        laptops.click();
        List<WebElement> availableItems = itemList.findElements(By.xpath("//div[contains(@class,'col')]"));
        return !availableItems.isEmpty();
    }

    public boolean isMonitorsCategoryNotEmpty(){
        monitors.click();
        List<WebElement> availableItems = itemList.findElements(By.xpath("//div[contains(@class,'col')]"));
        return !availableItems.isEmpty();
    }

    public void addingItemToCart(String itemName){
        for (WebElement item : items){
            if (item.getText().equals(itemName)){
                item.click();
                wait.until(ExpectedConditions.visibilityOf(addToCartBtn));
                addToCartBtn.click();
                driver.switchTo().alert().accept();
            }

        }
    }

}
