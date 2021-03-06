import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TaskItemTest {

    @Test
    public void taskItemsFailsWithInvalidTitle()
    {
        assertEquals(false, TaskItem.isTitleValid(""));
    }

    @Test
    public void taskItemsSucceedsWithValidTitle()
    {
        assertEquals(true, TaskItem.isTitleValid("Hi"));
    }

    @Test
    public void taskItemsFailsWithInvalidDueDate()
    {
        assertEquals(false, TaskItem.isDueDateValid(""));
    }

    @Test
    public void taskItemsFailsWithInvalidDueDateMonth()
    {
        assertEquals(false, TaskItem.isDueDateValid("2020-13-09"));
    }

    @Test
    public void taskItemsFailsWithInvalidDueDateDay()
    {
        assertEquals(false, TaskItem.isDueDateValid("2020-09-41"));
    }

    @Test
    public void taskItemsSucceedsWithValidDueDate()
    {
        assertEquals(true, TaskItem.isDueDateValid("2020-12-23"));
    }

    @Test
    public void taskMarksAsCompleted()
    {
        TaskItem testItem = new TaskItem("Title", "Desc", "2020-12-31");
        testItem.markCompletion(true);
        assertEquals(true, testItem.isCompleted());
    }

    @Test
    public void taskUnmarksAsCompleted()
    {
        TaskItem testItem = new TaskItem("Title", "Desc", "2020-12-31");
        testItem.markCompletion(true);
        testItem.markCompletion(false);
        assertEquals(false, testItem.isCompleted());
    }



}
