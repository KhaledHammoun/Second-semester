package Ex12_3.server.model;

public interface RadiatorState
{
  void turnUp(Radiator radiator);
  void turnDown(Radiator radiator);
  int getPower();
}
