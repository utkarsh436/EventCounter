import java.sql.Timestamp;

import static java.lang.Thread.sleep;

public class main {

    public static void main(String[] args) throws InterruptedException {
        EventCounter ec = new EventCounter();
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



        ec.incrementCounter(first);
        ec.incrementCounter(second);
        ec.incrementCounter(third);
        ec.incrementCounter(fourth);
        ec.incrementCounter(fifth);

        System.out.println(ec.getCounter());

        System.out.println(ec.returnCountOverTime("2020-05-11 01:30:39.653", "2020-05-12 03:30:39.653"));


    }

}
