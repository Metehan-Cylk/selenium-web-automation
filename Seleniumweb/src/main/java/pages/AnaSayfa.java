package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AnaSayfa {
    public static WebDriver driver;

    public AnaSayfa(WebDriver webDriver){
        driver = webDriver;
    }
    public WebElement girisbul(){ //giriş yap yerini bulma
        WebElement bul1 = driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[1]/div"));
        return bul1;
    }
    public WebElement giristikla(){//giriş yap yerine tıklama
        WebElement tikla1 = driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div"));
        return tikla1;
    }

    public WebElement girisisim(){//ıd yeri
        WebElement isim = driver.findElement(By.xpath("//*[@id=\"L-UserNameField\"]"));
        return isim;
    }
    public WebElement girissifre(){//şifre yeri
        WebElement sifre= driver.findElement(By.xpath("//*[@id=\"L-PasswordField\"]"));
        return sifre;
    }
    public WebElement girisyap(){//siteye login olma
        WebElement girisbuton= driver.findElement(By.xpath("//*[@id=\"gg-login-enter\"]"));
        return girisbuton;
    }


}
