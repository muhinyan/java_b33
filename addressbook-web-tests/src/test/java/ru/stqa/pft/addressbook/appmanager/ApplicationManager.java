package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;


public class ApplicationManager {

    public WebDriver wd;

    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private SessionHelper sessionHelper;
    private ContactHelper contactHelper;
    private  String browser;
    private DbHelper dbHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {

        dbHelper = new DbHelper();
        if (browser.equals(BrowserType.CHROME)) {
            System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver");
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)){
            System.setProperty("webdriver.gecko.driver", "src/main/java/resources/geckodriver");
            wd = new FirefoxDriver();
        }
//        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wd.get("http://localhost/addressbook/index.php");
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        sessionHelper.logout();
        wd.quit();
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public ContactHelper contact() { return contactHelper; }
    public DbHelper db () {
        return dbHelper;
    }
}
