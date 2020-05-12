import java.sql.Timestamp;

import static java.lang.Thread.sleep;

public class main {

    public static void main(String[] args) throws InterruptedException {
        EventCounter ec = new EventCounter();
        ec.incrementCounter(new Timestamp(System.currentTimeMillis()));
        sleep(100);
        ec.incrementCounter(new Timestamp(System.currentTimeMillis()));
        sleep(100);
        System.out.println(ec.getCounter());

        System.out.println(ec.returnCountOverTime("", ""));


    }

}
