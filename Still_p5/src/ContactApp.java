import java.util.Scanner;

public class ContactApp extends App{

    public static void main() {
        boolean loop = true;
        ContactList listContacts = new ContactList();
        while (loop) {
            printOptionsMainMenu();
            switch (getInput()) {
                case 1:
                    listContacts = new ContactList();
                    listOperationMenu(listContacts);
                    break;
                case 2:
                    if(performLoad(listContacts))
                        listOperationMenu(listContacts);
                    break;
                case 3:
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid input, please try again");
            }
        }
    }

    static void printOptionsMainMenu()
    {
        System.out.print("\nMain Menu \n ---------------\n\n");
        System.out.println("1) create a new list");
        System.out.println("2) load an existing");
        System.out.println("3) quit");
    }

    static void listOperationMenu(ContactList listContacts)
    {
        boolean loop = true;

        while(loop)
        {
            printOptionsListOperationMenu();
            switch(getInput())
            {
                case 1 :
                    displayList(listContacts);
                    break;
                case 2 :
                    performAdd(listContacts);
                    break;
                case 3 :
                    performEdit(listContacts);
                    break;
                case 4 :
                    performRemove(listContacts);
                    break;
                case 5 :
                   performSave(listContacts);
                    break;
                case 6 :
                    loop = false;
                    break;
                default :
                    System.out.print("Invalid input, please try again");
            }
        }
    }

    static void displayList(ContactList listContacts)
    {
        int i;
        System.out.println("\nCurrent Contacts");
        System.out.println("------------\n");
        for( i = 0 ; i < listContacts.List.size() ; i++)
        {
            System.out.print(i+") ");
            System.out.println("Name: "+ listContacts.List.get(i).getFirstName() + " " + listContacts.List.get(i).getLastName());
            System.out.println("Phone: " + listContacts.List.get(i).getPhoneNumber());
            System.out.println("Email: " + listContacts.List.get(i).getEmailAddress());
        }
    }

    static void printOptionsListOperationMenu()
    {
        System.out.print("\nList Operations Menu \n ---------------\n\n");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) save the current list");
        System.out.println("6) quit to the main menu");
    }

    static void performAdd(ContactList listContacts)
    {
        Scanner in = new Scanner(System.in);
        String first, last, phone, email;
        System.out.print("First Name: ");
        first = in.nextLine();
        System.out.print("Last Name: ");
        last = in.nextLine();
        System.out.print("Phone Number(xxx-xxx-xxxx): ");
        phone = in.nextLine();
        System.out.print("Email Address (x@y.z): ");
        email = in.nextLine();
        if(listContacts.addItem(first, last, phone, email))
            return;

        System.out.println("ERROR: There must be a value for at least one of the fields");



    }

    static void performEdit(ContactList listContact)
    {
        if(listContact.List.size() == 0)
        {
            System.out.println("ERROR : Contact list is empty, cannot perform function");
            return;
        }
        Scanner in = new Scanner(System.in);
        String first, last, phone, email;
        int index;
        displayList(listContact);
        System.out.print("Which contact will you edit? ");
        index = getIndex();
        System.out.print("Enter a new first name for contact " + index + ": ");
        first = in.nextLine();
        System.out.print("Enter a new last name for contact " + index + ": ");
        last = in.nextLine();
        System.out.print("Enter a new phone number (XXX-XXX-XXXX): ");
        phone = in.nextLine();
        System.out.print("Enter a new email (x@y.z): ");
        email = in.nextLine();
        switch(listContact.editItem(index, first, last, phone, email))
        {
            case 1 :
                return;
            case 0 :
                System.out.println("ERROR: There must be a value for at least one of the fields");
                return;
            case -1 :
                System.out.println("ERROR: No contact at index " + index);
            case -3 :
                System.out.println("ERROR: Contact list is empty");
        }
    }

    static void performRemove(ContactList listContacts)
    {
        if(listContacts.List.size() == 0)
        {
            System.out.println("ERROR: Contact List is empty ");
            return;
        }
        int index;
        displayList(listContacts);
        System.out.print("Which contact will you remove? ");
        index = getIndex();
        switch (listContacts.removeItem(index))
        {
            case 1:
                return;
            case 0:
                System.out.println("ERROR: No contact at index " + index);
            case -2 :
                System.out.println("ERROR: Contact List is empty ");
        }
    }

    static void performSave(ContactList listContacts)
    {
        Scanner in = new Scanner(System.in);
        String name;
        System.out.print("Enter filename: ");
        name = in.next();
        switch (listContacts.saveList(name))
        {
            case 1:
                return;
            case 0 :
                System.out.println("ERROR: File already exists");
            case -1:
                System.out.println("ERROR: IO Exception ");
            case -2 :
                System.out.println("ERROR: Contact List is empty ");
        }
    }

    static boolean performLoad(ContactList listContacts)
    {
        switch(listContacts.loadList(getListName()))
        {
            case 1 :
                return true;
            case 0 :
                System.out.println("ERROR: File does not exist");
                return false;
        }
        return false;
    }

}
