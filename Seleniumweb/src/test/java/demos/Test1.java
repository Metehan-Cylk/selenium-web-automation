package demos;
import pages.AnaSayfa;
import pages.SatinAlim;
import pages.Sepet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
import araclar.Log4j;

public class Test1 {
    public static WebDriver driver;
    public String url;
    public static AnaSayfa anaSayfa;
    public static SatinAlim satinalims;
    public static Sepet sepet;
    public JavascriptExecutor executor;
    @Before
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        url = "https://www.gittigidiyor.com";
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(200,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        anaSayfa = new AnaSayfa(driver);
        satinalims= new SatinAlim(driver);
        sepet= new Sepet(driver);
        Log4j.startLog("");
    }

    @Test
    public void runDriver(){
        Actions actions = new Actions(driver);
        executor = (JavascriptExecutor)driver;
        driver.get(url);
        actions.moveToElement(anaSayfa.girisbul()).perform();
        actions.click(anaSayfa.giristikla()).perform();
        if (driver.getCurrentUrl().equals("https://www.gittigidiyor.com/uye-girisi")) {
            Log4j.info("Siteye giris yapıldı");
            anaSayfa.girisisim().sendKeys("metehan_caylak@hotmail.com");
            Log4j.info("Id girildi");
            anaSayfa.girissifre().sendKeys("metehan3");
            Log4j.info("Sifre girildi");
            actions.click(anaSayfa.girisyap()).perform();//giriş butonu//
            if(anaSayfa.girisbul()!=null) {
                Log4j.info("Siteye login olundu.");
                satinalims.yaziyaz().sendKeys("Bilgisayar");
                actions.click(satinalims.butonbas()).perform();//arama butonu//
                String secondPageHref = driver.findElement(By.xpath("//*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a")).getAttribute("href");//ikinci sayfaya geçiş//
                driver.get(secondPageHref);
                String ikincimi = driver.findElement(By.xpath("//*[@id=\"best-match-right\"]/div[4]/ul/li[3]")).getAttribute("class");//ikinci sayfa kontrolü
                if(ikincimi.equals("selected")) {
                    Log4j.info("İkinci sayfaya geçildi.");
                    driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                    actions.moveToElement(satinalims.urunbul()).perform();//ürünün üzerine gelme//
                    driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                    actions.click(satinalims.sepetekle()).perform();//sepete ekle butonu //
                    Log4j.info("Ürün sepete eklendi");
                    driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                    actions.click(satinalims.urunsayfa()).perform();//ürün sayfasına geçiş //
                    actions.moveToElement(sepet.sepetbul()).perform();//sağ üstteki sepetimin üzerine gelme//
                    String fiyat = driver.findElement(By.xpath("//*[@id=\"sp-price-lowPrice\"]")).getText();//fiyatı alma//
                    String sepetFiyat = driver.findElement(By.className("product-new-price")).getText();//sepetteki fiyatı alma//
                    if(fiyat.equals(sepetFiyat)) {
                        Log4j.info("Fiyatlar kontrol edildi; aynı.");
                        executor.executeScript("arguments[0].click();", sepet.sepetekle());
                        Log4j.info("Ürün tekrar sepete eklendi");
                        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                        actions.moveToElement(sepet.ilkacis()).perform();
                        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                        actions.moveToElement(sepet.ikinciacis()).perform();
                        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                        actions.moveToElement(sepet.sonacis()).perform();
                        driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
                        String urunsayisi = driver.findElement(By.className("productQuantity")).getAttribute("value");//urun sayısını sepet küçük arayüzünden alma//
                        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                        if(urunsayisi.equals("2")){
                            Log4j.info("Sepetteki ürün sayısı: 2 ");
                        }
                        else{
                            Log4j.info("Ürün sayısı : " + urunsayisi);
                        }
                        actions.click(sepet.sepetsil()).perform();
                        Log4j.info("Ürünler silindi.");
                        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                        actions.click(sepet.sepetegit()).perform();//sepetime tıklama//
                        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                        String sepetbilgi = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div[1]/div/div[1]")).getAttribute("class");
                        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                        if(sepetbilgi.equals("clearfix")){
                            Log4j.info("Sepet boş");
                        }
                    }
                    else{
                        Log4j.error("Fiyatlar kontrol edildi; farklı");
                    }
                }
                else {
                    Log4j.error("İkinci sayfaya geçilemedi!");
                }
            }
            else{
                Log4j.error("Giriş yapılamadı!");
            }
        }



    Log4j.endLog("");
    }

    @After

    public void endTest(){
        driver.quit();
    }
}