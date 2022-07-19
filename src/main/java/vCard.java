import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class vCard extends BasePage{

    public vCard(WebDriver driver) {
        super(driver);
    }

    private String url = "https://demo.seleniumeasy.com/data-list-filter-demo.html";
    private final By names = By.xpath("//*[@class=\"searchable-container\"]/div/div/h4");

    public void navigateURL()
    {
        driver.navigate().to(url);
    }

    public List<String> nameList()
    {
        List <String> retList = new ArrayList<>();

        List <WebElement> nameCardList = driver.findElements(names);

        for (int i = 0; i < nameCardList.size(); i++) {
            String name = nameCardList.get(i).getText().replace("Name: ", "");
            retList.add(name);
        }

        return retList;
    }

}
