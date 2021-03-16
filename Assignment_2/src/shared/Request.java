package shared;

import java.io.Serializable;

public class Request implements Serializable
{
  private requestType request;
  private Object argument;

  public Request(requestType request, Object argument)
  {
    this.request = request;
    this.argument = argument;
  }

  public requestType getRequest()
  {
    return request;
  }

  public Object getArgument()
  {
    return argument;
  }
}
