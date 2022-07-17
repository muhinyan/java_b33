package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() throws Exception {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact())
            app.getContactHelper().CreateNewContact(
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
                    "test1"),
                    true);
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getNavigationHelper().gotoHomePage();
    }
}
