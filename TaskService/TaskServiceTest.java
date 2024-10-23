import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Test
    public void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Sample Task", "This is a description");
        service.addTask(task);
        assertEquals("Sample Task", service.getTask("1").getName());
    }

    @Test
    public void testDuplicateTaskID() {
        TaskService service = new TaskService();
        Task task1 = new Task("1", "Task One", "Description One");
        Task task2 = new Task("1", "Task Two", "Description Two");
        service.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> service.addTask(task2));
    }

    @Test
    public void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Sample Task", "This is a description");
        service.addTask(task);
        assertTrue(service.deleteTask("1"));
        assertNull(service.getTask("1"));
    }

    @Test
    public void testUpdateTask() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Sample Task", "This is a description");
        service.addTask(task);
        assertTrue(service.updateTask("1", "Updated Task", "Updated Description"));
        assertEquals("Updated Task", service.getTask("1").getName());
        assertEquals("Updated Description", service.getTask("1").getDescription());
    }

    @Test
    public void testNonExistentTaskUpdate() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateTask("99999", "Updated Task", "Updated Description");
        });
    }
}
