import com.thoughtworks.gauge.Step;
import io.testinium.base.BasePage;
import org.openqa.selenium.By;

import java.io.IOException;

import static io.testinium.constant.ConstantsHomePage.*;


public class StepImplementation{
    private BasePage basePage;

    public StepImplementation(){basePage= new BasePage();};

    @Step("Navigate to <url>")
    public void navigateTo(String url){ ;
        basePage.navigateUrl(url);
    }

    @Step("<key> elementine hover olundu")
    public void hoverElement(String key) {
        basePage.hoverElement(By.linkText(key));
    }
    @Step("<key> elemente tıklandı")
    public void clickGiysi(String key) {
        basePage.click(By.linkText(key));

    }
    @Step("URL'nin <key> içerdiği doğrulandı")
    public void assertGiysi(String key) {
        basePage.assertURL("https://www.beymen.com/"+key+"-10020");
    }

    @Step("İndirimden elde edilen kar hesaplandı")
    public void checkDiscount() throws IOException {
        basePage.writeTxt(OLD_PRICE,NEW_PRICE);

    }

}