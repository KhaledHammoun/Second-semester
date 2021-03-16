package Ex3_5;

public class Start
{
  public static void main(String[] args)
  {
    Bird bird = new Bird();

    BirdWatcher first = new BirdWatcher(bird);
    BirdWatcher second = new BirdWatcher(bird);
    BirdWatcher third = new BirdWatcher(bird);
    BlindBirdWatcher blindBirdWatcher = new BlindBirdWatcher(bird);

    bird.start();
  }
}
