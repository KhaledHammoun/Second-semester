package treasuries;

import actors.Accountant;
import actors.King;
import actors.ValuableTransporter;
import multiton.MinedValuable;
import singleton.Logger;

import java.util.ArrayList;

public class Guardsman implements TreasureRoomDoor
{
    private TreasureRoomDoor treasureRoom;
    private boolean accessGranted;
    private static Guardsman instance;

    private Guardsman()
    {
        this.treasureRoom = new TreasureRoom();
    }

    public static Guardsman getInstance()
    {
        if (instance == null)
        {
            instance = new Guardsman();
        }
        return instance;
    }

    @Override
    public synchronized void acquireRead(Object who)
    {
        if (who instanceof Accountant)
        {
            Logger.getInstance().log("Guardsman grants read access to the treasury");
            treasureRoom.acquireRead(who);
            accessGranted = true;
        }
        // TODO: 04/05/2021 throw exception
    }

    @Override
    public void acquireWrite(Object who)
    {
        if (who instanceof King || who instanceof ValuableTransporter)
        {
            Logger.getInstance().log("Guardsman grants write access to the treasury");
            treasureRoom.acquireWrite(who);
            accessGranted = true;
        }
        // TODO: 04/05/2021 throw exception
    }

    @Override
    public void releaseRead()
    {
        Logger.getInstance().log("Read access is released.");
        treasureRoom.releaseRead();
        accessGranted = false;
    }

    @Override
    public void releaseWrite()
    {
        Logger.getInstance().log("Write access is released.");
        treasureRoom.releaseWrite();
        accessGranted = false;
    }

    @Override
    public void addValuables(ArrayList<MinedValuable> valuable)
    {
        if (accessGranted)
            treasureRoom.addValuables(valuable);
    }

    @Override
    public MinedValuable spendValuable()
    {
        if(accessGranted)
        {
            return treasureRoom.spendValuable();
        }
        return null;
    }

    @Override
    public double countValuable()
    {
        if (accessGranted)
        {
            return treasureRoom.countValuable();
        }
        return 0;
    }
}
