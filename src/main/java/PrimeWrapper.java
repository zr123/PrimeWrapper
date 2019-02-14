import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class PrimeWrapper{

    protected WebDriver driver;
    protected String id;
    protected WebElement node;

    public PrimeWrapper(WebDriver driver, String id){
        this.driver = driver;
        this.id = id;
        node = driver.findElement(By.id(id));
    }

    public void click(){
        driver.findElement(By.id(id)).click();
    }

    public void submit(){
        driver.findElement(By.id(id)).submit();
    }

    public String getText() {
        return node.getText();
    }

    public static SelectCheckboxMenuWrapper findCheckBoxMenu(WebDriver driver, String id) {
        return new SelectCheckboxMenuWrapper(driver, id);
    }

    public static DataListWrapper findDataList(WebDriver driver, String id){
        return new DataListWrapper(driver, id);
    }
}
