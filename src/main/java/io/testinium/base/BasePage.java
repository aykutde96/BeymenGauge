package io.testinium.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class BasePage {

    public final Logger logger = LogManager.getLogger(BasePage.class);
    private final WebDriver webDriver;
    WebDriverWait webDriverWait;

    public BasePage() {
        this.webDriver = BaseTest.webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 10, 400);
    }

    public WebElement findElement(By by) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        return webDriver.findElement(by);
    }

    public void assertURL(String text) {
        Assert.assertEquals(webDriver.getCurrentUrl(),text);
        logger.info("URL Kontrol Edildi.");
    }

    public void writeTxt(By by1,By by2)  throws IOException {
        WebElement oldPrice = findElement(by1);
        WebElement newPrice = findElement(by2);
        logger.info("Fiyatlar Alınıyor");
        String st = oldPrice.getText().replace("TL","");
        String st2 = st.replaceAll("\\.","");
        String st3 = st2.replaceAll(" ","");
        String st4 = st3.replaceAll("\\,","\\.");
        String st5 = st4 + "f";
        float i1 = Float.parseFloat(st5);

        String e = newPrice.getText().replace("TL","");
        String e2 = e.replaceAll("\\.","");
        String e3 = e2.replaceAll(" ","");
        String e4 = e3.replaceAll("\\,","\\.");
        String e5 = e4 + "f";
        float i2 = Float.parseFloat(e5);
        float result = i1-i2;
        String resultString = String.valueOf(result);
        logger.info("Kar Hesaplanıyor");
        FileWriter w = new FileWriter("C:\\Users\\testinium\\Desktop\\IntellijProje\\BeymenGauge\\Fiyatlar.txt");
        BufferedWriter out = new BufferedWriter(w);
        out.write("İndirimden Elde Ettiğiniz Kar: " + resultString + " TL'dir");
        out.flush();
        logger.info("İndirimden Elde Ettiğiniz Kar: " + resultString + " TL'dir");

    }

    public void click(By by) {
        WebElement element = findElement(by);
        if (element != null && !element.isDisplayed()) {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
        }
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        logger.info("Elemente Tıklandı");
    }

    public void hoverElement(By by) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(findElement(by)).build().perform();
        logger.info("Elemente Hover Olundu");
    }

    public BasePage navigateUrl(String url) {

        webDriver.navigate().to(url);
        logger.info(url+ ": Adresine Gidildi.");
        return this;
    }

}
