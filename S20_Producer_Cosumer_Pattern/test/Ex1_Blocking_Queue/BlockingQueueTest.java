package Ex1_Blocking_Queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockingQueueTest
{
    Buffer<String> buffer;

    @BeforeEach
    public void setup()
    {
        buffer = new BlockingQueue<>(3);
    }
    // ZERO
    @Test
    public void testCanCreateBuffer()
    {

    }

    @Test
    public void testIsEmpty()
    {
        assertTrue(buffer.isEmpty());
    }

    @Test
    public void testIsNotFull()
    {
        assertFalse(buffer.isFull());
    }

    // ONE
    @Test
    public void testCanPutOneElement()
    {
        buffer.put("1");
    }

    @Test
    public void testPutOneElementIsNotEmpty()
    {
        buffer.put("1");
        assertFalse(buffer.isEmpty());
    }

    @Test
    public void testPutOneElementIsNotFullCapacityThree()
    {
        buffer.put("1");
        assertFalse(buffer.isFull());
    }

    @Test
    public void testPutOneEqualsSizeOne()
    {
        buffer.put("1");
        assertEquals(1, buffer.size());
    }

    @Test
    public void testCanPutOneTakeOneElement()
    {
        buffer.put("1");
        assertEquals("1", buffer.take());
    }

    @Test
    public void testPutOneTakeOneElementIsEmpty()
    {
        buffer.put("1");
        buffer.take();
        assertTrue(buffer.isEmpty());
    }

    @Test
    public void testPutOneTakeOneElementIsNotFull()
    {
        buffer.put("1");
        buffer.take();
        assertFalse(buffer.isFull());
    }

    // MANY
    @Test
    public void testCanPutTwoElements()
    {
        buffer.put("1");
        buffer.put("2");
    }

    @Test
    public void testPutTwoElementsSizeTwo()
    {
        buffer.put("1");
        buffer.put("2");
        assertEquals(2, buffer.size());
    }


}