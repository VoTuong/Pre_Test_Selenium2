package base;

import com.pretestsele2.common.Constants;
import listeners.ReportListener;
import driver.DriverManager;
import driver.TargetFactory;
import extentreports.ExtentLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.*;

@Listeners({ReportListener.class})
public class BaseTest {

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser){
        WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(browser));
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
        System.out.println("Starting driver of browser " + browser);
        driver.navigate().to(Constants.URL);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        ExtentLogger.info("Closing browser");
        DriverManager.quit();
    }

}
