package shared;

import java.io.Serializable;

public class Request implements Serializable
{
  private RequestType request;
  private Object argument;

  public Request(RequestType request, Object argument)
  {
    this.request = request;
    this.argument = argument;
  }

  public RequestType getRequest()
  {
    return request;
  }

  public Object getArgument()
  {
    return argument;
  }
}
