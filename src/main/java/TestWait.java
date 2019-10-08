import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestWait {
    public static void main(String[] args) {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.google.com.ua/");


        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hplogo")));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("MiYK0e")));

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver){
                System.out.println(driver.getTitle());
                return  driver.getTitle().startsWith("Goo");
            }
        });



    }
}
