package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    private WebDriverWait wait;
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tbodyid")
    private WebElement itemsTable;

    public List<WebElement> getItemsInCart(){
        List<WebElement> itemsInCart = itemsTable.findElements(By.xpath("//tr"));
        return itemsInCart;
    }

    public List<String> getItemsTitlesInCart() {
        List<String> itemsTitles = new ArrayList<>();
        for (WebElement itemInCart : getItemsInCart()) {
            itemsTitles.add(itemInCart.findElement(By.xpath("//td[2]")).getText());
        }
        return itemsTitles;
    }

    public boolean isItemAddedToCart(String itemName){
        boolean itemIsAdded = false;
        if(getItemsTitlesInCart().contains(itemName)){
        itemIsAdded = true;
    }
        else{
        itemIsAdded = false;
    }
        return itemIsAdded;
}

//    public void removeItemFromCart(String itemName){
//        if(getItemsTitlesInCart().contains(itemName)){
//            getItemsInCart().findElement(By.xpath("//td[2]"))
//        }
//    }
}
