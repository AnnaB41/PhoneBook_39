package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{

    @Test
    public void registrationPositiveTest(){
        // open login form, find by text
        app.getHelperUser().openLoginRegistrationForm();
        //fill login form
        int i = (int)(System.currentTimeMillis()/1000)%3600; // получаем рандомное число, приводим в инт
        app.getHelperUser().fillLoginRegistrationForm("mye" + i +"@mail.com", "Tt123456$");
       // click on button registration
       app.getHelperUser().submitRegistration();
        // assert ищем коллекцию по Баттон (1 кнопка) и ее размер. Если кнопка есть, то размер коллекции меньше 1
       app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));

    }

    @Test
    public void registrationNegativeTestWrongEmail(){
        // open login form, find by text
       app.getHelperUser().openLoginRegistrationForm();
        //fill login form
        int i = (int)(System.currentTimeMillis()/1000)%3600; // получаем рандомное число, приводим в инт 4 цифры
        app.getHelperUser().fillLoginRegistrationForm("mye" + i +"mail.com", "Tt123456$");
        // click on button registration
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        app.getHelperUser().pause(3000);

    }

    @Test
    public void registrationNegativeTestWrongPassword(){
        // open login form, find by text
        app.getHelperUser().openLoginRegistrationForm();
        //fill login form
        int i = (int)(System.currentTimeMillis()/1000)%3600; // получаем рандомное число, приводим в инт 4 цифры
        app.getHelperUser().fillLoginRegistrationForm("mye" + i +"@mail.com", "Tt123456");
        // click on button registration
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        app.getHelperUser().pause(3000);
    }

    @Test
    public void registrationNegativeTestUserExist(){
        // open login form, find by text
        app.getHelperUser().openLoginRegistrationForm();
        //fill login form
        app.getHelperUser().fillLoginRegistrationForm("myemail5@mail.com", "Tt123456$");
        // click on button registration
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        app.getHelperUser().pause(3000);
    }
}


