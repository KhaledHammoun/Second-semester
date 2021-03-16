package Ex11_3.transferableobjects;

import java.io.Serializable;

public class Request implements Serializable
{
  private String argument;
  private RequestType requestType;

  public Request(String argument, RequestType requestType)
  {
    this.argument = argument;
    this.requestType = requestType;
  }

  public void setArgument(String argument)
  {
    this.argument = argument;
  }

  public void setRequestType(RequestType requestType)
  {
    this.requestType = requestType;
  }

  public String getRequestType()
  {
    return requestType.toString();
  }

  public String update()
  {
    return requestType.compareTo(RequestType.UpperCase) == 0 ? argument.toUpperCase() : argument.toLowerCase();
  }

  @Override public String toString()
  {
    return "Request{" + "argument='" + argument + '\'' + ", requestType="
        + requestType + '}';
  }
}
