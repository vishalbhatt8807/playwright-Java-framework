package Base;

import Common.browserUtils;
import Pages.login_PO;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class loginBase {
    private Browser browser;
    public login_PO login_po;
    @Parameters({ "browserType", "head" })
    @BeforeClass
    public void setUp(String browserType,String head) {
        browser= browserUtils.selectBrowser(browserType,head);
        Page page  = browser.newPage();
        page.navigate("https://www.trip.com/");
         login_po = new login_PO(page);
    }
}
