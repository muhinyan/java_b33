package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

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

    public void selectContactById(ContactData contact) {
        wd.findElement(By.id(String.valueOf(contact.getId()))).click();
    }

    public void clickDelete() {
        click(By.xpath("//input[@value='Delete']"));
        acceptAlert();
    }

    public void deleteContact(ContactData contact) {
        selectContactById(contact);
        clickDelete();
    }

    public void editContact(ContactData contact) {
        clickEdit(contact);
        fillContactForm(contact, false);
        updateContact();
        returnHomePage();
    }

    public void clickEdit(ContactData contact) {
        wd.findElement(By.xpath("//a[@href='edit.php?id="+ contact.getId() +"']")).click();
    }

    public void returnHomePage() {
        click(By.linkText("home page"));
    }

    public void create(ContactData contact) {
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

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element: elements) {
            String lastName = element.findElement(By.xpath("./td[2]")).getText();
            String firstName = element.findElement(By.xpath("./td[3]")).getText();
            String address = element.findElement(By.xpath("./td[4]")).getText();
            String allEmails = element.findElement(By.xpath("./td[5]")).getText();
            String allPhones = element.findElement(By.xpath("./td[6]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().withId(id).withFirstName(firstName).withLastName(lastName)
                    .withAddress(address).withAllPhones(allPhones).withAllEmails(allEmails);
            contacts.add(contact);
        }
        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        clickEdit(contact);
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname).withAddress(address)
                .withHomeTelephone(home).withMobileTelephone(mobile).withWorkTelephone(work)
                .withEmail(email).withEmail2(email2).withEmail3(email3);

    }
}
