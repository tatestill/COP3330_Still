import java.util.Scanner;

public class TaskApp extends App{

    public static void main()
    {
        boolean loop = true;
        TaskList listTasks = new TaskList();
        while(loop)
        {
            printOptionsMainMenu();
            switch(getInput())
            {
                case 1 :
                    listTasks = new TaskList();
                    listOperationMenu(listTasks);
                    break;
                case 2 :
                    if(performLoad(listTasks))
                        listOperationMenu(listTasks);
                    break;
                case 3 :
                    loop = false;
                    break;
                default :
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

    static void listOperationMenu(TaskList listTasks)
    {
        boolean loop = true;

        while(loop)
        {
            printOptionsListOperationMenu();
            switch(getInput())
            {
                case 1 :
                    displayList(listTasks);
                    break;
                case 2 :
                    performAdd(listTasks);
                    break;
                case 3 :
                    performEdit(listTasks);
                    break;
                case 4 :
                    performRemove(listTasks);
                    break;
                case 5 :
                    performMarkCompleted(listTasks);
                    break;
                case 6 :
                    performMarkUncompleted(listTasks);
                    break;
                case 7 :
                    performSave(listTasks);
                    break;
                case 8 :
                    loop = false;
                    break;
                default :
                    System.out.print("Invalid input, please try again");
            }
        }
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

    static void performAdd(TaskList listTasks)
    {
        Scanner in = new Scanner(System.in);
        String title, desc, date;
        System.out.print("Task title: ");
        title = in.nextLine();
        System.out.print("Task description: ");
        desc = in.nextLine();
        System.out.print("Task due date (YYYY-MM-DD): ");
        date = in.nextLine();
        switch(listTasks.addItem(title, desc, date))
        {
            case 1 :
                return;
            case -1 :
                System.out.println("ERROR: Title must be one or more characters in length, task not created");
                return;
            case -2 :
                System.out.println("ERROR: Invalid due date, task not created");
        }

    }

    static void performEdit(TaskList listTasks)
    {
        if(listTasks.List.size() == 0)
        {
            System.out.println("Task list is empty, cannot perform function");
            return;
        }
        Scanner in = new Scanner(System.in);
        String title, desc, date;
        int index;
        displayList(listTasks);
        System.out.print("Which task will you edit? ");
        index = getIndex();
        System.out.print("Enter a new title for task " + index + ": ");
        title = in.nextLine();
        System.out.print("Enter a new description for task " + index + ": ");
        desc = in.nextLine();
        System.out.print("Enter a new task due date (YYYY-MM-DD): ");
        date = in.nextLine();
        switch(listTasks.editItem(index, title, desc, date))
        {
            case 1 :
                return;
            case 0 :
                System.out.println("ERROR: No task at index " + index);
                return;
            case -1 :
                System.out.println("ERROR: Title must be one or more characters in length, task not edited");
                return;
            case -2 :
                System.out.println("ERROR: Invalid due date, task not edited");
        }
    }

    static void performRemove(TaskList listTasks)
    {
        if(listTasks.List.size() == 0)
        {
            System.out.println("ERROR: Task List is empty ");
            return;
        }
        int index;
        displayList(listTasks);
        System.out.print("Which task will you remove? ");
        index = getIndex();
        switch (listTasks.removeItem(index))
        {
            case 1:
                return;
            case 0:
                System.out.println("ERROR: No task at index " + index);
            case -2 :
                System.out.println("ERROR: Task List is empty ");
        }
    }

    static void performMarkCompleted(TaskList listTasks)
    {
        if(listTasks.List.size() == 0)
        {
            System.out.println("Task list is empty, cannot perform function");
            return;
        }
        displayCompleted(listTasks, false);
        int index;
        System.out.print("Which class do you want marked completed? ");
        index = getIndex();
        switch (listTasks.setCompletedAtIndex(index, true))
        {
            case 1:
                return;
            case 0:
                System.out.println("ERROR: No uncompleted task at index " + index);
            case -2 :
                System.out.println("ERROR: Task List is empty " + index);
        }
    }
    static void performMarkUncompleted(TaskList listTasks)
    {
        displayCompleted(listTasks, true);
        int index;
        System.out.print("Which class do you want marked uncompleted? ");
        index = getIndex();
        switch (listTasks.setCompletedAtIndex(index, false))
        {
            case 1:
                return;
            case 0:
                System.out.println("ERROR: No completed task at index " + index);
            case -2 :
                System.out.println("ERROR: Task List is empty ");
        }
    }

    static void displayCompleted(TaskList listTasks, boolean completed)
    {
        int i;
        if(completed)
            System.out.println("\nCompleted Tasks");
        else
            System.out.println("\nUncompleted Tasks");
        System.out.println("------------");
        for( i = 0 ; i < listTasks.List.size() ; i++)
        {
            if(listTasks.List.get(i).isCompleted() == completed)
            {
                System.out.print(i+") ");
                if(completed)
                    System.out.print("*** ");
                System.out.println("[" + listTasks.List.get(i).getDueDate() + "] " + listTasks.List.get(i).getTitle() + ": " + listTasks.List.get(i).getDesc());
            }
        }
    }
    static void performSave(TaskList listTasks)
    {
        Scanner in = new Scanner(System.in);
        String name;
        System.out.print("Enter filename: ");
        name = in.next();
        switch (listTasks.saveList(name))
        {
            case 1:
                return;
            case 0:
                System.out.println("ERROR: IO Exception ");
            case -2 :
                System.out.println("ERROR: Task List is empty ");
        }
    }

    static boolean performLoad(TaskList listTasks)
    {
        switch(listTasks.loadList(getListName()))
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

