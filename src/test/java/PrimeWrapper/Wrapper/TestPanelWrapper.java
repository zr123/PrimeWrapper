package PrimeWrapper.Wrapper;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TestPanelWrapper{

    private static WebDriver driver;

    @BeforeClass
    public static void setup() throws Exception{
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @Before
    public void before(){
        driver.get("http://localhost:8080/Panel.xhtml");
    }

    @Test
    public void testPanelWrapperBasic(){
        PanelWrapper panel = new PanelWrapper(driver, "form:basic");
        assertEquals("Basic", panel.getHeader().getText());
        assertEquals("This is the content.", panel.getContent().getText());
        assertEquals("Details", panel.getFooter().getText());
    }
}
