package tests;

import manager.ApplicationManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {

   static ApplicationManager app = new ApplicationManager();
 //   WebDriver wd;

    @BeforeMethod
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//    }
    public void setup(){
       app.init();
    }

    @AfterMethod
//    public void tearDown(){
//        pause(3000);
//        wd.quit();
//    }
    public void stop(){
        app.tearDown();
    }



    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isAlertPresent(){
        Alert alert = new WebDriverWait(wd, Duration.ofSeconds(3))
                .until(ExpectedConditions.alertIsPresent()); //ждем, присутствует ли окошко Алерта на браузере
        if(alert == null) return false;
        wd.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        return true;
    }

    public void openLoginRegistrationForm(){
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
    }

    public void fillLoginRegistrationForm(String email, String password){
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]")); // создали здесь переменную, потому
//        // что будем к ней обращаться несколько раз
//        emailInput.click();
//        emailInput.clear(); // очищаем форму логина
//        emailInput.sendKeys(email); // вставляем адрес


//        WebElement passInput = wd.findElement(By.xpath("//input[2]")); // создали здесь переменную, потому
//        // что будем к ней обращаться несколько раз
//        passInput.click();
//        passInput.clear(); // очищаем форму логина
//        passInput.sendKeys(password); // вставляем пароль

        type(By.xpath("//input[1]"),email );
        type(By.xpath("//input[2]"),password);
    }

    public void submitLogin(){
        wd.findElement(By.xpath("//button[1]")).click();
    }

    public boolean isElementPresent(By locator){
       return wd.findElements(locator).size() > 0;
    }

    public void logout(){
        click(By.xpath("//*[.='Sign Out']"));

    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void type(By locator, String text){
        WebElement element = wd.findElement(locator);
        // что будем к ней обращаться несколько раз
        element.click();
        element.clear(); // очищаем форму логина
        element.sendKeys(text); // вставляем адрес
    }

    public boolean isLogged(){ //метод для проверки, что мы залогинились
        return isElementPresent(By.xpath("//*[.='Sign Out']"));
    }
}
