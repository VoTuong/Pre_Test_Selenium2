package general;

import driver.DriverHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase {

    @BeforeMethod
    @Parameters("browser")
    public void setUpBrowser(String browser) {
        DriverHelper.openChromeBrowser();
    }

    @AfterMethod
    public void closeBrowser() {
//        DriverHelper.quitBrowser();
    }
}
