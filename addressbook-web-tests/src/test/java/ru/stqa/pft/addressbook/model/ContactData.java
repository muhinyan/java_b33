package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String workTelephone;
    private final String mobileTelephone;
    private final String email;
    private final String bday;
    private final String bmonth;
    private final String byear;

    public ContactData(String firstName, String lastName, String address, String workTelephone, String mobileTelephone, String email, String bday, String bmonth, String byear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.workTelephone = workTelephone;
        this.mobileTelephone = mobileTelephone;
        this.email = email;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getWorkTelephone() {
        return workTelephone;
    }

    public String getMobileTelephone() {
        return mobileTelephone;
    }

    public String getEmail() {
        return email;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getByear() {
        return byear;
    }
}
