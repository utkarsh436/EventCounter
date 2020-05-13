import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.sql.Timestamp;
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
        String one = "2020-05-12 01:09:39.653";
        Timestamp t = Timestamp.valueOf(one);
        ecTest.incrementCounter(t);
        assertEquals(1, ecTest.getCounter());
    }

    @Test
    public void incrementCounter() {
        String one = "2020-05-12 01:09:39.653";
        String two = "2020-05-12 02:09:39.653";
        String three = "2020-05-12 03:09:39.653";
        String four = "2020-05-12 04:09:39.653";
        String five = "2020-05-12 05:09:39.653";

        Timestamp first = Timestamp.valueOf(one);
        Timestamp second = Timestamp.valueOf(two);
        Timestamp third = Timestamp.valueOf(three);
        Timestamp fourth = Timestamp.valueOf(four);
        Timestamp fifth = Timestamp.valueOf(five);
        ecTest.incrementCounter(first);
        ecTest.incrementCounter(second);
        ecTest.incrementCounter(third);
        assertEquals(3, ecTest.getCounter());

    }

    @Test
    public void incrementCounterEndTest() {
        String one = "2020-05-12 01:09:39.653";
        String two = "2020-05-12 02:09:39.653";
        String three = "2020-05-12 03:09:39.653";
        String four = "2020-05-12 04:09:39.653";
        String five = "2020-05-12 05:09:39.653";

        Timestamp first = Timestamp.valueOf(one);
        Timestamp second = Timestamp.valueOf(two);
        Timestamp third = Timestamp.valueOf(three);
        Timestamp fourth = Timestamp.valueOf(four);
        Timestamp fifth = Timestamp.valueOf(five);
        ecTest.incrementCounter(first);
        ecTest.incrementCounter(second);
        ecTest.incrementCounter(third);
        ecTest.incrementCounter(fifth);
        ecTest.incrementCounter(fourth);

        assertEquals(5, ecTest.getCounter());
    }

    @Test
    public void incrementCounterMiddleTest() {
        String one = "2020-05-12 01:09:39.653";
        String two = "2020-05-12 02:09:39.653";
        String three = "2020-05-12 03:09:39.653";
        String four = "2020-05-12 04:09:39.653";
        String five = "2020-05-12 05:09:39.653";

        Timestamp first = Timestamp.valueOf(one);
        Timestamp second = Timestamp.valueOf(two);
        Timestamp third = Timestamp.valueOf(three);
        Timestamp fourth = Timestamp.valueOf(four);
        Timestamp fifth = Timestamp.valueOf(five);
        ecTest.incrementCounter(first);
        ecTest.incrementCounter(second);
        ecTest.incrementCounter(fourth);
        ecTest.incrementCounter(fifth);
        ecTest.incrementCounter(third);


        assertEquals(5, ecTest.getCounter());
    }

    @Test
    public void returnCountOverTimeTest() {
        String one = "2020-05-12 01:09:39.653";
        String two = "2020-05-12 02:09:39.653";
        String three = "2020-05-12 03:09:39.653";
        String four = "2020-05-12 04:09:39.653";
        String five = "2020-05-12 05:09:39.653";

        Timestamp first = Timestamp.valueOf(one);
        Timestamp second = Timestamp.valueOf(two);
        Timestamp third = Timestamp.valueOf(three);
        Timestamp fourth = Timestamp.valueOf(four);
        Timestamp fifth = Timestamp.valueOf(five);
        ecTest.incrementCounter(first);
        ecTest.incrementCounter(second);
        ecTest.incrementCounter(fourth);
        ecTest.incrementCounter(fifth);
        ecTest.incrementCounter(third);

        assertEquals(3, ecTest.returnCountOverTime("2020-05-11 01:30:39.653", "2020-05-12 03:30:39.653"));

    }

}