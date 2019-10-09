import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestWait {
    public static boolean a=false;
    public static void main(String[] args) {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.google.com.ua/");
        waits(driver,1000,By.id("hplogo"));


        //WebDriverWait wait = new WebDriverWait(driver, 20);

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hplogo")));
//        wait.until(ExpectedConditions.elementToBeClickable(By.className("MiYK0e")));
//
//        wait.until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver driver){
//                System.out.println(driver.getTitle());
//                return  driver.getTitle().startsWith("Goo");
//            }
//        });


        //System.out.println(doesElementE(driver,By.id("hplogo")));

    }

    public static WebElement waits(WebDriver driver, long time, By locator){
        WebElement element=null;
        Timer timer = new Timer();
        while(true){
           try {
               a=true;
               timer.schedule(new TimerTask() {
                   @Override
                   public void run() {
                       a=false;
                   }
               }, time);
               if(!a){
               throw new TimeoutException();}
           }catch (TimeoutException e){
               break;
           }
            element = driver.findElement(locator);
           try{
           if(element.isDisplayed()) {
               break;
           }
           }catch (NoSuchElementException e) {
               System.out.println(e);
           }
           }
            return element;
    }
}
