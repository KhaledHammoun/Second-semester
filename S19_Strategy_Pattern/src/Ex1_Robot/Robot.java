package Ex1_Robot;

public class Robot
{
    private String name;
    private Behaviour behaviour;

    public Robot(String name, Behaviour behaviour)
    {
        this.name = name;
        this.behaviour = behaviour;
    }

    public Behaviour getBehaviour()
    {
        return behaviour;
    }

    public void setBehaviour(Behaviour behaviour)
    {
        this.behaviour = behaviour;
    }

    public int move()
    {
        return behaviour.moveCommand(new GameBoard(), new Point2D(2,3));
    }
}
