import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TestUtils {
    static Workbook workbook;

    static {
        try {
            workbook = Workbook.getWorkbook(new File("D:\\DON'T DELETE\\Amz\\TestSheet.xls"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }
    private static String TEST_CREDENTIALS_SHEET="Credentials";
    private static String TESTFEED_SHEET="Test_Feed";
    private static Sheet TEST_CREDENTIALS=workbook.getSheet(getTestCredentialsSheet());
    private static Sheet TESTFEED=workbook.getSheet(getTestfeedSheet());
    private static String PICK_NTHRESULT;
    private static String PICK_RESULTS;
    private static String WEBDRIVER_GECKO = "webdriver.gecko.driver";
    private static String geckodriverPath = TESTFEED.getCell(4,1).getContents();;
    public String SHEET_LOCATIO="/home/dell/Documents/seltest.xls";
    public static String sheetname="gtest";

    private static String CATEGORY_TOSEARCH=TEST_CREDENTIALS.getCell(0,1).getContents();
    private static String ITEM_TOSEARCH=TEST_CREDENTIALS.getCell(1,1).getContents();
    private static String SITELINK=TEST_CREDENTIALS.getCell(2,1).getContents();

    private static String DROPDOWN_PATH=TESTFEED.getCell(1,2).getContents();
    private static String TEXTBOX_ID=TESTFEED.getCell(1,3).getContents();
    private static String SEARCH_ITEM=TESTFEED.getCell(1,4).getContents();
    private static String RESULT="";
    private static String RESULT_TOSHOW="";
    private static String RESULT_TXTFILENAME=CATEGORY_TOSEARCH+"_"+ITEM_TOSEARCH;
    

    private static String GETRESULT_ID=TESTFEED.getCell(1,5).getContents();
    private static String TAG_LI=TESTFEED.getCell(3,6).getContents();
    private static String ATTRIBUTE_ID=TESTFEED.getCell(3,7).getContents();
    private static String TAG_A=TESTFEED.getCell(3,8).getContents();
    private static String TAG_SPAN=TESTFEED.getCell(3,9).getContents();
    private static String ATTRIBUTE_TITLE=TESTFEED.getCell(3,10).getContents();
    private static String SEARCHRESULT_TITLE=TESTFEED.getCell(3,11).getContents();
    private static String AUTHOR_TITLE=TESTFEED.getCell(3,12).getContents();
    private static String EDITION_PRICE=TESTFEED.getCell(3,13).getContents();
    private static String EDITION_PRICE_METHOD2=TESTFEED.getCell(3,14).getContents();
    private static String CUSTOMER_REVIEWID=TESTFEED.getCell(3,15).getContents();






    public static String getPickNthresult() {
        return PICK_NTHRESULT;
    }

    public static void setPickNthresult(String pickNthresult) {
        PICK_NTHRESULT = pickNthresult;
    }

    public static String getPickResults() {
        return PICK_RESULTS;
    }

    public static void setPickResults(String pickResults) {
        PICK_RESULTS = pickResults;
    }

    public static String getResultToshow() {
        return RESULT_TOSHOW;
    }

    public static void setResultToshow(String resultToshow) {
        RESULT_TOSHOW = resultToshow;
    }

    public static String getRESULT() {
        return RESULT;
    }

    public static void setRESULT(String RESULT) {
        TestUtils.RESULT = RESULT;
    }

    @Test
    public static String resultToShow(){
        String RESULT_TYPE=TEST_CREDENTIALS.getCell(3,0).getContents();
        if (RESULT_TYPE.equals("nth Result to Pick")){
            setResultToshow(TEST_CREDENTIALS.getCell(3,1).getContents());
        }
        else if (RESULT_TYPE.equals("Number of Results to Show")){
            setResultToshow(TEST_CREDENTIALS.getCell(3,1).getContents());
        }
        int i=Integer.parseInt(getResultToshow())-1;
        setResultToshow(""+i);
        return getResultToshow();
    }



    public TestUtils() throws IOException, BiffException {
    }


    public static String getWebdriverGecko() {
        return WEBDRIVER_GECKO;
    }

    public static String getGeckodriverPath() {
        return geckodriverPath;
    }

    public static String getGetDropdownPath() {
        return DROPDOWN_PATH;
    }

    public static void setGetDropdownPath(String getDropdownPath) {
        DROPDOWN_PATH = getDropdownPath;
    }

    public static String getTextboxId() {
        return TEXTBOX_ID;
    }

    public static void setTextboxId(String textboxId) {
        TEXTBOX_ID = textboxId;
    }

    public static String getSearchItem() {
        return SEARCH_ITEM;
    }

    public static void setSearchItem(String searchItem) {
        SEARCH_ITEM = searchItem;
    }

    public static String getTestCredentialsSheet() {
        return TEST_CREDENTIALS_SHEET;
    }

    public static void setTestCredentialsSheet(String testCredentialsSheet) {
        TEST_CREDENTIALS_SHEET = testCredentialsSheet;
    }

    public static String getTestfeedSheet() {
        return TESTFEED_SHEET;
    }

    public static void setTestfeedSheet(String sheetTestfeedSheet) {
        TESTFEED_SHEET = sheetTestfeedSheet;
    }

    public static String getCATEGORY_TOSEARCH() {
        return CATEGORY_TOSEARCH;
    }

    public static void setCATEGORY_TOSEARCH(String CATEGORY_TOSEARCH) {
        CATEGORY_TOSEARCH = CATEGORY_TOSEARCH;
    }

    public static String getItemTosearch() {
        return ITEM_TOSEARCH;
    }

    public static void setItemTosearch(String itemTosearch) {
        ITEM_TOSEARCH = itemTosearch;
    }

    public static String getSITELINK() {
        return SITELINK;
    }

    public static void setSITELINK(String SITELINK) {
        TestUtils.SITELINK = SITELINK;
    }

    public static String getResultTxtfilename() {
        return RESULT_TXTFILENAME;
    }

    public static String getGetresultId() {
        return GETRESULT_ID;
    }


    public static String getAttributeId() {
        return ATTRIBUTE_ID;
    }

    public static void setAttributeId(String attributeId) {
        ATTRIBUTE_ID = attributeId;
    }

    public static String getTagLi() {
        return TAG_LI;
    }

    public static void setTagLi(String tagLi) {
        TAG_LI = tagLi;
    }

    public static String getTagA() {
        return TAG_A;
    }

    public static void setTagA(String tagA) {
        TAG_A = tagA;
    }

    public static String getAttributeTitle() {
        return ATTRIBUTE_TITLE;
    }

    public static void setAttributeTitle(String attributeTitle) {
        ATTRIBUTE_TITLE = attributeTitle;
    }

    public static String getSearchresultTitle() {
        return SEARCHRESULT_TITLE;
    }

    public static void setSearchresultTitle(String searchresultTitle) {
        SEARCHRESULT_TITLE = searchresultTitle;
    }

    public static String getTagSpan() {
        return TAG_SPAN;
    }

    public static void setTagSpan(String tagSpan) {
        TAG_SPAN = tagSpan;
    }

    public static String getAuthorTitle() {
        return AUTHOR_TITLE;
    }

    public static void setAuthorTitle(String authorTitle) {
        AUTHOR_TITLE = authorTitle;
    }

    public static String getEditionPrice() {
        return EDITION_PRICE;
    }

    public static void setEditionPrice(String editionPrice) {
        EDITION_PRICE = editionPrice;
    }

    public static String getEditionPriceMethod2() {
        return EDITION_PRICE_METHOD2;
    }

    public static void setEditionPriceMethod2(String editionPriceMethod2) {
        EDITION_PRICE_METHOD2 = editionPriceMethod2;
    }

    public static String getCustomerReviewid() {
        return CUSTOMER_REVIEWID;
    }

    public static void setCustomerReviewid(String customerReviewid) {
        CUSTOMER_REVIEWID = customerReviewid;
    }
}
