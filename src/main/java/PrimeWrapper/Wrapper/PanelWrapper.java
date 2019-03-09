package PrimeWrapper.Wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PanelWrapper extends PrimeWrapper {

    public PanelWrapper(WebDriver driver, String id) {
        super(driver, id);
    }

    public WebElement getHeader(){
        return node.findElement(By.id(id + "_header"));
    }

    public WebElement getContent(){
        return node.findElement(By.id(id + "_content"));
    }

    public WebElement getFooter(){
        return node.findElement(By.id(id + "_footer"));
    }
}
