package Ex12_3.shared;

import java.io.Serializable;

public class Request implements Serializable
{
  private requestType requestType;
  private Object arg;

  public Request(S07_MVVM_Sockets.Ex12_3.shared.requestType requestType,
      Object arg)
  {
    this.requestType = requestType;
    this.arg = arg;
  }

  public requestType getRequestType()
  {
    return requestType;
  }

  public Object getArg()
  {
    return arg;
  }
}
