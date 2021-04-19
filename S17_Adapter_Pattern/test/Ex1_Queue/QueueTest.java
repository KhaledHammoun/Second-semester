package Ex1_Queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.InsufficientResourcesException;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest
{
    private StringQueue queueEmpty;
    private StringQueue queueWithElements;


    @BeforeEach
    public void setup()
    {
        queueEmpty = new Queue(4);
        queueWithElements = new Queue(4);
        queueWithElements.enqueue("1");
        queueWithElements.enqueue("2");
        queueWithElements.enqueue("3");
    }

    @Test
    public void constructorZeroElementsTestCorrect()
    {
        //QueueB 0 elements in the queue gives null pointer exception
        assertEquals(0, queueEmpty.size());
    }

    @Test public void constructorNegativeValue()
    {
        //Does accept negative values!
        assertThrows(IllegalArgumentException.class,
                     () -> queueEmpty = new Queue(-1));
    }

    @Test public void enqueueNullValue()
    {
        //QueueB does not throw exception on setting null value
        assertThrows(IllegalArgumentException.class, () -> queueEmpty.enqueue(null));
    }

    @Test public void enqueueMaxValues()
    {
        queueWithElements.enqueue("4");
        assertEquals(4, queueWithElements.size());
    }

    @Test public void enqueueMoreThanCapacity()
    {
        //QueueC wrong queue size initiated
        queueWithElements.enqueue("4");
        assertThrows(IllegalStateException.class, () -> queueWithElements.enqueue("5"));
    }

    @Test public void dequeueCorrect()
    {
        assertEquals("1", queueWithElements.dequeue());
    }

    @Test public void dequeueFromEmpty()
    {
        assertThrows(IllegalStateException.class, () -> queueEmpty.dequeue());
    }

    @Test public void firstPeekCorrectValue()
    {
        assertEquals("1", queueWithElements.first());
    }

    @Test public void firstPeekAndCheck()
    {
        //QueueB removes the value when first()
        queueWithElements.first();
        assertEquals(3, queueWithElements.size());
    }

    @Test public void firstFromEmpty()
    {
        //QueueA does not throw exeptiong when trying to peek in an empty queue
        queueWithElements.dequeue();
        queueWithElements.dequeue();
        queueWithElements.dequeue();

        assertThrows(IllegalStateException.class, () -> queueWithElements.first());
    }

    @Test public void isEmptyTrue()
    {
        //QueueA when dequeueing does not show that its empty
        queueWithElements.dequeue();
        queueWithElements.dequeue();
        queueWithElements.dequeue();

        assertEquals(true, queueWithElements.isEmpty());
    }

    @Test public void isEmptyFalse()
    {
        assertEquals(false, queueWithElements.isEmpty());
    }

    @Test public void isEmptyFalseAfterAddingElementToEmptyQueue()
    {
        assertEquals(true, queueEmpty.isEmpty());
        queueEmpty.enqueue("2");
        assertEquals(false, queueEmpty.isEmpty());
    }

    @Test public void indexOfFirstElement()
    {
        assertEquals(0, queueWithElements.indexOf("1"));
    }

    @Test public void indexOfLastElement()
    {
        assertEquals(2, queueWithElements.indexOf("3"));
    }

    @Test public void indexOfUniqueElement()
    {
        assertEquals(1, queueWithElements.indexOf("2"));

    }

    @Test public void indexOfRepeatedElements()
    {
        queueWithElements.enqueue("2");

        assertEquals(1, queueWithElements.indexOf("2"));
    }

    @Test public void indexOfIllegalArgument()
    {
        assertEquals(-1, queueWithElements.indexOf("5"));
    }

    @Test public void indexOfIllegalArgumentNull()
    {
        assertEquals(-1, queueWithElements.indexOf(null));
    }

    @Test public void containsAtZeroPosition()
    {
        assertEquals(true, queueWithElements.contains("1"));
    }

    @Test public void containsAtLastPosition()
    {
        assertEquals(true, queueWithElements.contains("2"));
    }

    @Test public void containsIllegalArgument()
    {
        assertEquals(false, queueWithElements.contains("5"));
    }

    @Test public void containsNull()
    {
        assertEquals(false, queueWithElements.contains(null));
    }

    @Test public void toStringAllElements()
    {
        assertEquals("[1, 2, 3]", queueWithElements.toString());
    }

    @Test
    public void toStringEmptyQueue()
    {
        assertEquals("[]", queueEmpty.toString());
    }
}