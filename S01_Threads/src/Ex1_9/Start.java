package Ex1_9;

public class Start
{
  public static void main(String[] args)
  {
    Turtle turtle = new Turtle();
    Thread turtleThread = new Thread(turtle);
    Thread rabbit = new Thread(new Rabbit(turtle));

    turtleThread.start();
    rabbit.start();

  }
}
