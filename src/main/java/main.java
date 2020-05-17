import java.time.LocalDateTime;
public class main {

    public static void main(String[] args) throws InterruptedException {

        LocalDateTime myDateObj = LocalDateTime.now();
        System.out.println("Before formatting: " + myDateObj.toString());

        LocalDateTime one = LocalDateTime.parse("2020-05-12T01:00:39.653");
        LocalDateTime two = LocalDateTime.parse("2020-05-12T01:01:39.653");
        LocalDateTime three = LocalDateTime.parse("2020-05-12T01:02:39.653");
        LocalDateTime four = LocalDateTime.parse("2020-05-12T01:03:39.653");
        LocalDateTime five = LocalDateTime.parse("2020-05-12T01:04:39.653");

        EventCounter ec = new EventCounter();

        System.out.println(ec.getCounter());

        System.out.println(ec.returnCountOverTime(LocalDateTime.parse("2020-05-11T01:30:39.653"),
                LocalDateTime.parse("2020-05-12T03:30:39.653")));


    }

}
