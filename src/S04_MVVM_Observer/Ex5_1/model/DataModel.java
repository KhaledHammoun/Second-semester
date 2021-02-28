package S04_MVVM_Observer.Ex5_1.model;

public interface DataModel {

    String getLastUpdateTimeStamp();
    void increaseNumberOfUpdates();
    int getNumberOfUpdates();

    public void increaseRecalculateDataCount();
    public int getRecalculateDataCount();
}
