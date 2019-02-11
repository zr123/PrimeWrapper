
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class TestPrimeWrapper {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() throws Exception{
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testCheckboxMenuWrapper1() throws InterruptedException {
        driver.get("https://primefaces.org/showcase/ui/input/checkboxMenu.xhtml");
        CheckboxMenuWrapper checkBoxMenu = PrimeWrapper.findCheckBoxMenu(driver, "j_idt694:menu");
        checkBoxMenu.selectByValue("Miami");
        checkBoxMenu.selectByValue("Berlin");
        checkBoxMenu.selectByValue("Amsterdam");
        // submit
        driver.findElement(By.id("j_idt694:j_idt702")).click();
        // check if the right element got selected
        WebElement resultlist = driver.findElement(By.id("j_idt694:j_idt704_list"));
        assertEquals("Miami\nBerlin\nAmsterdam", resultlist.getText());
    }

    @Test
    public void testCheckboxMenuWrapper2() throws InterruptedException {
        driver.get("https://primefaces.org/showcase/ui/input/checkboxMenu.xhtml");
        CheckboxMenuWrapper checkBoxMenu = PrimeWrapper.findCheckBoxMenu(driver, "j_idt694:multiple");
        checkBoxMenu.selectByValue("Miami");
        checkBoxMenu.selectByValue("Berlin");
        checkBoxMenu.selectByValue("Amsterdam");
        // submit
        driver.findElement(By.id("j_idt694:j_idt702")).click();
        // check if the right element got selected
        WebElement resultlist = driver.findElement(By.id("j_idt694:j_idt707_list"));
        assertEquals("Miami\nBerlin\nAmsterdam", resultlist.getText());
    }


    @Test
    public void testCheckboxMenuWrapper3() throws InterruptedException {
        driver.get("https://primefaces.org/showcase/ui/input/checkboxMenu.xhtml");
        CheckboxMenuWrapper checkBoxMenu = PrimeWrapper.findCheckBoxMenu(driver, "j_idt694:grouped");
        checkBoxMenu.selectByValue("BMW");
        checkBoxMenu.selectByValue("GM");
        checkBoxMenu.selectByValue("Ford");
        // submit
        driver.findElement(By.id("j_idt694:j_idt702")).click();
        // check if the right element got selected
        WebElement resultlist = driver.findElement(By.id("j_idt694:j_idt710_list"));
        assertEquals("BMW\nGM\nFord", resultlist.getText());
    }
}
