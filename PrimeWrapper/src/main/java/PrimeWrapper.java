import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class PrimeWrapper {

    protected WebDriver driver;
    protected String id;

    public PrimeWrapper(WebDriver driver, String id){
        this.driver = driver;
        this.id = id;
    }

    public void click(){
        driver.findElement(By.id(id)).click();
    }

    public void submit(){
        driver.findElement(By.id(id)).submit();
    }

    public static CheckboxMenuWrapper findCheckBoxMenu(WebDriver driver, String id) {
        return new CheckboxMenuWrapper(driver, id);
    }
}
