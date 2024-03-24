package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

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
    @Test
    public void loginNegativeTestWrongEmail(){
        // open login form, find by text
       app.getHelperUser().openLoginRegistrationForm();
        //fill login form
       app.getHelperUser().fillLoginRegistrationForm("myemail5mail.com", "Tt123456$");
        // click on button login
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        app.getHelperUser().pause(3000);

    }
    @Test
    public void loginNegativeTestWrongPassword(){
        // open login form, find by text
        app.getHelperUser().openLoginRegistrationForm();
        //fill login form
       app.getHelperUser().fillLoginRegistrationForm("myemail5@mail.com","Tt123456" );
       // click on button login
        app.getHelperUser().submitLogin();
        // assert пока нет
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        app.getHelperUser().pause(3000);

    }

}
