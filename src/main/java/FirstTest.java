import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class FirstTest {

    WebDriver driver;

    @BeforeTest
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 720));
    }

    @AfterTest
    public void driverQuit() {
        //Zamyka okno przeglądarki
        driver.close();
        //Zamyka sesje
        driver.quit();
    }

    @Test
    public void navigate() {
        driver.get("https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna");
        driver.navigate().to("https://nasa.gov");
        driver.navigate().back();
        String entryURL = "https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna";
        Assert.assertEquals(entryURL, driver.getCurrentUrl(), "URl is not correct");
        String title = "Wikipedia, wolna encyklopedia";
        Assert.assertEquals(title, driver.getTitle(), "The title of the page is not" + title);
        driver.navigate().forward();
        String titleNasa = "NASA";
        Assert.assertEquals(titleNasa,driver.getTitle(), "The title of the page is not" + titleNasa);

    }
}
