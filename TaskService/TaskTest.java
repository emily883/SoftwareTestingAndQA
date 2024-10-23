import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("1", "Sample Task", "This is a description");
        assertEquals("1", task.getTaskId());
        assertEquals("Sample Task", task.getName());
        assertEquals("This is a description", task.getDescription());
    }

    @Test
    public void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Name", "Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Name", "Description"));
    }

    @Test
    public void testInvalidTaskName() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1", null, "Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "This name is way too long for a task", "Description"));
    }

    @Test
    public void testInvalidTaskDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "Name", null));
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "Name", "This description is way too long for the field and should throw an exception"));
    }
}
