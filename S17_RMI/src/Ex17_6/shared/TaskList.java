package Ex17_6.shared;

import java.util.ArrayList;
import java.util.List;

public class TaskList
{
    private List<Task> tasks;

    public TaskList()
    {
        tasks = new ArrayList<>();
    }

    public void add(Task task)
    {
        tasks.add(task);
    }

    public Task getAdnRemoveNextTask()
    {
        if (tasks.size() > 0)
        {
            Task toReturn = tasks.get(0);
            tasks.remove(toReturn);
            return toReturn;
        }
        return null;
    }

    public int size()
    {
        return tasks.size();
    }

    @Override
    public String toString()
    {
        return "TaskList:\n" + tasks;
    }
}
