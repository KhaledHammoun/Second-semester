package Ex22_1_LoggingFeature;

import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class LogTest
{
    @Test
    public void createAnInstanceOfTheClass()
    {
        Log logs = Log.getInstance();
        assertEquals(0, logs.getAll().size());
    }
}