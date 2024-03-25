package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd){ // это кастомный конструктор,
        super(wd); // вызывается конструктор супер класса, родительский
    }

    public boolean isLogged(){ //метод для проверки, что мы залогинились

        return isElementPresent(By.xpath("//*[.='Sign Out']"));
    }

    public void logout(){
        click(By.xpath("//*[.='Sign Out']"));

    }
    public void submitLogin(){
        wd.findElement(By.xpath("//button[1]")).click();
    }

    public void submitRegistration(){
        wd.findElement(By.xpath("//button[2]")).click();
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

    public void openLoginRegistrationForm(){

        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
    }
}
