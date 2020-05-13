import java.time.LocalDateTime;
import java.util.*;

/**
 * The user of this class has the ability to keep track of how
 * many events have taken in place in total and return the value
 * back
 * <p>
 * They also have the ability to retrieve a count in between two
 * seperate Timestamps
 */
public class EventCounter {

    private int counter = 0;
    private List<LocalDateTime> timestamp = new ArrayList<>();

    public EventCounter() {
    }

    /**
     * @return total count of all events
     */
    public int getCounter() {

        return counter;
    }

    /**
     * Calculates the timestamp 5 mins ago from the current timestamp when
     * function was invoked. Removes all the timestamp that came before the
     * calculated timestamp of 5 mins ago and reduces the counter by 1.
     * <p>
     * Inserts the current timestamp and increases the count by 1;
     */
    public void incrementCounter() {
        LocalDateTime currDateTime = LocalDateTime.now();
        LocalDateTime fiveMinsAgo = currDateTime.minusMinutes(5);

        for (LocalDateTime dateTime : timestamp) {
            if (dateTime.isBefore(fiveMinsAgo)) {
                timestamp.remove(dateTime);
                counter--;
            }
        }
        timestamp.add(currDateTime);
        counter += 1;
    }

    /**
     * Checks to see if the start and end values are proper
     * runs a loop from start to end  on the timestamp list
     * inclusive and increments count by 1
     *
     * @param start the start of the user inputted timestamp
     * @param end   the end of the user inputted timestamp
     * @return -1 if the range is greater than 5 minutes else
     * returns the total count of events between the 2 inputs
     */
    public int returnCountOverTime(LocalDateTime start, LocalDateTime end) {
        LocalDateTime fiveMins = start.plusMinutes(5);
        if (end.isBefore(start) || end.isBefore(fiveMins)) {
            return -1;
        }
        int total = 0;
        for (LocalDateTime dateTime : timestamp) {
            if (dateTime.equals(start) || dateTime.isAfter(start) || dateTime.equals(end) || dateTime.isBefore(end)) {
                total += 1;
            }
        }
        return total;
    }
}
