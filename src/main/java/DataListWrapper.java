import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DataListWrapper extends PrimeWrapper {

    public DataListWrapper(WebDriver driver, String id) {
        super(driver, id);
    }

    public String getText(){
        return driver.findElement(By.id(id + "_content")).getText();
    }

    public String getElement(int index){
        List<WebElement> listElement = driver.findElements(By.xpath("//*[@id='" + id + "_list']/*[self::li or self::dt]"));
        //WebElement listElement = driver.findElement(By.xpath("//*[@id='" + id + "_list']/li[" + index + "]"));
        return listElement.get(index-1).getText();
    }
}
