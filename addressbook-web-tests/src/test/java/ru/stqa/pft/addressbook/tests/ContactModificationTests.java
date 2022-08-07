package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().gotoHomePage();
        if (app.contact().all().size() == 0)
            app.contact().create(
                    new ContactData()
                            .withFirstName("alex")
                            .withLastName("yyy")
                            .withAddress("moscow")
                            .withWorkTelephone("88005553535")
                            .withMobileTelephone("+79087776565")
                            .withEmail("alex@alxndex.ru")
                            .withBday("7")
                            .withBmonth("November")
                            .withByear("1980")
                            .withGroup("test1"));
    }

    @Test
    public void testContactModification() throws Exception {
        app.goTo().gotoHomePage();
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withFirstName("bob")
                .withLastName("wilson");
        app.contact().editContact(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size()));
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}

