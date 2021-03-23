import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClockTest
{
  private Clock clock;

  @BeforeEach
  public void setup()
  {
    clock = new Clock(23,59,59);
  }

  @Test
  public void testingTicUpperBound()
  {
    //hours increment beyond 23h.
    clock.tic();
    assertEquals("00:00:00", clock.toString());
  }

  @Test
  public void ticSecondsUpperBound()
  {
    clock.set(23,50,59);
    clock.tic();
    assertEquals("23:51:00", clock.toString());
  }

  @Test
  public void ticMinutesUpperBound()
  {
    clock.set(22,59,59);
    clock.tic();
    assertEquals("23:00:00", clock.toString());
  }

  @Test
  public void ticOneDayValues()
  {
    clock.set(0);

    for (int i = 0; i < 90401; i++)
    {
      assertEquals(new Clock(i).toString(), clock.toString());
      clock.tic();
    }
  }
}