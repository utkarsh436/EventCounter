import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert.*;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

public class EventCounterTest {

    private EventCounter ecTest;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setup() {
        ecTest = new EventCounter();
    }


    @Test
    public void incrementCounterTest() throws Exception {
        ecTest.incrementCounter();
        ecTest.incrementCounter();
        ecTest.incrementCounter();
        assertEquals(3, ecTest.getCountOverTime(3));
    }

    @Test
    public void incrementCounterPruneTest() throws Exception {
        LocalTime temp = LocalTime.parse(LocalTime.now().minusSeconds(400)
                .format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        ecTest.incrementCounter(temp);
        ecTest.incrementCounter();
        ecTest.incrementCounter();
        assertEquals(2, ecTest.getCountOverTime(2));

    }

    @Test
    public void incrementCounteruserInputtedTimestamps() throws Exception {
        LocalTime one = LocalTime.parse(LocalTime.now().minusSeconds(3)
                .format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        LocalTime two = LocalTime.parse(LocalTime.now().minusSeconds(2)
                .format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        LocalTime three = LocalTime.parse(LocalTime.now().minusSeconds(1)
                .format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        LocalTime four = LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        ecTest.incrementCounter(one);
        ecTest.incrementCounter(two);
        ecTest.incrementCounter(three);
        ecTest.incrementCounter(four);
        assertEquals(2, ecTest.getCountOverTime(1));
    }

    @Test
    public void getCountOverTimeExceptionTest(){
       assertThrows(Exception.class, () -> ecTest.getCountOverTime(400));
    }
}