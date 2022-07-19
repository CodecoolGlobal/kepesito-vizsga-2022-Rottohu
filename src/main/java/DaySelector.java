import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DaySelector extends BasePage{

    public DaySelector(WebDriver driver) {
        super(driver);
    }

    private final String url = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";

    private final By dropDownMenu = By.id("select-demo");

    private final By lastDay = By.name("Sunday");
    private final By selectedDay = By.className("selected-value");

    public void navigateUrl()
    {
        driver.navigate().to(url);
    }

    public void selectLastDay(String day)
    {
        Select drpDays = new Select(driver.findElement(dropDownMenu));
        drpDays.selectByVisibleText(day);
    }

    public String lastDaySelected()
    {
        return driver.findElement(selectedDay).getText();
    }
}
