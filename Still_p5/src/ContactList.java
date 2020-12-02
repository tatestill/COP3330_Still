import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    ArrayList<ContactItem> List = new ArrayList<ContactItem>();

    public boolean addItem(String firstName, String secondName, String phoneNumber, String emailAddress )
    {
        ContactItem tempItem = new ContactItem();
        if(tempItem.createItem(firstName, secondName, phoneNumber, emailAddress))
        {
            List.add(tempItem);
            return true;
        }
        return false;
    }

    public int editItem(int index, String firstName, String secondName, String phoneNumber, String emailAddress )
    {
        if(this.List.size() == 0)
            return -2;
        try
        {
            ContactItem tempItem = new ContactItem();
            if (tempItem.createItem(firstName, secondName, phoneNumber, emailAddress)) {
                this.List.set(index, tempItem);
                return 1;
            }
        }
        catch(IndexOutOfBoundsException e)
        {
            return -1;
        }
        return 0;
    }

    public int removeItem(int index)
    {
        if(this.List.size() == 0)
            return -2;
        try
        {
            this.List.remove(index);
            return 1;
        }
        catch(IndexOutOfBoundsException e)
        {
            return 0;
        }
    }

    public int saveList( String name)
    {
        if(this.List.size() == 0)
            return -2;
        File saveFile = new File(name);
        try {
            if (saveFile.createNewFile()) {
                return writeToFile(name);
            } else
                return 0;
        }
        catch(IOException e) {
            return -1;
        }
    }

    private int writeToFile(String name)
    {
        int i;
        try {
            FileWriter out = new FileWriter(name);
            for(i = 0; i < this.List.size() ; i++)
            {
                out.write(this.List.get(i).getFirstName() + "\n");
                out.write(this.List.get(i).getLastName() + "\n");
                out.write(this.List.get(i).getPhoneNumber() + "\n");
                out.write(this.List.get(i).getEmailAddress() + "\n");
            }
            out.close();
            return 1;
        }
        catch(IOException e)
        {
            return -1;
        }
    }

    public int loadList(String name)
    {
        File inFile = new File(name);
        return readFile(inFile);
    }

    private int readFile(File inFile)
    {
        try
        {
            Scanner in = new Scanner(inFile);
            while( in.hasNextLine())
            {
                addItem(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine());
            }
            in.close();
            return 1;
        }
        catch(FileNotFoundException e)
        {
            return 0;
        }
        catch(IOException e)
        {
            return -1;
        }
    }
}
