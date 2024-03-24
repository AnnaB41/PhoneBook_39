package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
//    WebDriver wd;
//
//    @BeforeMethod
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//    }

    @Test
    public void loginPositiveTest(){

        app.getHelperUser().openLoginRegistrationForm();
        // open login form, find by text
        //fill login form
        app.getHelperUser().fillLoginRegistrationForm("myemail5@mail.com", "Tt123456$");
        // click on button login
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(3000);
      //  Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));

    }
//    @Test
//    public void loginNegativeTestWrongEmail(){
//        // open login form, find by text
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//        //fill login form
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]")); // создали здесь переменную, потому
//        // что будем к ней обращаться несколько раз
//        emailInput.click();
//        emailInput.clear(); // очищаем форму логина
//        emailInput.sendKeys("myemail5mail.com"); // вставляем адрес
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]")); // создали здесь переменную, потому
//        // что будем к ней обращаться несколько раз
//        passInput.click();
//        passInput.clear(); // очищаем форму логина
//        passInput.sendKeys("Tt123456$"); // вставляем пароль
//
//        // click on button login
//        wd.findElement(By.xpath("//button[1]")).click();
//        Assert.assertTrue(isAlertPresent());
//        pause(3000);
//
//    }
//    @Test
//    public void loginNegativeTestWrongPassword(){
//        // open login form, find by text
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//        //fill login form
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]")); // создали здесь переменную, потому
//        // что будем к ней обращаться несколько раз
//        emailInput.click();
//        emailInput.clear(); // очищаем форму логина
//        emailInput.sendKeys("myemail5@mail.com"); // вставляем адрес
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]")); // создали здесь переменную, потому
//        // что будем к ней обращаться несколько раз
//        passInput.click();
//        passInput.clear(); // очищаем форму логина
//        passInput.sendKeys("Tt123456"); // вставляем пароль
//
//        // click on button login
//        wd.findElement(By.xpath("//button[1]")).click();
//        // assert пока нет
//        pause(3000);
//
//    }
//
//    @AfterMethod
//    public void tearDown(){
//        pause(3000);
//        wd.quit();
//    }


//    public void pause(int millis){
//        try {
//            Thread.sleep(millis);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public boolean isAlertPresent(){
//        Alert alert = new WebDriverWait(wd, Duration.ofSeconds(3))
//                .until(ExpectedConditions.alertIsPresent()); //ждем, присутствует ли окошко Алерта на браузере
//        if(alert == null) return false;
//        wd.switchTo().alert();
//        System.out.println(alert.getText());
//        alert.accept();
//        return true;
//    }

}
