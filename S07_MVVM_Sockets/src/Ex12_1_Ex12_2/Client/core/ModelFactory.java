package Ex12_1_Ex12_2.Client.core;


import Ex12_1_Ex12_2.Client.model.DataModel;
import Ex12_1_Ex12_2.Client.model.DataModelManager;

import java.io.IOException;

public class ModelFactory {

    private DataModel dataModel;
    private ClientFactory clientFactory;

    public ModelFactory(ClientFactory clientFactory)
    {
        this.clientFactory = clientFactory;
    }

    public DataModel getDataModel() throws IOException
    {
        if(dataModel == null) {
            dataModel = new DataModelManager(clientFactory.getClient());
        }
        return dataModel;
    }


}
