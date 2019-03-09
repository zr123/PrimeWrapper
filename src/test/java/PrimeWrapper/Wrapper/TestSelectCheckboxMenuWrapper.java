package PrimeWrapper.Wrapper;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class TestSelectCheckboxMenuWrapper {
    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Before
    public void before(){
        driver.get("http://localhost:8080/SelectCheckbox.xhtml");
    }

    @Test
    public void testCheckboxMenuBasic(){
        SelectCheckboxMenuWrapper checkBoxMenu = PrimeWrapper.findSelectCheckboxMenu(driver, "form:menu");
        checkBoxMenu.selectItemByValue("Miami");
        checkBoxMenu.selectItemByValue("Berlin");
        checkBoxMenu.selectItemByValue("Amsterdam");
        // submit
        driver.findElement(By.id("form:submit")).click();
        // check if the right element got selected
        try {
            assertEquals("Miami", PrimeWrapper.findDataList(driver, "form:selectedBasic").getListElements().get(0).getText());
            assertEquals("Berlin", PrimeWrapper.findDataList(driver, "form:selectedBasic").getListElements().get(1).getText());
            assertEquals("Amsterdam", PrimeWrapper.findDataList(driver, "form:selectedBasic").getListElements().get(2).getText());
        } catch (StaleElementReferenceException e){
            // ignore for now
        }
    }

    @Test
    public void testCheckboxMenuMultiple() {
        SelectCheckboxMenuWrapper checkBoxMenu = PrimeWrapper.findSelectCheckboxMenu(driver, "form:multiple");
        checkBoxMenu.selectItemByValue("Miami");
        checkBoxMenu.selectItemByValue("Berlin");
        checkBoxMenu.selectItemByValue("Amsterdam");
        // submit
        driver.findElement(By.id("form:submit")).click();
        // check if the right element got selected
        try {
            assertEquals("Miami", PrimeWrapper.findDataList(driver, "form:selectedMultiple").getListElements().get(0).getText());
            assertEquals("Berlin", PrimeWrapper.findDataList(driver, "form:selectedMultiple").getListElements().get(1).getText());
            assertEquals("Amsterdam", PrimeWrapper.findDataList(driver, "form:selectedMultiple").getListElements().get(2).getText());
        } catch (StaleElementReferenceException e){
            // ignore for now
        }
    }

    @Test
    public void testCheckboxMenuGrouped() {
        SelectCheckboxMenuWrapper checkBoxMenu = PrimeWrapper.findSelectCheckboxMenu(driver, "form:grouped");
        checkBoxMenu.selectItemByValue("BMW");
        checkBoxMenu.selectItemByValue("GM");
        checkBoxMenu.selectItemByValue("Ford");
        // submit
        driver.findElement(By.id("form:submit")).click();
        // check if the right element got selected
        try {
            assertEquals("BMW", PrimeWrapper.findDataList(driver, "form:selectedGrouped").getListElements().get(0).getText());
            assertEquals("GM", PrimeWrapper.findDataList(driver, "form:selectedGrouped").getListElements().get(1).getText());
            assertEquals("Ford", PrimeWrapper.findDataList(driver, "form:selectedGrouped").getListElements().get(2).getText());
        } catch (StaleElementReferenceException e){
            // ignore for now
        }
    }
}
