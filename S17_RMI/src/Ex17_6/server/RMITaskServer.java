package Ex17_6.server;

import Ex17_6.shared.RemoteTaskList;
import Ex17_6.shared.Task;
import Ex17_6.shared.TaskList;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMITaskServer implements RemoteTaskList
{
    private TaskList tasks;

    public RMITaskServer() throws RemoteException
    {
        this.tasks = new TaskList();
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public synchronized void add(Task task) throws RemoteException
    {
        tasks.add(task);
    }

    @Override
    public synchronized Task remove() throws RemoteException
    {
        return tasks.getAdnRemoveNextTask();
    }

    @Override
    public synchronized int size() throws RemoteException
    {
        return tasks.size();
    }
}
