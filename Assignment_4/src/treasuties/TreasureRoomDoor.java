package treasuties;

import multiton.MinedValuable;

import java.util.ArrayList;

public interface TreasureRoomDoor
{
    void acquireRead(Object who);
    void acquireWrite(Object who);
    void releaseRead();
    void releaseWrite();
    void addValuable(ArrayList<MinedValuable> valuables);
    MinedValuable spendValuable();
    double countValuable();
}
