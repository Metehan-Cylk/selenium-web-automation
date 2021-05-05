package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Sepet {
    public static WebDriver driver;

    public Sepet(WebDriver webDriver) {
        driver = webDriver;
    }
    public WebElement sepetbul(){//sağ üstteki sepet kısmını bulma
        WebElement sptbul=driver.findElement(By.xpath("//*[@id=\"header_wrapper\"]/div[4]/div[3]"));
        return sptbul;
    }
    public WebElement sepetegit(){//sepet kısmına gitme
        WebElement sptgit=driver.findElement(By.xpath("//*[@id=\"header_wrapper\"]/div[4]/div[3]/a"));
        return sptgit;
    }
    public WebElement sepetekle(){//ürün sayfasından sepete ürün ekleme
        WebElement sptekle=driver.findElement(By.xpath("//*[@id=\"add-to-basket\"]"));
        return sptekle;
    }
    public WebElement ilkacis(){//sepet kısmını seçme
        WebElement acisbir=driver.findElement((By.xpath("//*[@id=\"header_wrapper\"]/div[4]/div[3]/div")));
        return acisbir;
    }
    public WebElement ikinciacis(){//alt kısımdaki arayüzü açma
        WebElement acisiki=driver.findElement((By.xpath("//*[@id=\"header_wrapper\"]/div[4]/div[3]/div/div/div/div[2]/div[2]")));
        return acisiki;
    }
    public WebElement sonacis(){//silme ikonunu gösterme
        WebElement acisson=driver.findElement(By.className("user-cart-items-container"));
        return acisson;
    }
    public WebElement sepetsil(){//silme ikonuna tıklama
        WebElement sil=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div[3]/div/div/div/div[2]/div[2]/ul/li/a"));
        return sil;
    }
}