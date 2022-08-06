package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() throws Exception {
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
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContacts();
        app.goTo().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
