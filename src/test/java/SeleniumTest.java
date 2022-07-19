import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    /*
    Tölts be a böngészőbe az alábbi oldalt: https://demo.seleniumeasy.com/basic-first-form-demo.html
    Írj tesztesetet két szám összegének ellenőrzésére a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. Az oldalon, a Two Input Fields” szekcióban két beviteli mezőjét töltsd ki tetszőleges számokkal, majd végezd el a számok összeadásának ellenőrzését kiolvasva az oldalon megjelenő összeget.
    Használj tetszőleges tesztadatot
     */
    @DisplayName("Sum of two numbers")
    @Test
    public void TestInput() throws InterruptedException {
        TwoInputField twoInputField = (TwoInputField) Factory.Create("TwoInputField", driver);
        twoInputField.navigateToUrl();
        twoInputField.fillWithNumbers("3", "5");
        twoInputField.pushTheButton();
        String actual = twoInputField.summedNumbers();
        String expected = "8";
        Assertions.assertEquals(expected, actual);

    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: zhttps://demo.seleniumeasy.com/basic-select-dropdown-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet a következők szerint: a Select List Demo szekció lenyíló mezőjében válaszd ki a hét utolsó napját és ellenőrizd, hogy az oldalon helyesen jelenik meg a kiválasztott érték
    Tesztadatként használd az hét utolsó napját
     */
    @Description("Last day of the week selected")
    @Test
    public void SelectDayTest() {
        DaySelector daySelector = (DaySelector) Factory.Create("Days", driver);
        daySelector.navigateUrl();
        daySelector.selectLastDay("Sunday");
        String actual = daySelector.lastDaySelected();
        String expected = "Day selected :- Sunday";

        Assertions.assertEquals(expected, actual);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/bootstrap-modal-demo.html#
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. A tesztesetben ellenőrizd a modal alert ablak szöveges tartalmát összahasonlítva egy általad definiált elvárt eredménnyel. Nyisd meg a Single Modal ablakot, tárolt el az ablakon megjelenő szöveget egy változóba és zárd be az ablakot a bezárás gombbal
     */
    @Description("Text from Modal window")
    @Test
    public void AlertTest() throws InterruptedException {
        SingleModal singleModal = (SingleModal) Factory.Create("Modal", driver);
        singleModal.navigateUrl();
        singleModal.openModal();
        Thread.sleep(1500);
        String actual = singleModal.textFromModal();
        singleModal.closeModal();

        String expected = "This is the place where the content for the modal dialog displays";

        Assertions.assertEquals(expected, actual);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/data-list-filter-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. A teszteset ellenőrizze a névjegykártyák tartalmát.Olvasd ki a neveket a megjelenő névjegykártyákról és ellenőrzésként hasonlítsd össze egy elvárt eredményként megadott listával.
    Használj relatív útvonalat a névjegykártya név elemeinek kiolvasásához.
     */
    @Description("Get the names from the namecards")
    @Test
    public void NamecardTest() {
        vCard vCard = (vCard) Factory.Create("vCard", driver);
        vCard.navigateURL();
        List<String> actual = vCard.nameList();
        List<String> expected = Arrays.asList("Tyreese Burn", "Brenda Tree", "Glenn Pho shizzle", "Brian Hoyies", "Glenn Pho shizzle", "Arman Cheyia");

        Assertions.assertEquals(expected, actual);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/table-data-download-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. A tesztesetet ellenőrizze a táblázatból a neveket, amelyeket a táblázat első oszlop tartalmaz. Gyűjtsd össze a neveket és tárold le a names.txt fájlba majd a tesztesetben a fájl tartalmát hasonlítsd össze egy elvárt eredménnyel.
     */
    @Description("Names to file from table")
    @Test
    public void TableTest() {
        Table table = (Table) Factory.Create("Table", driver);
        table.navigateURL();
        table.namesToFile();
        List<String> actual = table.namesFromFile();
        List<String> expected = Arrays.asList(
                "Tiger Nixon",
                "Garrett Winters",
                "Ashton Cox",
                "Cedric Kelly",
                "Airi Satou",
                "Brielle Williamson",
                "Herrod Chandler",
                "Rhona Davidson",
                "Colleen Hurst",
                "Sonya Frost",
                "Jena Gaines",
                "Quinn Flynn",
                "Charde Marshall",
                "Haley Kennedy",
                "Tatyana Fitzpatrick",
                "Michael Silva",
                "Paul Byrd",
                "Gloria Little",
                "Bradley Greer",
                "Dai Rios",
                "Jenette Caldwell",
                "Yuri Berry",
                "Caesar Vance",
                "Doris Wilder",
                "Angelica Ramos",
                "Gavin Joyce",
                "Jennifer Chang",
                "Brenden Wagner",
                "Fiona Green",
                "Shou Itou",
                "Michelle House");

        Assertions.assertEquals(expected, actual);

    }


    //XPATH a modalnál, vcardnál!!!!!!!!!!
    @AfterEach
    public void Nuke() {
        driver.quit();
    }

}
