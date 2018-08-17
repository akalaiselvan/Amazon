import jxl.read.biff.BiffException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Selenium {
    public static String PAGE_TITLE;

    public Selenium() throws IOException, BiffException {
    }


    /*To lead browser into desired link , Which can be updated in credentials sheet of TestSheet*/
    @BeforeTest
    public void gotoLink() throws InterruptedException {
        TestServices.getThisLink(TestUtils.getSITELINK());
        TestServices.waitinSeconds(2);
    }


    /*First it will select the mentioned category
     * Then type the item name which need to be searhed
     * Clicks search button
     * */

    @Test(priority = 1)
    public void searchItem() throws InterruptedException {
        /* Since we are getting all inputs in excel its mandatory that it shouldn't be empty at any cause*/
        /* To nake sure this each cell has been verified for data using ASSERTION*/
        /* In this method we used Hard assert, if we would have used soft assert then it just skipped the exception*/
        /* To make sure Every cell for data , We using HARD assertion here , so if any fail Test will be terminnated*/
        TestUtils.checkIfAnyEmpty();


        TestServices.waitinSeconds(05);
        WebElement searchDropdownBox = TestServices.findElementbyCSSselector(TestUtils.getGetDropdownPath());
        Select dropdown = new Select(searchDropdownBox);    // Select category from dropdown
        dropdown.selectByVisibleText(TestUtils.getCATEGORY_TOSEARCH());
        TestServices.waitinSeconds(2);
        WebElement searchbox = TestServices.findElementbyCSSselector(TestUtils.getTextboxId());
        searchbox.sendKeys(TestUtils.getItemTosearch());    // type the item name in search box
        WebElement searchText = TestServices.findElementbyCSSselector(TestUtils.getSearchItem());
        searchText.click();                                 // clicks search icon
    }

    /*This method returns the searched item results as list */

    @Test(priority = 2)
    public List<String> getResultsinList() throws InterruptedException {
        List<String> searchResults = new ArrayList<String>();
        TestServices.waitinSeconds(5);  // Hard coded wait statement to view the results
        WebElement getResultId = TestServices.findElementbyCSSselector(TestUtils.getGetresultId());
        List<WebElement> getResultList = getResultId.findElements(By.tagName(TestUtils.getTagLi()));
        for (WebElement webElement : getResultList) {
            searchResults.add(webElement.getAttribute(TestUtils.getAttributeId()));  /*adding found id's in a list*/
        }
        return searchResults;  // Id's added in a List
    }

    /*To click the desired search result
     * nth row,which need to click will be read from TestSheet's Credentials */
    @Test(priority = 3)
    public void getIntoResult() throws InterruptedException, IOException {
        /*Gets the nth results which need to select from TestSheeet and appended that with the searched result's id*/

        WebElement searchResult = TestServices.findElementbyCSSselector("#" + getResultsinList().get(Integer.parseInt(TestUtils.resultToShow())));
        WebElement getAnchorTag = searchResult.findElement(By.tagName(TestUtils.getTagA()));
        String resultLink = getAnchorTag.getAttribute(TestUtils.getAttributeTitle());  //gets the link from Anchor tag
        searchResult.findElement(By.linkText(resultLink)).click();/*Clicks the required result link*/
    }

    /*To get clicked clicked result's Title and Edition if it is there*/
    @Test(priority = 4)
    public void getTitleandEdition() throws FileNotFoundException {
        List<String> getResultTitles = new ArrayList<String>();
        WebElement searchResultTitle = TestServices.findElementbyCSSselector(TestUtils.getSearchresultTitle());
        /*Getting span tag found in the result's titile in a list*/
        List<WebElement> spanTagsinTitleList = searchResultTitle.findElements(By.tagName(TestUtils.getTagSpan()));
        int spancount = 0;
        for (WebElement webElement : spanTagsinTitleList) {
            getResultTitles.add(webElement.getAttribute(TestUtils.getAttributeId()));
            WebElement getTitle;
            try {
                getTitle = TestServices.findElementbyCSSselector("#"+getResultTitles.get(spancount));
                String result = getTitle.getText();
                TestServices.writeToResultFile(result);  // Writes the title to text file
            } catch (Exception e) {
                TestServices.writeToResultFile(getResultTitles.get(spancount));
            }
            spancount++;
        }
    }

    /*To Read the Author Name of selected Book*/
    @Test(priority = 5)
    public void getAuthorName() throws FileNotFoundException {
        if (!TestUtils.getCATEGORY_TOSEARCH().equals("Books")){
            throw new SkipException("Author name in only for Book category");
        }
        List<String> getAuthor = new ArrayList<String>();
        WebElement getTitles = TestServices.findElementbyCSSselector(TestUtils.getAuthorTitle()); // find the title using css selector
        List<WebElement> getSpan = getTitles.findElements(By.tagName(TestUtils.getTagA()));       // getting all span under the title as list
        for (WebElement webElement : getSpan) {                                                   // getting texts from each span in list
            String s = webElement.getText();
            if (!s.equals("")) {
                getAuthor.add(s);
            }
        }
        TestServices.writeToResultFile("Author name : "+getAuthor);  //Writes author name to file
    }

    /*To fetch the Price of the book which is selected
     * After selecting the results only it will read these details*/

    @Test(priority = 6)
    public void getEditionwisePrice() throws FileNotFoundException {

        if (!TestUtils.getCATEGORY_TOSEARCH().equals("Books")){
            throw new SkipException("Edition price fetching is only for Book category");
        }

        /*For few books the price list found to be different, so handled both types which i came through
         * and if it not comes under both types , it will return "No EditionWise Price Found" statement  */

        WebElement getEdition;
        try {
            getEdition = TestServices.findElementbyCSSselector(TestUtils.getEditionPrice());
            List<WebElement> liTaginList = getEdition.findElements(By.tagName(TestUtils.getTagLi()));
            int count = liTaginList.size();
            int n = 1;
            for (WebElement webElement : liTaginList) {
                if (n <= count - 2) {
                    WebElement edition = TestServices.findElementbyCSSselector("#" + webElement.getAttribute(TestUtils.getAttributeId()));
                    TestServices.writeToResultFile("Edition : "+edition.getText());
                    n++;
                }
            }
        } catch (Exception e) {  /*Handled second method in exception*/
            WebElement getEditionviaClass;
            try {
                getEditionviaClass = TestServices.findElementbyCSSselector(TestUtils.getEditionPriceMethod2());
                List<WebElement> liTaginList = getEditionviaClass.findElements(By.tagName(TestUtils.getTagLi()));
                for (WebElement webElement : liTaginList) {
                    TestServices.writeToResultFile("Edition : "+webElement.getText());
                }
            } catch (Exception e1) {
                TestServices.writeToResultFile("No Editionwise Price Found");
            }
        }

    }


    /*This will read the average customer reviews for the selected item*/

    @Test(priority = 7)
    public void getAvgCustomerReview() throws FileNotFoundException {
        WebElement getReview;
        try {
            getReview = TestServices.findElementbyCSSselector(TestUtils.getCustomerReviewid()); // get customer review id using css selector
            String avgReviews = getReview.getAttribute(TestUtils.getAttributeTitle());          // getting the review as title from getReview Id
            TestServices.writeToResultFile("Average customer reviews : "+avgReviews);

        } catch (Exception e) {
            TestServices.writeToResultFile("No Average Reviews Found");
        }
    }


}

