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

    public void updateContact() {
        click(By.name("update"));
    }

    public void submitContact() {
        click(By.name("submit"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
        acceptAlert();
    }

    public void editContact() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void returnHomePage() {
        click(By.linkText("home page"));
    }

}
