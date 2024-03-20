import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    WebDriver wd;

    @BeforeMethod
    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void registrationPositiveTest(){
        // open login form, find by text
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        //fill login form
        int i = (int)(System.currentTimeMillis()/1000)%3600; // получаем рандомное число, приводим в инт
        WebElement emailInput = wd.findElement(By.xpath("//input[1]")); // создали здесь переменную, потому
        // что будем к ней обращаться несколько раз
        emailInput.click();
        emailInput.clear(); // очищаем форму логина
        emailInput.sendKeys("mye" + i +"@mail.com"); // вставляем адрес с рандомным числом

        WebElement passInput = wd.findElement(By.xpath("//input[2]")); // создали здесь переменную, потому
        // что будем к ней обращаться несколько раз
        passInput.click();
        passInput.clear(); // очищаем форму логина
        passInput.sendKeys("Tt123456$"); // вставляем пароль

        // click on button registration
        wd.findElement(By.xpath("//button[2]")).click();
        // assert ищем коллекцию по Баттон (1 кнопка) и ее размер. Если кнопка есть, то размер коллекции меньше 1
        //   pause(3000);
        Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);
    }

    @Test
    public void registrationNegativeTestWrongEmail(){
        // open login form, find by text
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        //fill login form
        int i = (int)(System.currentTimeMillis()/1000)%3600; // получаем рандомное число, приводим в инт
        WebElement emailInput = wd.findElement(By.xpath("//input[1]")); // создали здесь переменную, потому
        // что будем к ней обращаться несколько раз
        emailInput.click();
        emailInput.clear(); // очищаем форму логина
        emailInput.sendKeys("mye" + i +"mail.com"); // вставляем адрес с рандомным числом

        WebElement passInput = wd.findElement(By.xpath("//input[2]")); // создали здесь переменную, потому
        // что будем к ней обращаться несколько раз
        passInput.click();
        passInput.clear(); // очищаем форму логина
        passInput.sendKeys("Tt123456$"); // вставляем пароль

        // click on button registration
        wd.findElement(By.xpath("//button[2]")).click();
        // assert ищем коллекцию по Баттон (1 кнопка) и ее размер. Если кнопка есть, то размер коллекции меньше 1
        //   pause(3000);

    }

    @Test
    public void registrationNegativeTestWrongPassword(){
        // open login form, find by text
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        //fill login form
        int i = (int)(System.currentTimeMillis()/1000)%3600; // получаем рандомное число, приводим в инт
        WebElement emailInput = wd.findElement(By.xpath("//input[1]")); // создали здесь переменную, потому
        // что будем к ней обращаться несколько раз
        emailInput.click();
        emailInput.clear(); // очищаем форму логина
        emailInput.sendKeys("mye" + i +"@mail.com"); // вставляем адрес с рандомным числом

        WebElement passInput = wd.findElement(By.xpath("//input[2]")); // создали здесь переменную, потому
        // что будем к ней обращаться несколько раз
        passInput.click();
        passInput.clear(); // очищаем форму логина
        passInput.sendKeys("Tt123456"); // вставляем пароль

        // click on button registration
        wd.findElement(By.xpath("//button[2]")).click();
        // assert ищем коллекцию по Баттон (1 кнопка) и ее размер. Если кнопка есть, то размер коллекции меньше 1
        //   pause(3000);

    }

    @Test
    public void registrationNegativeTestUserExist(){
        // open login form, find by text
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        //fill login form
        WebElement emailInput = wd.findElement(By.xpath("//input[1]")); // создали здесь переменную, потому
        // что будем к ней обращаться несколько раз
        emailInput.click();
        emailInput.clear(); // очищаем форму логина
        emailInput.sendKeys("myemail5@mail.com"); // вставляем адрес с рандомным числом

        WebElement passInput = wd.findElement(By.xpath("//input[2]")); // создали здесь переменную, потому
        // что будем к ней обращаться несколько раз
        passInput.click();
        passInput.clear(); // очищаем форму логина
        passInput.sendKeys("Tt123456$"); // вставляем пароль

        // click on button registration
        wd.findElement(By.xpath("//button[2]")).click();
        // assert ищем коллекцию по Баттон (1 кнопка) и ее размер. Если кнопка есть, то размер коллекции меньше 1
        //   pause(3000);

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
