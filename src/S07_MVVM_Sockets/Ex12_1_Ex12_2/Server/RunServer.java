package S07_MVVM_Sockets.Ex12_1_Ex12_2.Server;

import S07_MVVM_Sockets.Ex12_1_Ex12_2.Server.model.DataModelManager;
import S07_MVVM_Sockets.Ex12_1_Ex12_2.Server.network.SocketServer;

public class RunServer
{

  public static void main(String[] args)
  {
    SocketServer server = new SocketServer(new DataModelManager());
    server.start();
  }
}
