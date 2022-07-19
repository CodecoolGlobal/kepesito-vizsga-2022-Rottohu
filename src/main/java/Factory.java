import org.openqa.selenium.WebDriver;

public class Factory {
    public static BasePage Create(String name, WebDriver driver) {
        return switch (name) {
            case "TwoInputField" -> new TwoInputField(driver);
            case "Days" -> new DaySelector(driver);
            case "Modal" -> new SingleModal(driver);
            case "vCard" -> new vCard(driver);
            case "Table" -> new Table(driver);
            default -> null;
        };
    }
}
