package S03_MVVM.Ex4_6.model;

public interface DataModel {
    double[] getDataValues();

    String getLastUpdateTimeStamp();
    public void saveData(double[] data);
}
