package Ex1_Robot;

import org.w3c.dom.ls.LSOutput;

public class ClientMain
{
    public static void main(String[] args)
    {
        Robot robot = new Robot("Taka", new OffensiveBehaviour());
        Robot robot2 = new Robot("Onaka", new DefenciveBehaviour());

        int result = robot.move() - robot2.move();
        System.out.println(result);
    }

}
