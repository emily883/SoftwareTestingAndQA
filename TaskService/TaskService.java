import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private Map<String, Task> tasks = new HashMap<>();

    public boolean addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID must be unique");
        }
        tasks.put(task.getTaskId(), task);
        return true;
    }

    public boolean deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found");
        }
        tasks.remove(taskId);
        return true;
    }

    public boolean updateTask(String taskId, String name, String description) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found");
        }
        task.setName(name);
        task.setDescription(description);
        return true;
    }

    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}
