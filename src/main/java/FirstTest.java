import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class FirstTest {


    public WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                return new ChromeDriver();
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                return new FirefoxDriver();
            default:
                throw new InvalidArgumentException("Invalid browser name!!!!");
        }
    }

    @Test
    public void navigate() {
        WebDriver driver = getDriver("Firefox");
        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1280, 720));
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
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open('https://www.google.com', 'blank')");
        driver.switchTo().frame(0);


        driver.navigate().to("https://google.com");
        WebElement agreeButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[2]/div"));
        agreeButton.click();
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("Selenium");
        searchField.sendKeys(Keys.ENTER);
        driver.quit();
//        WebElement result = driver.findElement(By.xpath("/html/body/div[7]/div/div[10]/div[1]/div[2]/div[2]/div/div/div[1]/div/div/div/div[1]/div/a/div/cite"));
//        Assert.assertTrue(result.isDisplayed());

//kij
    }
}

