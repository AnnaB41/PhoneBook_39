package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {



    WebDriver wd;

    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void tearDown(){
       wd.quit();
    }
}
