import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectCheckboxMenuWrapper extends PrimeWrapper {

    public SelectCheckboxMenuWrapper(WebDriver driver, String id) {
        super(driver, id);
    }

    public void click(){
        driver.findElement(By.xpath("//div[@id='" + id + "']/div[3]/span")).click();
    }

    public void selectByValue(String value) throws InterruptedException {
        // send escape key to make sure it's the drop-down menu is unselected
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE);

        // pop dropdown menu
        Thread.sleep(200);
        click();

        // select element
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement dropdownmenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='" + id + "_panel']//label[text()='" + value + "']")));
        dropdownmenu.click();

        // close dropdown
        Thread.sleep(200);
        click();
        Thread.sleep(200);
    }
}
