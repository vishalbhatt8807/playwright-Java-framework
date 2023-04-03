package Common;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class browserUtils {
    private static Browser browser;

    public static Browser selectBrowser(String browserType,String head){
        if (browserType.equalsIgnoreCase("Chromium")) {
            if(head.equalsIgnoreCase("false")) {
                browser = Playwright
                        .create()
                        .chromium()
                        .launch(new BrowserType.LaunchOptions().setHeadless(false));
            }else{
                browser = Playwright
                        .create()
                        .chromium()
                        .launch();
            }
        } else if (browserType.equalsIgnoreCase("Firefox")) {
            if(head.equalsIgnoreCase("false")) {
                browser = Playwright
                        .create()
                        .firefox()
                        .launch(new BrowserType.LaunchOptions().setHeadless(false));
            }else{
                browser = Playwright
                        .create()
                        .chromium()
                        .launch();
            }
        } else if (browserType.equalsIgnoreCase("MsEdge")) {
            if(head.equalsIgnoreCase("false")) {
                browser = Playwright
                        .create()
                        .chromium()
                        .launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
            }else{
                browser = Playwright
                        .create()
                        .chromium()
                        .launch(new BrowserType.LaunchOptions().setChannel("msedge"));
            }
        } else if (browserType.equalsIgnoreCase("Chrome")) {
            if(head.equalsIgnoreCase("false")) {
                browser = Playwright
                        .create()
                        .chromium()
                        .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
            }else{
                browser = Playwright
                        .create()
                        .chromium()
                        .launch(new BrowserType.LaunchOptions().setChannel("chrome"));
            }
        } else if (browserType.equalsIgnoreCase("WebKit")) {
            if(head.equalsIgnoreCase("false")) {
                browser = Playwright
                        .create()
                        .webkit()
                        .launch(new BrowserType.LaunchOptions().setHeadless(false));
            }else{
                browser = Playwright
                        .create()
                        .webkit()
                        .launch(new BrowserType.LaunchOptions());
            }
        }
        return browser;
    }

}
