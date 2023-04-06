import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SaleTests extends BaseTest{

    ChromeDriver driver;
    WebDriverWait wait;
    ProductPage productPage;
    InfoProduct infoProduct;
    NaviPage naviPage;
    CartPage cartPage;

    @BeforeMethod
    public void SetUp(){
        driver = openBrowser();
        productPage = new ProductPage(driver);
        infoProduct =new InfoProduct(driver);
        naviPage = new NaviPage(driver);
        cartPage =new CartPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void BuyTwoProducts(){
        productPage.ClickOnSamsung();
        infoProduct.ClickAddToCart();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        naviPage.ClickCart();
        cartPage.ClickPlaceOrder();
        cartPage.name.sendKeys("Marko");
        cartPage.country.sendKeys("Srbija");
        cartPage.city.sendKeys("Beograd");
        cartPage.card.sendKeys("132465789");
        cartPage.month.sendKeys("April");
        cartPage.year.sendKeys("2023");
        cartPage.purchaseBtn.click();

        Assert.assertEquals(cartPage.GetInfoMessage(),"Thank you for your purchase!");

    }

    @AfterMethod
    public void After(){
        driver.quit();
    }
}
