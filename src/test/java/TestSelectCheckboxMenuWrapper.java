
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

    @Test
    public void testCheckboxMenuBasic() throws InterruptedException {
        driver.get("https://primefaces.org/showcase/ui/input/checkboxMenu.xhtml");
        SelectCheckboxMenuWrapper checkBoxMenu = PrimeWrapper.findCheckBoxMenu(driver, "j_idt697:menu");
        checkBoxMenu.selectByValue("Miami");
        checkBoxMenu.selectByValue("Berlin");
        checkBoxMenu.selectByValue("Amsterdam");
        // submit
        driver.findElement(By.id("j_idt697:j_idt705")).click();
        // check if the right element got selected
        DataListWrapper list = PrimeWrapper.findDataList(driver, "j_idt697:j_idt707");
        assertEquals("Miami", list.getListElement(1).getText());
        assertEquals("Berlin", list.getListElement(2).getText());
        assertEquals("Amsterdam", list.getListElement(3).getText());
    }

    @Test
    public void testCheckboxMenuMultiple() throws InterruptedException {
        driver.get("https://primefaces.org/showcase/ui/input/checkboxMenu.xhtml");
        SelectCheckboxMenuWrapper checkBoxMenu = PrimeWrapper.findCheckBoxMenu(driver, "j_idt697:multiple");
        checkBoxMenu.selectByValue("Miami");
        checkBoxMenu.selectByValue("Berlin");
        checkBoxMenu.selectByValue("Amsterdam");
        // submit
        driver.findElement(By.id("j_idt697:j_idt705")).click();
        // check if the right element got selected
        DataListWrapper list = PrimeWrapper.findDataList(driver, "j_idt697:j_idt710");
        assertEquals("Miami", list.getListElement(1).getText());
        assertEquals("Berlin", list.getListElement(2).getText());
        assertEquals("Amsterdam", list.getListElement(3).getText());
    }


    @Test
    public void testCheckboxMenuGrouped() throws InterruptedException {
        driver.get("https://primefaces.org/showcase/ui/input/checkboxMenu.xhtml");
        SelectCheckboxMenuWrapper checkBoxMenu = PrimeWrapper.findCheckBoxMenu(driver, "j_idt697:grouped");
        checkBoxMenu.selectByValue("BMW");
        checkBoxMenu.selectByValue("GM");
        checkBoxMenu.selectByValue("Ford");
        // submit
        driver.findElement(By.id("j_idt697:j_idt705")).click();
        // check if the right element got selected
        DataListWrapper list = PrimeWrapper.findDataList(driver, "j_idt697:j_idt713");
        assertEquals("BMW", list.getListElement(1).getText());
        assertEquals("GM", list.getListElement(2).getText());
        assertEquals("Ford", list.getListElement(3).getText());
    }
}
