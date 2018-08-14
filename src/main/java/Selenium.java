import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Selenium {
    public static String PAGE_TITLE;
    public String Warning_Message;
    public static String EXPECTED_ALERT_MESSAGE="User or Password is not valid";
    TestUtils utils=new TestUtils();






@Test
public void validateLogin() throws InterruptedException, IOException, BiffException {
        String up[][]=TestHelper.getfromExcel(utils.SHEET_LOCATIO,utils.sheetname); //get input data from excel sheet
        for (int i=0;i<up.length;i++){
            String username=up[i][0];
            String password=up[i][1];
            //login(username,password);
        }

    }


    @Test
    public void login() throws InterruptedException, IOException {
        TestServices.getThisLink("https://www.amazon.com/");
        TestServices.waitinSeconds(2);
        WebElement searchDropdownBox=TestServices.findElementbyId("searchDropdownBox");
        Select dropdown=new Select(searchDropdownBox);
        dropdown.selectByVisibleText("Books");
        TestServices.waitinSeconds(2);
        WebElement searchbox=TestServices.findElementbyId("twotabsearchtextbox");
        searchbox.sendKeys("data catalog");
        WebElement searchText=TestServices.findElementbyId("nav-search-submit-text");
        searchText.click();
        TestServices.waitinSeconds(10);
        //closedriver();
    }

    public void closedriver(){
    TestServices.driver.close();
    }



    public String getPAGE_TITLE() {
        return PAGE_TITLE;
    }

    public void setPAGE_TITLE(String PAGE_TITLE) {
        this.PAGE_TITLE = PAGE_TITLE;
    }
}
