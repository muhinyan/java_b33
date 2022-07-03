package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoHomePage() {
        click(By.linkText("home page"));
        wd.get("http://localhost/addressbook/index.php");
    }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
        wd.get("http://localhost/addressbook/group.php");
    }
}
