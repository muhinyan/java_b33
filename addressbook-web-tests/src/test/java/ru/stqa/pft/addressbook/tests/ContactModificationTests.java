package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() throws Exception {
        app.getNavigationHelper().gotoHomePage();
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
        app.getContactHelper().editContact();
        app.getContactHelper().fillContactForm(
                new ContactData(
                        "bob",
                        "wilson",
                        "ny",
                        "88005553535",
                        "+79087776565",
                        "bob@bobndex.ru",
                        "1",
                        "November",
                        "1950",
                        null),
                false);
        app.getContactHelper().updateContact();
        app.getContactHelper().returnHomePage();
    }
}
