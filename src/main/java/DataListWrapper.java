import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DataListWrapper extends PrimeWrapper {

    public DataListWrapper(WebDriver driver, String id) {
        super(driver, id);
    }

    public String getText(){
        return node.findElement(By.id(id + "_content")).getText();
    }

    public WebElement getListElement(int index){
        List<WebElement> listElement = driver.findElements(By.xpath("//*[@id='" + id + "_list']/*[self::li or self::dt]"));
        return listElement.get(index-1);
    }
}
