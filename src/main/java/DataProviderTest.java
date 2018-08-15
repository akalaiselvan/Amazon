/*To test Login using TestNG Data Provider logic
 * */


import jxl.read.biff.BiffException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class DataProviderTest {
    Selenium selenium=new Selenium();
    TestUtils utils=new TestUtils();

    public DataProviderTest() throws IOException, BiffException {
    }

    @DataProvider(name = "login")
    public Object[][] testcredential() throws Exception {
    return TestHelper.getfromExcel(utils.SHEET_LOCATIO,utils.sheetname);
    }

    @Test(dataProvider = "login")
    public void setup(String username , String password) throws InterruptedException, IOException {
        //selenium.login(username,password);

    }
    public void verifytext(){
    }

    public void closedriver(){
        selenium.closedriver();
    }



}
