package Ex2_3_1;

public class Start
{
  public static void main(String[] args)
  {
    Thermometer thermometerOne = new Thermometer("t1", 15, 1);
    Thermometer thermometerTwo = new Thermometer("t2", 15, 7);

    Thread thermometerOneThread = new Thread(thermometerOne);
    Thread thermometerTwoThread = new Thread(thermometerTwo);

    thermometerOneThread.start();
    thermometerTwoThread.start();

  }
}
