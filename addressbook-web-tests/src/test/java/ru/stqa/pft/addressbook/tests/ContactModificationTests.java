package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() throws Exception {
        app.goTo().gotoHomePage();
        if (!app.getContactHelper().isThereAContact())
            app.getContactHelper().createNewContact(
                    new ContactData(
                            "alex",
                            "pilipovich",
                            "moscow",
                            "88005553535",
                            "+79087776565",
                            "alex@alxndex.ru",
                            "7",
                            "November",
                            "1980",
                            "test1"));
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().editContact(before.size() - 1);
        ContactData contact = new ContactData(
                "bob",
                "wilson",
                "ny",
                "88005553535",
                "+79087776565",
                "bob@bobndex.ru",
                "1",
                "November",
                "1950",
                null);
        app.getContactHelper().fillContactForm(contact,
                false);
        app.getContactHelper().updateContact();
        app.getContactHelper().returnHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}

