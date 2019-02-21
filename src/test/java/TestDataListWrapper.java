
import org.junit.AfterClass;
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

    @Test
    public void testDataListWrapperBasic() throws InterruptedException {
        driver.get("http://localhost:9090/DataListWrapper.xhtml");
        DataListWrapper list = PrimeWrapper.findDataList(driver, "form:basic");
        for(int i = 1; i <= 10; i++)
            assertThat(list.getListElement(i).getText(), matchesPattern("^\\w+, \\d{4}$"));
    }

    @Test
    public void testDataListWrapperDefinition() throws InterruptedException {
        driver.get("http://localhost:9090/DataListWrapper.xhtml");
        DataListWrapper list = PrimeWrapper.findDataList(driver, "form:definition");
        for(int i = 1; i <= 5; i++)
            assertThat(list.getListElement(i).getText(), matchesPattern("^Brand: \\w+, Year: \\d{4}$"));
    }

    @Test
    public void testDataListWrapperPaginator() throws InterruptedException {
        driver.get("http://localhost:9090/DataListWrapper.xhtml");
        DataListWrapper list = PrimeWrapper.findDataList(driver, "form:paginator");
        for(int i = 1; i <= 10; i++){
            WebElement listElement = list.getListElement(i);
            assertThat(listElement.findElement(By.xpath("span")).getText(), matchesPattern("^\\w+, \\d{4}$"));
        }
    }
}
