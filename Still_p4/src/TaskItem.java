import java.util.Scanner;

public class TaskItem {

    private String title;
    private String desc;
    private String dueDate;
    private boolean completed;


    TaskItem(String newTitle, String newDesc, String newDate)
    {
        this.title = newTitle;
        this.desc = newDesc;
        this.dueDate = newDate;
    }

    public String getTitle()
    {
        return this.title;
    }
    public String getDesc()
    {
        return this.desc;
    }
    public String getDueDate()
    {
        return this.dueDate;
    }

    public int editTitle(String newTitle) //Edit methods return 1 if successful 0 if not
    {
        if(isTitleValid(newTitle))
            this.title = newTitle;
        else
        {
            return 0;
        }
        return 1;
    }

    public int editDueDate(String newDate)
    {
        if(isDueDateValid(newDate))
            this.dueDate = newDate;
        else
            return 0;
        return 1;
    }

    public void editDesc(String newDesc)
    {
            this.desc = newDesc;
    }

    public static boolean isTitleValid(String newTitle)
    {
        return !newTitle.isBlank();
    }

    public static boolean isDueDateValid(String newDate)
   {
        int i;
        if(!(newDate.length() == 10 ))
            return false;
        for(i=0 ; i < 4 ; i++)
        {
            if(!Character.isDigit(newDate.charAt(i)))
            {
                return false;
            }
        }

        if(newDate.charAt(i) != '-')
            return false;
        i++;
        if(newDate.charAt(i) != '0' && newDate.charAt(i) != '1')
            return false;
        i++;
        if(!Character.isDigit(newDate.charAt(i)))
            return false;
        i++;
        if(newDate.charAt(i) != '-')
            return false;
        i++;
        if(newDate.charAt(i) != '0' && newDate.charAt(i) != '1' && newDate.charAt(i) != '2' && newDate.charAt(i) != '3')
           return false;
        i++;
        if(!Character.isDigit(newDate.charAt(i)))
           return false;
        return true;
   }

   public void markCompletion(boolean complete)
   {
       this.completed = complete;
   }

   public boolean isCompleted()
   {
       return this.completed;
   }
}
