import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.IOException;

public class TestServices {
    static WebDriver driver;

    TestUtils utils=new TestUtils();

    public TestServices() throws IOException, BiffException {
    }


    public static WebElement findElementbyName(String ByName) {
        By Name = By.name(ByName);
        WebElement webElement = driver.findElement(Name);
        return webElement;
    }

    public static WebElement findElementbyCSSselector(String ByCSS) {
        By CSS = By.cssSelector(ByCSS);
        WebElement webElement = driver.findElement(CSS);
        return webElement;
    }

    public static WebElement findElementbyClass(String ByClass) {
        By Class = By.className(ByClass);
        WebElement webElement = driver.findElement(Class);
        return webElement;
    }

    public static WebElement findElementbyId(String ById) {
        By Id = By.id(ById);
        WebElement webElement = driver.findElement(Id);
        return webElement;
    }
    public String findElementbyTagname(String tagname){
        By findtagname = By.tagName(tagname);
        String finddtag= driver.findElement(findtagname).getText();
        return finddtag;
    }

    public boolean checkAssertEquals(String text1, String text2) {
        boolean assertEquals = false;
        try {
            Assert.assertEquals(text1, text2);
            assertEquals = true;
        } catch (Exception e) {
            assertEquals = false;
        }
        return assertEquals;
    }


    public static void waitinSeconds(int secondsToWait) throws InterruptedException {
        // driver.manage().timeouts().implicitlyWait(secondsToWait, TimeUnit.SECONDS);
        secondsToWait=secondsToWait*1000;
        Thread.sleep(secondsToWait);
    }


    public static void getThisLink(String URL) {
        System.setProperty(TestUtils.getWebdriverGecko(), TestUtils.getGeckodriverPath());
        FirefoxProfile profile=new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(FirefoxDriver.PROFILE,profile);
        driver = new FirefoxDriver(capabilities);
        try {
            driver.get(URL);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void gettet() throws IOException, BiffException {
        String up[][]=TestHelper.getfromExcel(utils.SHEET_LOCATIO,utils.sheetname);
        for (int i=0;i<up.length;i++){
            String username=up[i][0];
            String password=up[i][1];
            System.out.println("USername : "+username+" password : "+password);
        }
    }
}
