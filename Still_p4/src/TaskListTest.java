import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {


    @Test
    public void newTaskListIsEmpty()
    {
        TaskList testList = new TaskList();
        assertEquals(0, testList.List.size());
    }

    @Test
    public void addingValidTaskItemsIncreasesSize()
    {
        TaskList testList = new TaskList();
        testList.addTask("Title", "Desc", "2020-12-31");
        testList.addTask("Title1", "Desc1", "2021-01-01");
        assertEquals(2, testList.List.size());
    }

    @Test
    public void addingInvalidTitleTaskDoesNotIncreaseSize()
    {
        TaskList testList = new TaskList();
        testList.addTask("Title", "Desc", "2020-12-31");
        testList.addTask("", "Desc1", "2021-01-01");
        assertEquals(1, testList.List.size());
    }

    @Test
    public void addingInvalidDueDateTaskDoesNotIncreaseSize()
    {
        TaskList testList = new TaskList();
        testList.addTask("Title", "Desc", "2020-12-31");
        testList.addTask("Title1", "Desc1", "");
        assertEquals(1, testList.List.size());
    }

    @Test
    public void editingTaskTitleChangesValue()
    {
        TaskList testList = new TaskList();
        testList.addTask("Title", "Desc", "2020-12-31");
        testList.editTask(0,"newTitle", "Desc", "2020-12-31");
        assertEquals("newTitle", testList.List.get(0).getTitle());
    }

    @Test
    public void editingTaskDescChangesValue()
    {
        TaskList testList = new TaskList();
        testList.addTask("Title", "Desc", "2020-12-31");
        testList.editTask(0,"Title", "newDesc", "2020-12-31");
        assertEquals("newDesc", testList.List.get(0).getDesc());
    }

    @Test
    public void editingTaskDueDateChangesValue()
    {
        TaskList testList = new TaskList();
        testList.addTask("Title", "Desc", "2020-12-31");
        testList.editTask(0,"Title", "Desc", "2021-11-22");
        assertEquals("2021-11-22", testList.List.get(0).getDueDate());
    }

    @Test
    public void editingTaskInvalidIndexFails()
    {
        TaskList testList = new TaskList();
        testList.addTask("Title", "Desc", "2020-12-31");
        assertEquals(0, testList.editTask(2,"Title", "Desc", "2021-11-22"));
    }

    @Test
    public void removingTaskLowersSize()
    {
        TaskList testList = new TaskList();
        testList.addTask("Title", "Desc", "2020-12-31");
        testList.addTask("Title", "Desc", "2020-12-31");
        testList.removeTask(0);
        assertEquals(1, testList.List.size());

    }

    @Test
    public void removingTaskInvalidIndexFails()
    {
        TaskList testList = new TaskList();
        testList.addTask("Title", "Desc", "2020-12-31");
        testList.addTask("Title", "Desc", "2020-12-31");

        assertEquals(0, testList.removeTask(4));

    }

    @Test
    public void getTitleOfTaskAtValidIndex()
    {
        TaskList testList = new TaskList();
        testList.addTask("Not this one", "Not the one being aimed for", "2020-12-31");
        testList.addTask("This one", "The one being aimed for", "2020-12-31");
        testList.addTask("Not this one", "Not the one being aimed for", "2020-12-31");
        assertEquals("This one", testList.getTaskTitle(1));
    }

    @Test
    public void getTitleOfTaskAtInvalidIndex()
    {
        TaskList testList = new TaskList();
        testList.addTask("Title", "Desc", "2020-12-31");
        testList.addTask("Title", "Desc", "2020-12-31");
        assertEquals("", testList.getTaskTitle(3));
    }
}

