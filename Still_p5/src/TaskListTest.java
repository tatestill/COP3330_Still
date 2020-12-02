import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        testList.addItem("Title", "Desc", "2020-12-31");
        testList.addItem("Title1", "Desc1", "2021-01-01");
        assertEquals(2, testList.List.size());
    }

    @Test
    public void addingInvalidTitleTaskDoesNotIncreaseSize()
    {
        TaskList testList = new TaskList();
        testList.addItem("Title", "Desc", "2020-12-31");
        testList.addItem("", "Desc1", "2021-01-01");
        assertEquals(1, testList.List.size());
    }

    @Test
    public void addingInvalidDueDateTaskDoesNotIncreaseSize()
    {
        TaskList testList = new TaskList();
        testList.addItem("Title", "Desc", "2020-12-31");
        testList.addItem("Title1", "Desc1", "");
        assertEquals(1, testList.List.size());
    }

    @Test
    public void editingTaskTitleChangesValue()
    {
        TaskList testList = new TaskList();
        testList.addItem("Title", "Desc", "2020-12-31");
        testList.editItem(0,"newTitle", "Desc", "2020-12-31");
        assertEquals("newTitle", testList.List.get(0).getTitle());
    }

    @Test
    public void editingTaskDescChangesValue()
    {
        TaskList testList = new TaskList();
        testList.addItem("Title", "Desc", "2020-12-31");
        testList.editItem(0,"Title", "newDesc", "2020-12-31");
        assertEquals("newDesc", testList.List.get(0).getDesc());
    }

    @Test
    public void editingTaskDueDateChangesValue()
    {
        TaskList testList = new TaskList();
        testList.addItem("Title", "Desc", "2020-12-31");
        testList.editItem(0,"Title", "Desc", "2021-11-22");
        assertEquals("2021-11-22", testList.List.get(0).getDueDate());
    }

    @Test
    public void editingTaskInvalidIndexFails()
    {
        TaskList testList = new TaskList();
        testList.addItem("Title", "Desc", "2020-12-31");
        assertEquals(0, testList.editItem(2,"Title", "Desc", "2021-11-22"));
    }

    @Test
    public void removingTaskLowersSize()
    {
        TaskList testList = new TaskList();
        testList.addItem("Title", "Desc", "2020-12-31");
        testList.addItem("Title", "Desc", "2020-12-31");
        testList.removeItem(0);
        assertEquals(1, testList.List.size());

    }

    @Test
    public void removingTaskInvalidIndexFails()
    {
        TaskList testList = new TaskList();
        testList.addItem("Title", "Desc", "2020-12-31");
        testList.addItem("Title", "Desc", "2020-12-31");

        assertEquals(0, testList.removeItem(4));

    }

    @Test
    public void getTitleOfTaskAtValidIndex()
    {
        TaskList testList = new TaskList();
        testList.addItem("Not this one", "Not the one being aimed for", "2020-12-31");
        testList.addItem("This one", "The one being aimed for", "2020-12-31");
        testList.addItem("Not this one", "Not the one being aimed for", "2020-12-31");
        assertEquals("This one", testList.getTaskTitle(1));
    }

    @Test
    public void failIfGettingTitleOfTaskAtInvalidIndex()
    {
        TaskList testList = new TaskList();
        testList.addItem("Title", "Desc", "2020-12-31");
        testList.addItem("Title", "Desc", "2020-12-31");
        assertEquals("", testList.getTaskTitle(3));
    }

    @Test
    public void getDescOfTaskAtValidIndex()
    {
        TaskList testList = new TaskList();
        testList.addItem("Not this one", "Not the one being aimed for", "2020-12-31");
        testList.addItem("This one", "The one being aimed for", "2020-12-31");
        testList.addItem("Not this one", "Not the one being aimed for", "2020-12-31");
        assertEquals("The one being aimed for", testList.getTaskDesc(1));
    }

    @Test
    public void failIfGettingDescOfTaskAtInvalidIndex()
    {
        TaskList testList = new TaskList();
        testList.addItem("Title", "Desc", "2020-12-31");
        testList.addItem("Title", "Desc", "2020-12-31");
        assertEquals("~~~", testList.getTaskDesc(3));
    }

    @Test
    public void getDueDateOfTaskAtValidIndex()
    {
        TaskList testList = new TaskList();
        testList.addItem("Not this one", "Not the one being aimed for", "2020-12-31");
        testList.addItem("This one", "The one being aimed for", "2021-09-22");
        testList.addItem("Not this one", "Not the one being aimed for", "2020-12-31");
        assertEquals("2021-09-22", testList.getTaskDueDate(1));
    }

    @Test
    public void failIfGettingDueDateOfTaskAtInvalidIndex()
    {
        TaskList testList = new TaskList();
        testList.addItem("Title", "Desc", "2020-12-31");
        testList.addItem("Title", "Desc", "2020-12-31");
        assertEquals("", testList.getTaskDueDate(3));
    }

    @Test
    public void SetCompletedTaskAtValidIndex()
    {
        TaskList testList = new TaskList();
        testList.addItem("Title", "Desc", "2020-12-31");
        testList.setCompletedAtIndex(0, true);
        assertTrue(testList.List.get(0).isCompleted());
    }

    @Test
    public void FailsToSetCompletedTaskAtInvalidIndex()
    {
        TaskList testList = new TaskList();
        testList.addItem("Title", "Desc", "2020-12-31");
        assertEquals(0, testList.setCompletedAtIndex(3, true));
    }

    @Test
    public void ListLoadsFromSave()
    {
        TaskList testList = new TaskList();
        testList.addItem("Title", "Desc", "2020-12-31");
        testList.saveList("List.txt");
        TaskList newTestList = new TaskList();
        newTestList.loadList("List.txt");
        assertEquals(testList.List.get(0).getTitle(), newTestList.List.get(0).getTitle());
        assertEquals(testList.List.get(0).getDesc(), newTestList.List.get(0).getDesc());
        assertEquals(testList.List.get(0).getDueDate(), newTestList.List.get(0).getDueDate());
    }

}

