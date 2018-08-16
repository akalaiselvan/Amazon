import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Selenium {
    public static String PAGE_TITLE;
    public String Warning_Message;
    public static String EXPECTED_ALERT_MESSAGE="User or Password is not valid";
    TestUtils utils=new TestUtils();

    public Selenium() throws IOException, BiffException {
    }


//    @Test
//public void validateLogin() throws InterruptedException, IOException, BiffException {
//                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                String up[][]=TestHelper.getfromExcel(utils.SHEET_LOCATIO,utils.sheetname); //get input data from excel sheet
//        for (int i=0;i<up.length;i++){
//            String username=up[i][0];
//            String password=up[i][1];
//            //login(username,password);
//        }
//
//    }


    //@BeforeTest
    public void gotoLink() throws InterruptedException {
        TestServices.getThisLink(TestUtils.getSITELINK());
        TestServices.waitinSeconds(2);
    }

    //@Test(priority = 1)
    public void searchItem() throws InterruptedException {
        WebElement searchDropdownBox=TestServices.findElementbyCSSselector(TestUtils.getGetDropdownPath());
        Select dropdown=new Select(searchDropdownBox);
        dropdown.selectByVisibleText(TestUtils.getCATEGORY_TOSEARCH());
        TestServices.waitinSeconds(2);
        WebElement searchbox=TestServices.findElementbyCSSselector(TestUtils.getTextboxId());
        searchbox.sendKeys(TestUtils.getItemTosearch());
        WebElement searchText=TestServices.findElementbyCSSselector(TestUtils.getSearchItem());
        searchText.click();
    }

    //@Test(priority = 2)
    public List<String> getResultsinList() throws InterruptedException {
        List<String> gettit=new ArrayList<String>();
        TestServices.waitinSeconds(10);
        WebElement parent=TestServices.findElementbyId("atfResults");
        List<WebElement> child=parent.findElements(By.tagName("li"));
        for (WebElement webElement:child){
            gettit.add(webElement.getAttribute("id"));
        }
    return gettit;
    }

    //@Test(priority = 3)
    public void getIntoResult() throws InterruptedException, IOException {
        WebElement getres=TestServices.findElementbyCSSselector("#"+getResultsinList().get(Integer.parseInt(TestUtils.resultToShow())));
        WebElement tagname=getres.findElement(By.tagName("a"));
        String url=tagname.getAttribute("title");
        getres.findElement(By.linkText(url)).click();
    }


    //@Test(priority = 4)
    public void getTitleandEdition() {
        List<String> getTitle = new ArrayList<String>();
        WebElement getTitles = TestServices.findElementbyCSSselector("#title");
        List<WebElement> fetres = getTitles.findElements(By.tagName("span"));
        int n = 0;
        for (WebElement webElement : fetres) {
            getTitle.add(webElement.getAttribute("id"));
            WebElement s; try {
                s = TestServices.findElementbyCSSselector("#" + getTitle.get(n));
                String text = s.getText();
                System.out.println(text);
            } catch (Exception e) {
                e.printStackTrace();
            }
            n++;
        }
    }
    @Test
    public void getAuthorName(){
        TestServices.getThisLink("https://www.amazon.com/catalog-science-applications-flight-missions/dp/1722981881/ref=sr_1_2?s=books&ie=UTF8&qid=1534392831&sr=1-2&keywords=data+catalog&dpID=41PFrwqJ7pL&preST=_SX218_BO1,204,203,200_QL40_&dpSrc=srch");
        List<String> getAuthor=new ArrayList<String>();
        WebElement getTitles = TestServices.findElementbyCSSselector("#bylineInfo");
        List<WebElement> getSpan = getTitles.findElements(By.tagName("a"));
        for (WebElement webElement : getSpan) {
              String s = webElement.getText();
              if (!s.equals("")){
                  getAuthor.add(s);
              }
        }
        System.out.println(getAuthor);
    }
//    span.author:nth-child(1)
//    span.author:nth-child(2)
//    span.author:nth-child(3)




    //@AfterTest
    public void closeDriver(){
        closedriver();
    }





    //"CSS: a[id^='result_']"
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

