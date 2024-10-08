/*
 * Copyright (c) 2022 Kennedy Uzoho
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
        // Variables for valid test data
    protected String contactId, firstNameTest, lastNameTest, phoneNumberTest,
            addressTest;
        // Variables for invalid test data
    protected String tooLongContactId, tooLongFirstName, tooLongLastName,
            tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;


        // Set up the test data: Initializes test data before each test method is run
    @BeforeEach
    void setUp() {
        contactId = "1029F847A6";
        firstNameTest = "John";
        lastNameTest = "Smith";
        phoneNumberTest = "5553331234";
        addressTest = "1 Audrey Jersey City NJ 07305";

        // Set up invalid test data: Variables for invalid test data
        tooLongContactId = "112233445566778899";
        tooLongFirstName = "John Jacob Jingle";
        tooLongLastName = "-heimer Schmidt";
        tooLongPhoneNumber = "55512341234";
        tooShortPhoneNumber = "1234567";
        tooLongAddress = "1 Audrey Zapp Drive, Jersey City, NJ 07305";
    }
        // Test the constructors: Test the constructors to ensure that they create a new Contact object with the correct values
    @Test
    void contactTest() {
        Contact contact = new Contact();
        assertAll("constructor",
                ()
                        -> assertNotNull(contact.getContactId()),
                ()
                        -> assertNotNull(contact.getFirstName()),
                ()
                        -> assertNotNull(contact.getLastName()),
                ()
                        -> assertNotNull(contact.getPhoneNumber()),
                () -> assertNotNull(contact.getAddress()));


    }
        // Tests the constructor with a contact ID
    @Test
    void contactIdConstructorTest() {
        Contact contact = new Contact(contactId);
        assertAll("constructor one",
                ()
                        -> assertEquals(contactId, contact.getContactId()),
                ()
                        -> assertNotNull(contact.getFirstName()),
                ()
                        -> assertNotNull(contact.getLastName()),
                ()
                        -> assertNotNull(contact.getPhoneNumber()),
                () -> assertNotNull(contact.getAddress()));
    }

        // Tests the constructor with contact ID and first name
    @Test
    void contactIdAndFirstNameConstructorTest() {
        Contact contact = new Contact(contactId, firstNameTest);
        assertAll("constructor two",
                ()
                        -> assertEquals(contactId, contact.getContactId()),
                ()
                        -> assertEquals(firstNameTest, contact.getFirstName()),
                ()
                        -> assertNotNull(contact.getLastName()),
                ()
                        -> assertNotNull(contact.getPhoneNumber()),
                () -> assertNotNull(contact.getAddress()));
    }

    // Tests the constructor with contact ID, first name, and last name
    @Test
    void contactIdAndFullNameConstructorTest() {
        Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
        assertAll("constructor three",
                ()
                        -> assertEquals(contactId, contact.getContactId()),
                ()
                        -> assertEquals(firstNameTest, contact.getFirstName()),
                ()
                        -> assertEquals(lastNameTest, contact.getLastName()),
                ()
                        -> assertNotNull(contact.getPhoneNumber()),
                () -> assertNotNull(contact.getAddress()));
    }

    // Tests the constructor with contact ID, first name, last name, and phone number
    @Test
    void contactIdFullNamePhoneNumberConstructorTest() {
        Contact contact =
                new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
        assertAll("constructor four",
                ()
                        -> assertEquals(contactId, contact.getContactId()),
                ()
                        -> assertEquals(firstNameTest, contact.getFirstName()),
                ()
                        -> assertEquals(lastNameTest, contact.getLastName()),
                ()
                        -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
                () -> assertNotNull(contact.getAddress()));
    }

    // Tests the constructor with all the proper things
    // Tests the constructor with all parameters: contact ID, first name, last name, phone number, and address
    @Test
    void allTheProperThingsConstructorTest() {
        Contact contact = new Contact(contactId, firstNameTest, lastNameTest,
                phoneNumberTest, addressTest);
        assertAll("constructor all",
                ()
                        -> assertEquals(contactId, contact.getContactId()),
                ()
                        -> assertEquals(firstNameTest, contact.getFirstName()),
                ()
                        -> assertEquals(lastNameTest, contact.getLastName()),
                ()
                        -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
                () -> assertEquals(addressTest, contact.getAddress()));
    }

    // Test the updateFirstName method 
    @Test
    void updateFirstNameTest() {
        Contact contact = new Contact();
        contact.updateFirstName(firstNameTest);
        assertAll(
                "first name",
                ()
                        -> assertEquals(firstNameTest, contact.getFirstName()),
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        () -> contact.updateFirstName(null)),
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        () -> contact.updateFirstName(tooLongFirstName)));
    }

    // Test the updateLastName method
    @Test
    void updateLastNameTest() {
        Contact contact = new Contact();
        contact.updateLastName(lastNameTest);
        assertAll(
                "last name",
                ()
                        -> assertEquals(lastNameTest, contact.getLastName()),
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        () -> contact.updateLastName(null)),
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        () -> contact.updateLastName(tooLongFirstName)));
    }

        // Test the updatePhoneNumber method
    @Test
    void updatePhoneNumberTest() {
        Contact contact = new Contact();
        contact.updatePhoneNumber(phoneNumberTest);
        assertAll("phone number",
                ()
                        -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        () -> contact.updatePhoneNumber(null)),
                ()
                        -> assertThrows(
                        IllegalArgumentException.class,
                        () -> contact.updatePhoneNumber(tooLongPhoneNumber)),
                ()
                        -> assertThrows(
                        IllegalArgumentException.class,
                        () -> contact.updatePhoneNumber(tooShortPhoneNumber)),
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        () -> contact.updatePhoneNumber(contactId)));
    }

    // Test the updateAddress method
    @Test
    void updateAddressTest() {
        Contact contact = new Contact();
        contact.updateAddress(addressTest);
        assertAll("phone number",
                ()
                        -> assertEquals(addressTest, contact.getAddress()),
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        () -> contact.updateAddress(null)),
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        () -> contact.updateAddress(tooLongAddress)));
    }

    // Test the updateContactId method
    @Test
    void updateContactIdTest() {
        Contact contact = new Contact();
        contact.updateContactId(contactId);
        assertAll(
                "contact ID",
                ()
                        -> assertEquals(contactId, contact.getContactId()),
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        () -> contact.updateContactId(null)),
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        () -> contact.updateContactId(tooLongContactId)));
    }
}