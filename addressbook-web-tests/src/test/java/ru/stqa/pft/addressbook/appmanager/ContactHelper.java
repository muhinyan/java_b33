package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) { super(wd); }

    public void addNewContact() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("work"), contactData.getWorkTelephone());
        type(By.name("mobile"), contactData.getMobileTelephone());
        type(By.name("email"), contactData.getEmail());
        fillDateOfBirth(contactData);
        selectGroup(contactData, creation);
    }

    public void selectGroup(ContactData contactData, Boolean creation) {
        if (creation) {
            try {
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
            }catch (NoSuchElementException noSuchElementException) {}
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
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

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
        acceptAlert();
    }

    public void editContact(int index) {
        wd.findElements(By.xpath("//img[@title='Edit']")).get(index).click();
    }

    public void returnHomePage() {
        click(By.linkText("home page"));
    }

    public void createNewContact(ContactData contact) {
        addNewContact();
        fillContactForm(
                contact,
                true);
        submitContact();
        returnHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element: elements) {
            String lastName = element.findElement(By.xpath("./td[2]")).getText();
            String firstName = element.findElement(By.xpath("./td[3]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData(id, firstName, lastName);
            contacts.add(contact);
        }
        return contacts;
    }
}
