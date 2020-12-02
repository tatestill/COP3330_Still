import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class App {

    public static void main(String[] args)
    {
        contactOrTaskChoice();
    }

    static void contactOrTaskChoice()
    {
        boolean loop = true;

        while(loop)
        {
            printOptionsMainMenu();
            switch(getInput())
            {
                case 1 :
                    TaskApp.main();
                    break;
                case 2 :
                    ContactApp.main();
                    break;
                case 3 :
                    loop = false;
                    break;
                default :
                    System.out.println("Invalid input, please try again");
            }
        }
    }

    static void listOperationMenu(TaskList listTasks)
    {
    }


    static void printOptionsListOperationMenu()
    {
        System.out.print("\nList Operations Menu \n ---------------\n\n");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as completed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu");
    }
    static String getListName()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the filename to load: ");
        return in.nextLine();
    }
    static void printOptionsMainMenu()
    {
        System.out.print("\nSelect your Application \n ---------------\n\n");
        System.out.println("1) task list");
        System.out.println("2) contact list");
        System.out.println("3) quit");
    }

    static int getInput()
    {
        System.out.print("\nEnter your choice : ");
        return getIndex();
    }
    static void displayList(TaskList listTasks)
    {
        int i;
        System.out.println("\nCurrent Tasks");
        System.out.println("------------\n");
        for( i = 0 ; i < listTasks.List.size() ; i++)
        {
            System.out.print(i+") ");
            if(listTasks.List.get(i).isCompleted())
                System.out.print("*** ");
            System.out.println("[" + listTasks.List.get(i).getDueDate() + "] "+ listTasks.List.get(i).getTitle() + ": " + listTasks.List.get(i).getDesc());
        }
    }

    static void performAdd()
    {
    }


    static void performEdit()
    {
    }

    static void performRemove()
    {
    }

    static void performSave()
    {
    }

    static int getIndex()
    {
        boolean continueInput = true;
        int index = -1;
        Scanner in = new Scanner(System.in);
        while(continueInput)
        {
            try
            {
                index = in.nextInt();
                continueInput = false;
            }
            catch(InputMismatchException e)
            {
                System.out.print("Invalid input, please input a number : ");
                in.nextLine();
            }
        }
        return index;
    }

    static boolean performLoad(TaskList listTasks)
    {
        return false;
    }

}