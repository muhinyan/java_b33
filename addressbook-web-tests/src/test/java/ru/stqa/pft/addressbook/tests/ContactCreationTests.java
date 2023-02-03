package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test()
    public void testContactCreation() throws Exception {
        app.goTo().gotoHomePage();
        Contacts before = app.contact().all();
        File photo = new File("//Users//muhinyan//Desktop//java_b33//addressbook-web-tests//src//main//java//resources//photo.jpg");
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
                .withGroup("test6")
                .withPhoto(photo);
        app.contact().create(contact);
        app.goTo().gotoHomePage();
        Contacts after = app.contact().all();
//        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))
        ));

    }


}
