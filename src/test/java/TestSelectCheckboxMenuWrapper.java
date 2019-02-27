import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    public void after() throws Exception{
        // sleep a bite after tests to prevent a Stale Element Reference Exception
        Thread.sleep(100);
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
        DataListWrapper list = PrimeWrapper.findDataList(driver, "form:selectedBasic");
        assertEquals("Miami", list.getListElement(1).getText());
        assertEquals("Berlin", list.getListElement(2).getText());
        assertEquals("Amsterdam", list.getListElement(3).getText());
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
        DataListWrapper list = PrimeWrapper.findDataList(driver, "form:selectedMultiple");
        assertEquals("Miami", list.getListElement(1).getText());
        assertEquals("Berlin", list.getListElement(2).getText());
        assertEquals("Amsterdam", list.getListElement(3).getText());
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
        Thread.sleep(1000);
        DataListWrapper list = PrimeWrapper.findDataList(driver, "form:selectedGrouped");
        assertEquals("BMW", list.getListElement(1).getText());
        assertEquals("GM", list.getListElement(2).getText());
        assertEquals("Ford", list.getListElement(3).getText());
        Thread.sleep(1000);
    }
}
