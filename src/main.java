import java.sql.Timestamp;

import static java.lang.Thread.sleep;

public class main {

    public static void main(String[] args) throws InterruptedException {
        EventCounter ec = new EventCounter();

        Timestamp first = new Timestamp(System.currentTimeMillis());
        sleep(1000);
        Timestamp second = new Timestamp(System.currentTimeMillis());
        sleep(1000);
        Timestamp third = new Timestamp(System.currentTimeMillis());
        sleep(1000);
        Timestamp fourth = new Timestamp(System.currentTimeMillis());
        sleep(1000);
        Timestamp fifth = new Timestamp(System.currentTimeMillis());



        ec.incrementCounter(first);
        ec.incrementCounter(second);
        ec.incrementCounter(third);
        ec.incrementCounter(fourth);
        ec.incrementCounter(fifth);

        System.out.println(ec.getCounter());

        System.out.println(ec.returnCountOverTime(second.toString(), fourth.toString()));


    }

}
