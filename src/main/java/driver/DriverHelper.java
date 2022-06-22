package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.Constants;

public class DriverHelper {
    public static void openChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-features=EnableEphemeralFlashPermission");
        options.addArguments("--disable-infobars");
        options.addArguments("−−lang=en-US");
        Constants.DRIVER = new ChromeDriver(options);
    }

    public static void quitBrowser() {
        Constants.DRIVER.close();
    }
}