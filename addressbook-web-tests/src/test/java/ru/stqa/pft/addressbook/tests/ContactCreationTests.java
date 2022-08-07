package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        app.goTo().gotoHomePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstName("alex")
                .withLastName("yyy")
                .withAddress("moscow")
                .withWorkTelephone("88005553535")
                .withMobileTelephone("+79087776565")
                .withEmail("alex@alxndex.ru")
                .withBday("7")
                .withBmonth("November")
                .withByear("1980")
                .withGroup("test6");
        app.contact().create(contact);
        app.goTo().gotoHomePage();
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))
        ));

    }

}
