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
            workbook = Workbook.getWorkbook(new File("/home/dell/Documents/INVEST/FetchSearchResults/TestSheet.xls"));
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
    private static String geckodriverPath = "/home/dell/Documents/INVEST/geckodriver";
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
}
