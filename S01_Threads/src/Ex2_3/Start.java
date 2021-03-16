package Ex2_3;

public class Start
{
  public static void main(String[] args)
  {
    Thermometer thermometer = new Thermometer("t1", 15);
    Thread thermometerThread = new Thread(thermometer);

    thermometerThread.start();
  }
}
