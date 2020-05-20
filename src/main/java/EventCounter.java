import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

    private List<LocalTime> timestamp = new ArrayList<>();

    public EventCounter() {
    }

    /**
     * Inserts a timestamp into the list based on the current time
     *
     */
    public void incrementCounter() {
        LocalTime currTime = LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        incrementCounter(currTime);
    }


    /**
     * Inserts a timestamp into the list speicifed by user after
     * Pruning the list to remove timestamps that were over 5 mins
     * ago
     * @param currDateTime user specified timestamp to insert
     */
    public void incrementCounter(LocalTime currDateTime) {
        LocalTime fiveMinsAgo = LocalTime.parse(currDateTime.minusMinutes(5)
                .format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        for (int i = 0; i < timestamp.size(); i++) {
            LocalTime dateTime = timestamp.get(i);
            if (dateTime.isBefore(fiveMinsAgo)) {
                timestamp.remove(i);
            }
        }
        timestamp.add(currDateTime);
    }

    /**
     * Checks to see if the start and end values are proper
     * runs a loop from start to end  on the timestamp list
     * inclusive and increments count by 1
     *
     * @param seconds how many seconds ago from now we need to
     *                start from
     * @return -1 if the range is greater than 5 minutes else
     * returns the total count of events between the 2 inputs
     */
    public int getCountOverTime(int seconds) {
        if (seconds > 300) return -1;
        LocalTime startTime = LocalTime.parse(LocalDateTime.now().minusSeconds(seconds)
                .format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        int startIdx = findNearestIndex(startTime);
        int total = timestamp.size() - startIdx;
        return total;
    }


    /**
     * Locates the index of the timestamp closest to the
     * target or the target itself using binary search
     *
     * @param target
     * @return index of the target or closest index greater
     * than the target
     */

    private int findNearestIndex(LocalTime target){
        int left = 0;
        int right = timestamp.size()-1;
        while(left < right){
            int mid = left + (right - left) /2 ;
            int val = timestamp.get(mid).compareTo(target);
            if(val < 0){
                left = mid + 1;
            }
            else right = mid;
        }
        return left;
    }
}
