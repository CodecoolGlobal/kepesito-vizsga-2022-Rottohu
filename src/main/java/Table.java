import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Table extends BasePage {

    public Table(WebDriver driver) {
        super(driver);
    }

    private String url = "https://demo.seleniumeasy.com/table-data-download-demo.html";

    private By names = By.xpath("//tr[@role=\"row\"]/*[1]");

    public void navigateURL() {
        driver.navigate().to(url);
    }

    public List<String> namesToFile() {

        List <String> retList = new ArrayList<>();

        List<WebElement> nameList = driver.findElements(names);

        try {
            FileWriter fWriter = new FileWriter("names.txt");

            for (int i = 0; i < nameList.size(); i++) {
                String name = nameList.get(i).getText();
                retList.add(name);
                fWriter.write(name + "\n");
            }

            fWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return retList;
    }

    public List<String> namesFromFile()
    {
        Scanner s = null;
        try {
            s = new Scanner(new File("names.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String> retList = new ArrayList<String>();
        while (s.hasNextLine()){
            retList.add(s.nextLine());
        }
        s.close();

        return retList;
    }

}
