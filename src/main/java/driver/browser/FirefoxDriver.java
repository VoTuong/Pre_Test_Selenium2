package driver.browser;

import com.pretestsele2.common.Constants;
import driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriver extends DriverManager {
    @Override
    public WebDriver createDriver() {
        WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();

        return new org.openqa.selenium.firefox.FirefoxDriver(getOptions());
    }

    @Override
    public FirefoxOptions getOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("headless=new");;

        return firefoxOptions;
    }
}
