import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class EventCounterTest {

    private EventCounter ecTest;

    @Before
    public void setup() {
        ecTest = new EventCounter();
    }


    @Test
    public void incrementCounterSize0Test() {
        LocalDateTime one = LocalDateTime.parse("2020-05-12T01:09:39.653");
        ecTest.incrementCounter(one);
        assertEquals(1, ecTest.getCounter());
    }

    @Test
    public void incrementCounter() {

        LocalDateTime one = LocalDateTime.parse("2020-05-12T01:09:39.653");
        LocalDateTime two = LocalDateTime.parse("2020-05-12T02:09:39.653");
        LocalDateTime three = LocalDateTime.parse("2020-05-12T03:09:39.653");

        ecTest.incrementCounter(one);
        ecTest.incrementCounter(two);
        ecTest.incrementCounter(three);
        assertEquals(3, ecTest.getCounter());

    }

    @Test
    public void incrementCounterEndTest() {
        LocalDateTime one = LocalDateTime.parse("2020-05-12T01:09:39.653");
        LocalDateTime two = LocalDateTime.parse("2020-05-12T02:09:39.653");
        LocalDateTime three = LocalDateTime.parse("2020-05-12T03:09:39.653");
        LocalDateTime four = LocalDateTime.parse("2020-05-12T04:09:39.653");
        LocalDateTime five = LocalDateTime.parse("2020-05-12T05:09:39.653");

        ecTest.incrementCounter(one);
        ecTest.incrementCounter(two);
        ecTest.incrementCounter(three);
        ecTest.incrementCounter(five);
        ecTest.incrementCounter(four);

        assertEquals(5, ecTest.getCounter());
    }

    @Test
    public void incrementCounterMiddleTest() {
        LocalDateTime one = LocalDateTime.parse("2020-05-12T01:09:39.653");
        LocalDateTime two = LocalDateTime.parse("2020-05-12T02:09:39.653");
        LocalDateTime three = LocalDateTime.parse("2020-05-12T03:09:39.653");
        LocalDateTime four = LocalDateTime.parse("2020-05-12T04:09:39.653");
        LocalDateTime five = LocalDateTime.parse("2020-05-12T05:09:39.653");

        ecTest.incrementCounter(one);
        ecTest.incrementCounter(two);
        ecTest.incrementCounter(four);
        ecTest.incrementCounter(five);
        ecTest.incrementCounter(three);


        assertEquals(5, ecTest.getCounter());
    }

    @Test
    public void returnCountOverTimeTest() {
        LocalDateTime one = LocalDateTime.parse("2020-05-12T01:09:39.653");
        LocalDateTime two = LocalDateTime.parse("2020-05-12T02:09:39.653");
        LocalDateTime three = LocalDateTime.parse("2020-05-12T03:09:39.653");
        LocalDateTime four = LocalDateTime.parse("2020-05-12T04:09:39.653");
        LocalDateTime five = LocalDateTime.parse("2020-05-12T05:09:39.653");

        ecTest.incrementCounter(one);
        ecTest.incrementCounter(two);
        ecTest.incrementCounter(four);
        ecTest.incrementCounter(five);
        ecTest.incrementCounter(three);

        assertEquals(1, ecTest.returnCountOverTime(LocalDateTime.parse("2020-05-12T01:30:39.653"),
                LocalDateTime.parse("2020-05-12T01:32:39.653")));

    }
    @Test
    public void returnCountOverTimeGreaterThan5MinsTest() {
        LocalDateTime one = LocalDateTime.parse("2020-05-12T01:09:39.653");
        LocalDateTime two = LocalDateTime.parse("2020-05-12T02:09:39.653");
        LocalDateTime three = LocalDateTime.parse("2020-05-12T03:09:39.653");
        LocalDateTime four = LocalDateTime.parse("2020-05-12T04:09:39.653");
        LocalDateTime five = LocalDateTime.parse("2020-05-12T05:09:39.653");

        ecTest.incrementCounter(one);
        ecTest.incrementCounter(two);
        ecTest.incrementCounter(four);
        ecTest.incrementCounter(five);
        ecTest.incrementCounter(three);

        assertEquals(-1, ecTest.returnCountOverTime(LocalDateTime.parse("2020-05-11T01:30:39.653"),
                LocalDateTime.parse("2020-05-12T03:30:39.653")));

    }



}