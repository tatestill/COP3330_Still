import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues()
    {
        ContactItem testItem = new ContactItem();
        assertEquals(false, testItem.createItem("", "", "", ""));
    }

    @Test
    public void creationSucceedsWithBlankFirstName()
    {
        ContactItem testItem = new ContactItem();
        assertEquals(true, testItem.createItem("", "still", "123-456-7890", "me@email.com"));
        assertEquals("", testItem.getFirstName());
        assertEquals("still", testItem.getLastName());
        assertEquals("123-456-7890", testItem.getPhoneNumber());
        assertEquals("me@email.com", testItem.getEmailAddress());
    }

    @Test
    public void creationSucceedsWithBlankLastName()
    {
        ContactItem testItem = new ContactItem();
        assertEquals(true, testItem.createItem("t8", "", "123-456-7890", "me@email.com"));
        assertEquals("t8", testItem.getFirstName());
        assertEquals("", testItem.getLastName());
        assertEquals("123-456-7890", testItem.getPhoneNumber());
        assertEquals("me@email.com", testItem.getEmailAddress());
    }

    @Test
    public void creationSucceedsWithBlankPhoneNumber()
    {
        ContactItem testItem = new ContactItem();
        assertEquals(true, testItem.createItem("t8", "still", "", "me@email.com"));
        assertEquals("t8", testItem.getFirstName());
        assertEquals("still", testItem.getLastName());
        assertEquals("", testItem.getPhoneNumber());
        assertEquals("me@email.com", testItem.getEmailAddress());
    }

    @Test
    public void creationSucceedsWithBlankEmail()
    {
        ContactItem testItem = new ContactItem();
        assertEquals(true, testItem.createItem("t8", "still", "123-456-7890", ""));
        assertEquals("t8", testItem.getFirstName());
        assertEquals("still", testItem.getLastName());
        assertEquals("123-456-7890", testItem.getPhoneNumber());
        assertEquals("", testItem.getEmailAddress());
    }

    @Test
    public void creationSucceedsWithNonBlankValues()
    {
        ContactItem testItem = new ContactItem();
        assertEquals(true, testItem.createItem("t8", "still", "123-456-7890", "me@email.com"));
        assertEquals("t8", testItem.getFirstName());
        assertEquals("still", testItem.getLastName());
        assertEquals("123-456-7890", testItem.getPhoneNumber());
        assertEquals("me@email.com", testItem.getEmailAddress());
    }

}
