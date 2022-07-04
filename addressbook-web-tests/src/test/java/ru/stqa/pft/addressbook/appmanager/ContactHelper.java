package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) { super(wd); }

    public void addNewContact() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("work"), contactData.getWorkTelephone());
        type(By.name("mobile"), contactData.getMobileTelephone());
        type(By.name("email"), contactData.getEmail());
        fillDateOfBirth(contactData);
    }

    private void fillDateOfBirth(ContactData contactData) {
        select(By.name("bday"), contactData.getBday());
        select(By.name("bmonth"), contactData.getBmonth());
        type(By.name("byear"), contactData.getByear());
    }

    public void clickEnter() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

}
