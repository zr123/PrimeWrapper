
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class TestPrimeWrapper {
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
    public void testCheckboxMenuWrapper1() throws InterruptedException {
        driver.get("https://primefaces.org/showcase/ui/input/checkboxMenu.xhtml");
        SelectCheckboxMenuWrapper checkBoxMenu = PrimeWrapper.findCheckBoxMenu(driver, "j_idt694:menu");
        checkBoxMenu.selectByValue("Miami");
        checkBoxMenu.selectByValue("Berlin");
        checkBoxMenu.selectByValue("Amsterdam");
        // submit
        driver.findElement(By.id("j_idt694:j_idt702")).click();
        // check if the right element got selected
        DataListWrapper list = PrimeWrapper.findDataList(driver, "j_idt694:j_idt704");
        assertEquals("Miami", list.getElement(1));
        assertEquals("Berlin", list.getElement(2));
        assertEquals("Amsterdam", list.getElement(3));
    }

    @Test
    public void testCheckboxMenuWrapper2() throws InterruptedException {
        driver.get("https://primefaces.org/showcase/ui/input/checkboxMenu.xhtml");
        SelectCheckboxMenuWrapper checkBoxMenu = PrimeWrapper.findCheckBoxMenu(driver, "j_idt694:multiple");
        checkBoxMenu.selectByValue("Miami");
        checkBoxMenu.selectByValue("Berlin");
        checkBoxMenu.selectByValue("Amsterdam");
        // submit
        driver.findElement(By.id("j_idt694:j_idt702")).click();
        // check if the right element got selected
        DataListWrapper list = PrimeWrapper.findDataList(driver, "j_idt694:j_idt707");
        assertEquals("Miami", list.getElement(1));
        assertEquals("Berlin", list.getElement(2));
        assertEquals("Amsterdam", list.getElement(3));
    }


    @Test
    public void testCheckboxMenuWrapper3() throws InterruptedException {
        driver.get("https://primefaces.org/showcase/ui/input/checkboxMenu.xhtml");
        SelectCheckboxMenuWrapper checkBoxMenu = PrimeWrapper.findCheckBoxMenu(driver, "j_idt694:grouped");
        checkBoxMenu.selectByValue("BMW");
        checkBoxMenu.selectByValue("GM");
        checkBoxMenu.selectByValue("Ford");
        // submit
        driver.findElement(By.id("j_idt694:j_idt702")).click();
        // check if the right element got selected
        DataListWrapper list = PrimeWrapper.findDataList(driver, "j_idt694:j_idt710");
        assertEquals("BMW", list.getElement(1));
        assertEquals("GM", list.getElement(2));
        assertEquals("Ford", list.getElement(3));
    }
}
