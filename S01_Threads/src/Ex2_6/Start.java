package Ex2_6;

public class Start
{
  public static void main(String[] args)
  {
    Bar bar = new Bar(20000);

    Customer firstCustomer = new Customer(bar);
    Customer secondCustomer = new Customer(bar);
    Customer thirdCustomer = new Customer(bar);
    Customer fourthCustomer = new Customer(bar);
    Customer fifthCustomer = new Customer(bar);
    Customer sixthCustomer = new Customer(bar);
    Customer seventhCustomer = new Customer(bar);
    Customer eightCustomer = new Customer(bar);

    Bartender firstBartender = new Bartender(bar);
    Bartender secondBartender = new Bartender(bar);

    Thread firstThread = new Thread(firstCustomer);
    Thread secondThread = new Thread(secondCustomer);
    Thread thirdThread = new Thread(thirdCustomer);
    Thread fourthThread = new Thread(fourthCustomer);
    Thread fifthThread = new Thread(fifthCustomer);
    Thread sixthThread = new Thread(sixthCustomer);
    Thread seventhThread = new Thread(seventhCustomer);
    Thread eightThread = new Thread(eightCustomer);
    Thread ninthThread = new Thread(firstBartender);
    Thread tenthThread = new Thread(secondBartender);
    Thread eleventhThread = new Thread(bar);

    firstThread.setName("Fifth Customer");
    secondThread.setName("Second Customer");
    thirdThread.setName("Third Customer");
    fourthThread.setName("Fourth Customer");
    fifthThread.setName("Fifth Customer");
    sixthThread.setName("Sixth Customer");
    seventhThread.setName("Seventh Customer");
    eightThread.setName("Eight Customer");
    ninthThread.setName("First Bartender");
    tenthThread.setName("Second Bartender");
    eleventhThread.setName("The bar");

    firstThread.start();
    secondThread.start();
    thirdThread.start();
    fourthThread.start();
    fifthThread.start();
    sixthThread.start();
    seventhThread.start();
    eightThread.start();
    ninthThread.start();
    tenthThread.start();
    eleventhThread.start();
  }
}
