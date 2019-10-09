import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MainTest {
    public static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Before
    public void Go(){
        driver.get("https://www.google.com.ua/");
    }

    @Test
    public void waitsWork(){
        Assert.assertNotNull(TestWait.waits(driver,2000, By.id("hplogo")));
    }

    @Test(expected = org.openqa.selenium.NoSuchElementException.class)
    public void waitsNoSuchElementExp(){
        TestWait.waits(driver,2000, By.id("hogo"));
    }

    @Test(expected = org.openqa.selenium.NoSuchElementException.class)
    public void waitsTimeoutExp(){
        TestWait.waits(driver,100,By.id("hogo"));
    }


}
