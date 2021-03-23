import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClockTest
{
  private Clock clock;

  @Test public void testSecondsConstructorZero()
  {
    clock = new Clock(0);
    assertEquals("00:00:00", clock.toString());
  }

  @Test public void testSecondsConstructorNegative()
  {
    assertThrows(IllegalArgumentException.class, () -> clock = new Clock(-1));
  }

  @Test public void testMiddleValuesFromSeconds()
  {
    clock = new Clock(40000);
    assertEquals("11:06:40", clock.toString());
  }

  @Test public void testSecondsConstructorOneDayValue()
  {
    //86400 sec = 24h = 00:00:00, but result is 00:00:01
    clock = new Clock(86400);
    assertEquals("00:00:00", clock.toString());
  }

  @Test public void testSecondsConstructorTwoDaysValue()
  {
    //172800 sec = 48h = 00:00:00, but result is 00:00:02
    clock = new Clock(172800);
    assertEquals("00:00:00", clock.toString());
  }

  @Test public void testHMSConstructorZeroValue()
  {
    clock = new Clock(0,0,0);
    assertEquals("00:00:00", clock.toString());
  }

  @Test public void testHMSConstructorOneValue()
  {
    clock = new Clock(1,1,1);
    assertEquals("01:01:01", clock.toString());
  }

  @Test public void testHSMConstructorMidRange()
  {
    clock = new Clock(2, 3,4);
    assertEquals("02:03:04", clock.toString());
  }

  @Test public void testHMSConstructorTopRangeSuccess()
  {
    clock = new Clock(23,59,59);
    assertEquals("23:59:59", clock.toString());
  }

  @Test public void testHMSConstructorTopRangeHoursFail()
  {
    //Does not throw exception on illegal hours input
    assertThrows(IllegalArgumentException.class,() -> new Clock(24,0,0));
  }

  @Test public void testHMSConstructorTopRangeMinutesFail()
  {
    assertThrows(IllegalArgumentException.class, () -> new Clock(23, 60, 0));
  }

  @Test public void testHMSConstructorTopRangeSecondsFail()
  {
    assertThrows(IllegalArgumentException.class, () -> new Clock(23,59,60));
  }

  @Test public void testHSMConstructorLowerRangeHoursFail()
  {
    assertThrows(IllegalArgumentException.class, () -> new Clock(-1, 59,59));
  }

  @Test public void testHSMConstructorLowerRangeMinutesFail()
  {
    assertThrows(IllegalArgumentException.class, () -> new Clock(23, -1,59));
  }

  @Test public void testHSMConstructorLowerRangeSecondsFail()
  {
    assertThrows(IllegalArgumentException.class, () -> new Clock(23, 59,-1));
  }

  @Test public void testGetterHours()
  {
    clock = new Clock(2, 3,4);
    assertEquals(2, clock.getHour());
  }

  @Test public void testMinutesGetter()
  {
    clock = new Clock(2,3,4);
    assertEquals(3, clock.getMinute());
  }

  @Test public void testSecondsGetter()
  {
    //seconds getter for the minutes nad not seconds
    clock = new Clock(2,4,8);
    assertEquals(8, clock.getSecond());
  }

  @Test public void testSetterZeroValue()
  {
    clock = new Clock(1,1,1);
    clock.set(0,0,0);
    assertEquals("00:00:00", clock.toString());
  }

  @Test public void testSetterOneValue()
  {
    clock = new Clock(0,0,0);
    clock.set(1,1,1);
    assertEquals("01:01:01", clock.toString());
  }

  @Test public void testSetterMidRange()
  {
    clock = new Clock(0, 0,0);
    clock.set(2,3,4);
    assertEquals("02:03:04", clock.toString());
  }

  @Test public void testSetterTopRangeSuccess()
  {
    clock = new Clock(0,0,0);
    clock.set(23,59,59);
    assertEquals("23:59:59", clock.toString());
  }

  @Test public void testSetterTopRangeHoursFail()
  {
    //Does not throw exception on illegal hours input
    clock = new Clock(0,0,0);
    assertThrows(IllegalArgumentException.class,() -> clock.set(24,0,0));
  }

  @Test public void testSetterTopRangeMinutesFail()
  {
    clock = new Clock(0,0,0);
    assertThrows(IllegalArgumentException.class, () -> clock.set(23, 60, 0));
  }

  @Test public void testSetterTopRangeSecondsFail()
  {
    clock = new Clock(0);
    assertThrows(IllegalArgumentException.class, () -> clock.set(23,59,60));
  }

  @Test public void testSetterLowerRangeHoursFail()
  {
    clock = new Clock(0);
    assertThrows(IllegalArgumentException.class, () -> clock.set(-1, 59,59));
  }

  @Test public void testSetterLowerRangeMinutesFail()
  {
    clock = new Clock(0);
    assertThrows(IllegalArgumentException.class, () -> clock.set(23, -1,59));
  }

  @Test public void testSetterLowerRangeSecondsFail()
  {
    clock = new Clock(0);
    assertThrows(IllegalArgumentException.class, () -> clock.set(23, 59,-1));
  }

  @Test public void testSecondsSetterNegative()
  {
    clock = new Clock(0);
    assertThrows(IllegalArgumentException.class, () -> clock.set(-1));
  }

  @Test public void testMiddleValuesSetterFromSeconds()
  {
    clock = new Clock(0);
    clock.set(40000);
    assertEquals("11:06:40", clock.toString());
  }

  @Test public void testSecondsSetterOneDayValue()
  {
    //86400 sec = 24h = 00:00:00, but result is 00:00:01
    clock = new Clock(0);
    clock.set(86400);
    assertEquals("00:00:00", clock.toString());
  }

  @Test public void testSecondsSetterTwoDaysValue()
  {
    //172800 sec = 48h = 00:00:00, but result is 00:00:02
    clock = new Clock(0);
    clock.set(172800);
    assertEquals("00:00:00", clock.toString());
  }
}