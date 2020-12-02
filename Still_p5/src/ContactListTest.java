import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactListTest {


    @Test
    public void newContactListIsEmpty()
    {
        ContactList testList = new ContactList();
        assertEquals(0, testList.List.size());
    }

    @Test
    public void addingItemsIncreasesSize()
    {
        ContactList testList = new ContactList();
        testList.addItem("t8", "still", "123-456-7890", "me@email.com");
        testList.addItem("", "still", "123-456-7890", "me@email.com");
        assertEquals(2, testList.List.size());
        assertEquals("t8", testList.List.get(0).getFirstName());

    }

    @Test
    public void addingItemsFailsWithAllBlank()
    {
        ContactList testList = new ContactList();
        testList.addItem("", "still", "123-456-7890", "me@email.com");
        testList.addItem("", "", "", "");
        assertEquals(1, testList.List.size());

    }

    @Test
    public void editingItemsFailsWithAllBlank()
    {
        ContactList testList = new ContactList();
        testList.addItem("t8", "still", "123-456-7890", "me@email.com");
        testList.editItem(0,"", "", "", "");
        assertEquals("t8", testList.List.get(0).getFirstName());
        assertEquals("still", testList.List.get(0).getLastName());
        assertEquals("123-456-7890", testList.List.get(0).getPhoneNumber());
        assertEquals("me@email.com", testList.List.get(0).getEmailAddress());
    }

    @Test
    public void editingItemsFailsWithInvalidIndex()
    {
        ContactList testList = new ContactList();
        testList.addItem("t8", "still", "123-456-7890", "me@email.com");
        assertEquals(-1, testList.editItem(4,"d", "d", "d", "d"));
        assertEquals("t8", testList.List.get(0).getFirstName());
        assertEquals("still", testList.List.get(0).getLastName());
        assertEquals("123-456-7890", testList.List.get(0).getPhoneNumber());
        assertEquals("me@email.com", testList.List.get(0).getEmailAddress());
    }

    @Test
    public void editingItemsSucceedsWithBlankFirstName()
    {
        ContactList testList = new ContactList();
        testList.addItem("t8", "still", "123-456-7890", "me@email.com");
        testList.editItem(0,"", "nah", "098-765-4321", "notme@email.com");
        assertEquals("", testList.List.get(0).getFirstName());
        assertEquals("nah", testList.List.get(0).getLastName());
        assertEquals("098-765-4321", testList.List.get(0).getPhoneNumber());
        assertEquals("notme@email.com", testList.List.get(0).getEmailAddress());
    }

    @Test
    public void editingItemsSucceedsWithBlankLastName()
    {
        ContactList testList = new ContactList();
        testList.addItem("t8", "still", "123-456-7890", "me@email.com");
        testList.editItem(0,"nott8", "", "098-765-4321", "notme@email.com");
        assertEquals("nott8", testList.List.get(0).getFirstName());
        assertEquals("", testList.List.get(0).getLastName());
        assertEquals("098-765-4321", testList.List.get(0).getPhoneNumber());
        assertEquals("notme@email.com", testList.List.get(0).getEmailAddress());
    }

    @Test
    public void editingItemsSucceedsWithBlankPhoneNumber()
    {
        ContactList testList = new ContactList();
        testList.addItem("t8", "still", "123-456-7890", "me@email.com");
        testList.editItem(0,"nott8", "nah", "", "notme@email.com");
        assertEquals("nott8", testList.List.get(0).getFirstName());
        assertEquals("nah", testList.List.get(0).getLastName());
        assertEquals("", testList.List.get(0).getPhoneNumber());
        assertEquals("notme@email.com", testList.List.get(0).getEmailAddress());
    }

    @Test
    public void editingItemsSucceedsWithBlankEmail()
    {
        ContactList testList = new ContactList();
        testList.addItem("t8", "still", "123-456-7890", "me@email.com");
        testList.editItem(0,"nott8", "nah", "098-765-4321", "");
        assertEquals("nott8", testList.List.get(0).getFirstName());
        assertEquals("nah", testList.List.get(0).getLastName());
        assertEquals("098-765-4321", testList.List.get(0).getPhoneNumber());
        assertEquals("", testList.List.get(0).getEmailAddress());
    }

    @Test
    public void removingItemsDecreasesSize()
    {
        ContactList testList = new ContactList();
        testList.addItem("t8", "still", "123-456-7890", "me@email.com");
        testList.addItem("", "still", "123-456-7890", "me@email.com");
        testList.removeItem(1);
        assertEquals(1, testList.List.size());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex()
    {
        ContactList testList = new ContactList();
        testList.addItem("t8", "still", "123-456-7890", "me@email.com");
        testList.addItem("", "still", "123-456-7890", "me@email.com");
        testList.removeItem(3);
        assertEquals(2, testList.List.size());
        assertEquals("", testList.List.get(1).getFirstName());
        assertEquals("still", testList.List.get(1).getLastName());
        assertEquals("123-456-7890", testList.List.get(1).getPhoneNumber());
        assertEquals("me@email.com", testList.List.get(1).getEmailAddress());
    }

    @Test
    public void canLoadSavedList() {
        ContactList testList = new ContactList();
        testList.addItem("t8", "still", "123-456-7890", "me@email.com");
        testList.addItem("nott8", "nah", "098-765-4321", "notme@email.com");
        testList.saveList("test.txt");
        ContactList testList2 = new ContactList();
        testList2.loadList("test.txt");
        assertEquals(2, testList.List.size());
        assertEquals("t8", testList.List.get(0).getFirstName());
        assertEquals("still", testList.List.get(0).getLastName());
        assertEquals("123-456-7890", testList.List.get(0).getPhoneNumber());
        assertEquals("me@email.com", testList.List.get(0).getEmailAddress());
    }
}
