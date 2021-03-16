package Ex12_3.shared;

import java.io.Serializable;

public class Request implements Serializable
{
  private RequestType requestType;
  private Object arg;

  public Request(RequestType requestType,
      Object arg)
  {
    this.requestType = requestType;
    this.arg = arg;
  }

  public RequestType getRequestType()
  {
    return requestType;
  }

  public Object getArg()
  {
    return arg;
  }
}
