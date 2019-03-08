package PrimeWrapper.Wrapper;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.MatchesPattern.matchesPattern;


public class TestDataListWrapper {
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

    @Before
    public void before(){
        driver.get("http://localhost:8080/DataList.xhtml");
    }

    @Test
    public void testDataListWrapperBasic() {
        DataListWrapper list = PrimeWrapper.findDataList(driver, "form:basic");
        for(int i = 0; i < 10; i++)
            assertThat(list.getListElements().get(i).getText(), matchesPattern("^\\w+, \\d{4}$"));
    }

    @Test
    public void testDataListWrapperDefinition() {
        DataListWrapper list = PrimeWrapper.findDataList(driver, "form:definition");
        for(int i = 0; i < 5; i++)
            assertThat(list.getListElements().get(i).getText(), matchesPattern("^Brand: \\w+, Year: \\d{4}$"));
    }

    @Test
    public void testDataListWrapperPaginator() {
        DataListWrapper list = PrimeWrapper.findDataList(driver, "form:paginator");
        for(int i = 0; i < 10; i++){
            WebElement listElement = list.getListElements().get(i);
            assertThat(listElement.findElement(By.xpath("span")).getText(), matchesPattern("^\\w+, \\d{4}$"));
        }
    }
}
