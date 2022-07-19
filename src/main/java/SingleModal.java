import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingleModal extends BasePage{

    public SingleModal(WebDriver driver) {
        super(driver);
    }

    private String url = "https://demo.seleniumeasy.com/bootstrap-modal-demo.html#";
    private final By modalButton = By.xpath("//a[contains(@href, '#myModal0')]");

    private final By modalText = By.xpath("//*[@id=\"myModal0\"]/div/div/div[3]");
    private final By modalExit = By.xpath("//*[@id=\"myModal0\"]/div/div/div[4]/a[1]");


    public void navigateUrl()
    {
        driver.navigate().to(url);
    }

    public void openModal()
    {
        driver.findElement(modalButton).click();
    }

    public String textFromModal()
    {
        driver.switchTo().activeElement();

        String result = driver.findElement(modalText).getText();

        return result;
    }

    public void closeModal()
    {
        driver.findElement(modalExit).click();
    }

}
