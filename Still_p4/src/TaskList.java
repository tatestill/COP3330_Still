import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    ArrayList<TaskItem> List = new ArrayList<TaskItem>();

    public int addTask(String newTitle, String newDesc, String newDate)//Add task method returns -1 or -2 if unsuccessful, 1 if successful
    {
        if(!TaskItem.isTitleValid(newTitle))
            return -1;
        if(!TaskItem.isDueDateValid(newDate))
            return -2;
        TaskItem newTask = new TaskItem(newTitle, newDesc, newDate);
        this.List.add(newTask);
        return 1;

    }

    public int editTask(int index, String newTitle, String newDesc, String newDate)
    {
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

    public int removeTask(int index) //remove task returns 1 if removed successfully 0 if not
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

    public String getTaskTitle(int index)
    {
        try
        {
            return this.List.get(index).getTitle();
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.print("ERROR : No task at index " + index);
            return "";
        }
    }
}
