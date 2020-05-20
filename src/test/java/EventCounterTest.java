import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class EventCounterTest {

    private EventCounter ecTest;

    @Before
    public void setup() {
        ecTest = new EventCounter();
    }


    @Test
    public void incrementCounterTest() {
        ecTest.incrementCounter();
        ecTest.incrementCounter();
        ecTest.incrementCounter();
        assertEquals(3, ecTest.getCountOverTime(3));
    }

    @Test
    public void incrementCounterPruneTest() {
        LocalTime temp = LocalTime.parse(LocalTime.now().minusSeconds(400)
                .format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        ecTest.incrementCounter(temp);
        ecTest.incrementCounter();
        ecTest.incrementCounter();
        assertEquals(2, ecTest.getCountOverTime(2));

    }

    @Test
    public void incrementCounterWithEvenTimestamps() {
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


}