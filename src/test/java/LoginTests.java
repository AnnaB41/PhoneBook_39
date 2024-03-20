import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests {
    WebDriver wd;

    @BeforeMethod
    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void loginPositiveTest(){
        // open login form, find by text
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        //fill login form
        WebElement emailInput = wd.findElement(By.xpath("//input[1]")); // создали здесь переменную, потому
        // что будем к ней обращаться несколько раз
        emailInput.click();
        emailInput.clear(); // очищаем форму логина
        emailInput.sendKeys("myemail5@mail.com"); // вставляем адрес

        WebElement passInput = wd.findElement(By.xpath("//input[2]")); // создали здесь переменную, потому
        // что будем к ней обращаться несколько раз
        passInput.click();
        passInput.clear(); // очищаем форму логина
        passInput.sendKeys("Tt123456$"); // вставляем пароль

        // click on button login
        wd.findElement(By.xpath("//button[1]")).click();
        // assert ищем коллекцию по Баттон (1 кнопка) и ее размер. Если кнопка есть, то размер коллекции меньше 1
        pause(3000);
        Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);
    }
    @Test
    public void loginNegativeTestWrongEmail(){
        // open login form, find by text
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        //fill login form
        WebElement emailInput = wd.findElement(By.xpath("//input[1]")); // создали здесь переменную, потому
        // что будем к ней обращаться несколько раз
        emailInput.click();
        emailInput.clear(); // очищаем форму логина
        emailInput.sendKeys("myemail5mail.com"); // вставляем адрес

        WebElement passInput = wd.findElement(By.xpath("//input[2]")); // создали здесь переменную, потому
        // что будем к ней обращаться несколько раз
        passInput.click();
        passInput.clear(); // очищаем форму логина
        passInput.sendKeys("Tt123456$"); // вставляем пароль

        // click on button login
        wd.findElement(By.xpath("//button[1]")).click();
        // assert ищем коллекцию по Баттон (1 кнопка) и ее размер. Если кнопка есть, то размер коллекции меньше 1
        pause(3000);

    } @Test
    public void loginNegativeTestWrongPassword(){
        // open login form, find by text
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        //fill login form
        WebElement emailInput = wd.findElement(By.xpath("//input[1]")); // создали здесь переменную, потому
        // что будем к ней обращаться несколько раз
        emailInput.click();
        emailInput.clear(); // очищаем форму логина
        emailInput.sendKeys("myemail5@mail.com"); // вставляем адрес

        WebElement passInput = wd.findElement(By.xpath("//input[2]")); // создали здесь переменную, потому
        // что будем к ней обращаться несколько раз
        passInput.click();
        passInput.clear(); // очищаем форму логина
        passInput.sendKeys("Tt123456"); // вставляем пароль

        // click on button login
        wd.findElement(By.xpath("//button[1]")).click();
        // assert пока нет
        pause(3000);

    }

    @AfterMethod
    public void tearDown(){
        pause(3000);
        wd.quit();
    }


    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
