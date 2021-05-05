package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SatinAlim {
    public static WebDriver driver;

    public SatinAlim(WebDriver webDriver) {
        driver = webDriver;
    }
    public WebElement yaziyaz(){//arama yerini bulma

        WebElement yazi = driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input"));
        return yazi;
    }
    public WebElement butonbas(){//arama butonu yeri

        WebElement aramabuton= driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[2]/button"));
        return aramabuton;
    }
    public WebElement urunbul(){//seçilen ürünü bulma

        WebElement urun= driver.findElement(By.xpath("//*[@id=\"item-info-block-685103763\"]"));
        return urun;
    }
    public WebElement sepetekle(){//seçilen ürünü sepete ekleme

        WebElement sepetbuton= driver.findElement(By.xpath("//*[@id=\"item-info-block-685103763\"]/div/div[1]/div[3]/button"));
        return sepetbuton;
    }
    public WebElement urunsayfa(){//ürün sayfasına gitme


        WebElement urunbuton=driver.findElement(By.xpath("//*[@id=\"item-info-block-685103763\"]"));
        return urunbuton;
    }


}
