package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String username, String password) {
        wd.get("http://localhost/addressbook/index.php");
        type(By.name("user"), username);
        type(By.name("pass"), password);
        click(By.id("LoginForm"));
        click(By.xpath("//input[@value='Login']"));
    }
}
