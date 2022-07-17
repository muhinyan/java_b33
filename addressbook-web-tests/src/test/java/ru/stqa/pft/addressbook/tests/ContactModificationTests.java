package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() throws Exception {
        app.getNavigationHelper().gotoHomePage();
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
