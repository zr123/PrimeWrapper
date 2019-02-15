import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SelectCheckboxMenuWrapper extends PrimeWrapper {

    public SelectCheckboxMenuWrapper(WebDriver driver, String id) {
        super(driver, id);
    }

    public void click(){
        driver.findElement(By.xpath("//div[@id='" + id + "']/div[3]")).click();
    }

    public void selectByValue(String value) throws InterruptedException {
        openDropdownMenu();
        driver.findElement(By.xpath("//div[@id='" + id + "_panel']//label[text()='" + value + "']")).click();
        closeDropdownMenu();
    }

    public void openDropdownMenu(){
        WebElement dropdownmenu = driver.findElement(By.xpath("//div[@id='" + id + "_panel']"));
        if(!dropdownmenu.isDisplayed()) {
            click();
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='" + id + "_panel']")));
        }
    }

    public void closeDropdownMenu(){
        WebElement dropdownmenu = driver.findElement(By.xpath("//div[@id='" + id + "_panel']"));
        if(dropdownmenu.isDisplayed()) {
            click();
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='" + id + "_panel']"))));
        }
    }
}
