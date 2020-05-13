import java.time.LocalDateTime;
public class main {

    public static void main(String[] args) throws InterruptedException {

        LocalDateTime myDateObj = LocalDateTime.now();
        System.out.println("Before formatting: " + myDateObj.toString());

        LocalDateTime one = LocalDateTime.parse("2020-05-12T01:09:39.653");
        LocalDateTime two = LocalDateTime.parse("2020-05-12T02:09:39.653");
        LocalDateTime three = LocalDateTime.parse("2020-05-12T03:09:39.653");
        LocalDateTime four = LocalDateTime.parse("2020-05-12T04:09:39.653");
        LocalDateTime five = LocalDateTime.parse("2020-05-12T05:09:39.653");

        EventCounter ec = new EventCounter();

        ec.incrementCounter(one);
        ec.incrementCounter(two);
        ec.incrementCounter(three);
        ec.incrementCounter(four);
        ec.incrementCounter(five);

        System.out.println(ec.getCounter());

        System.out.println(ec.returnCountOverTime(LocalDateTime.parse("2020-05-11T01:30:39.653"),
                LocalDateTime.parse("2020-05-12T03:30:39.653")));


    }

}
