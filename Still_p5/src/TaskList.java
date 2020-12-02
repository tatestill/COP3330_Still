import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TaskList extends List{
    ArrayList<TaskItem> List = new ArrayList<TaskItem>();

    public int addItem(String newTitle, String newDesc, String newDate)//Add task method returns -1 or -2 if unsuccessful, 1 if successful
    {
        if(!TaskItem.isTitleValid(newTitle))
            return -1;
        if(!TaskItem.isDueDateValid(newDate))
            return -2;
        TaskItem newTask = new TaskItem(newTitle, newDesc, newDate);
        this.List.add(newTask);
        return 1;

    }

    public int editItem(int index, String newTitle, String newDesc, String newDate)
    {
        if(this.List.size() == 0)
            return -2;
        try
        {
            if(!TaskItem.isTitleValid(newTitle))
            {
                return -1;
            }
            if(!TaskItem.isDueDateValid(newDate))
            {
                return -2;
            }
            TaskItem newTask = new TaskItem(newTitle, newDesc, newDate);
            this.List.set(index, newTask);
        }
        catch(IndexOutOfBoundsException e)
        {
            return 0;
        }
        return 1;
    }

    public int removeItem(int index) //remove task returns 1 if removed successfully 0 if not
    {
        try
        {
            this.List.remove(index);
        }
        catch(IndexOutOfBoundsException e)
        {
            return 0;
        }
        return 1;
    }

    public String getTaskTitle(int index) //Returns a blank string should the index be wrong.
    {
        try
        {
            return this.List.get(index).getTitle();
        }
        catch(IndexOutOfBoundsException e)
        {
            return "";
        }
    }

    public String getTaskDesc(int index) //Cannot return a blank string as desc can be blank, so a determined fail string that is unlikely to be a description will be used, "~~~"
    {
        try
        {
            return this.List.get(index).getDesc();
        }
        catch(IndexOutOfBoundsException e)
        {
            return "~~~";
        }
    }

    public String getTaskDueDate(int index) //Cannot return a blank string if invalid index
    {
        try
        {
            return this.List.get(index).getDueDate();
        }
        catch(IndexOutOfBoundsException e)
        {
            return "";
        }
    }

    public int setCompletedAtIndex(int index, boolean complete) //Returns 1 if successful, 0 if fails
    {
        if(this.List.size() == 0)
            return -2;
        try
        {
            this.List.get(index).markCompletion(complete);
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
                out.write(this.List.get(i).getTitle() + "\n");
                out.write(this.List.get(i).getDesc() + "\n");
                out.write(this.List.get(i).getDueDate() + "\n");
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
                addItem(in.nextLine(), in.nextLine(), in.nextLine());
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
