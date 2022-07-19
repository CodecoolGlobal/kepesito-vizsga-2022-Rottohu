import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TwoInputField extends BasePage {
    public TwoInputField(WebDriver driver) {
        super(driver);
    }

    private final String url = "https://demo.seleniumeasy.com/basic-first-form-demo.html";

    private final By firstNum = By.id("sum1");
    private final By secondNum = By.id("sum2");
    private final By sumButton = By.xpath("//*[@onclick=\"return total()\"]");
    private final By total = By.id("displayvalue");

    private final By lightboxClose = By.xpath("//*[@id=\"at-cv-lightbox-close\"]");

    public void navigateToUrl() throws InterruptedException {
        driver.navigate().to(url);
        Thread.sleep(1500);
        driver.findElement(lightboxClose).click();
    }

    public void fillWithNumbers(String first, String second) {
    driver.findElement(firstNum).sendKeys(first);
    driver.findElement(secondNum).sendKeys(second);
    }

    public void pushTheButton() {
        driver.findElement(sumButton).click();
    }

    public String summedNumbers()
    {
        return driver.findElement(total).getText();
    }
}
