import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaviPage extends BasePage {

    @FindBy(xpath = "//a[text()= 'Cart' ]")
    WebElement cart;

    public NaviPage(ChromeDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public void ClickCart(){
        cart.click();
    }
}
