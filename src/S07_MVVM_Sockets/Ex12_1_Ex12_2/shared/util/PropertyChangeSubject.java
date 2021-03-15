package S07_MVVM_Sockets.Ex12_1_Ex12_2.shared.util;

import java.beans.PropertyChangeListener;

public interface PropertyChangeSubject {

    public void addPropertyChangeListener(String name, PropertyChangeListener listener);
    public void addPropertyChangeListener(PropertyChangeListener listener);
    public void removePropertyChangeListener(String name, PropertyChangeListener listener);
    public void removePropertyChangeListener(PropertyChangeListener listener);

}

