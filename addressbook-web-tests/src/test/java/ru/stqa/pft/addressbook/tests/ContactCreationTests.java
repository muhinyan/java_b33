package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        app.getContactHelper().addNewContact();
        app.getContactHelper().fillContactForm(
                new ContactData(
                        "alex",
                        "pilipovich",
                        "moscow",
                        "88005553535",
                        "+79087776565",
                        "alex@alxndex.ru",
                        "7",
                        "November",
                        "1980"));
        app.getContactHelper().clickEnter();
        app.getNavigationHelper().gotoHomePage();
    }

}
