import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class TestSelectCheckboxMenuWrapper {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() throws Exception{
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @After
    public void afterTest() throws Exception {
        // delay to prevent stale element reference exceptions
        Thread.sleep(1000);
    }

    @Test
    public void testCheckboxMenuBasic() throws InterruptedException {
        driver.get("http://localhost:9090/SelectCheckbox.xhtml");
        SelectCheckboxMenuWrapper checkBoxMenu = PrimeWrapper.findSelectCheckboxMenu(driver, "form:menu");
        checkBoxMenu.selectItemByValue("Miami");
        checkBoxMenu.selectItemByValue("Berlin");
        checkBoxMenu.selectItemByValue("Amsterdam");
        // submit
        driver.findElement(By.id("form:submit")).click();
        // check if the right element got selected
        List<WebElement> list = PrimeWrapper.findDataList(driver, "form:selectedBasic").getListElements();
        assertEquals("Miami", list.get(0).getText());
        assertEquals("Berlin", list.get(1).getText());
        assertEquals("Amsterdam", list.get(2).getText());
    }

    @Test
    public void testCheckboxMenuMultiple() throws InterruptedException {
        driver.get("http://localhost:9090/SelectCheckbox.xhtml");
        SelectCheckboxMenuWrapper checkBoxMenu = PrimeWrapper.findSelectCheckboxMenu(driver, "form:multiple");
        checkBoxMenu.selectItemByValue("Miami");
        checkBoxMenu.selectItemByValue("Berlin");
        checkBoxMenu.selectItemByValue("Amsterdam");
        // submit
        driver.findElement(By.id("form:submit")).click();
        // check if the right element got selected
        List<WebElement> list = PrimeWrapper.findDataList(driver, "form:selectedMultiple").getListElements();
        assertEquals("Miami", list.get(0).getText());
        assertEquals("Berlin", list.get(1).getText());
        assertEquals("Amsterdam", list.get(2).getText());
    }


    @Test
    public void testCheckboxMenuGrouped() throws InterruptedException {
        driver.get("http://localhost:9090/SelectCheckbox.xhtml");
        SelectCheckboxMenuWrapper checkBoxMenu = PrimeWrapper.findSelectCheckboxMenu(driver, "form:grouped");
        checkBoxMenu.selectItemByValue("BMW");
        checkBoxMenu.selectItemByValue("GM");
        checkBoxMenu.selectItemByValue("Ford");
        // submit
        driver.findElement(By.id("form:submit")).click();
        // check if the right element got selected
        List<WebElement> list = PrimeWrapper.findDataList(driver, "form:selectedGrouped").getListElements();
        assertEquals("BMW", list.get(0).getText());
        assertEquals("GM", list.get(1).getText());
        assertEquals("Ford", list.get(2).getText());
    }
}
