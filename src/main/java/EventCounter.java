import java.sql.Timestamp;
import java.util.*;

public class EventCounter {
    /**
     * The user of this class has the ability to keep track of how
     * many events have taken in place in total and return the value
     * back
     *
     * They also have the ability to retrieve a count in between two
     * seperate Timestamps
     */
    private int counter = 0;
    private List<Timestamp> timestamp = new ArrayList<>();
    private List<Integer> count = new ArrayList<>();

    public EventCounter(){
    }

    public int getCounter() {
        /**
         * @return total count of all events
         */
        return counter;
    }

    public void incrementCounter(Timestamp t) {
    /**
     * Finds the appropriate location via
     * binary search of where to insert
     * the Timestamp in the timestamp
     * list and then increments the overall
     * counter by 1
     *
     * @param: Timestamp to insert
     */
        if(timestamp.size() == 0){
            timestamp.add(t);
            count.add(1);
            counter += 1;
            return;
        }
        counter += 1;
        int idx = binarySearch(t);

        if(idx == timestamp.size()-1){
            if(timestamp.get(idx).compareTo(t) > 0){
                timestamp.add(idx, t);
                count.add(idx, 1);
            }else {
                timestamp.add(t);
                count.add(1);
            }
        }
        else{
            timestamp.add(idx, t);
            count.add(idx, 1);
        }
    }

    public int returnCountOverTime(String start, String end){
        /**
         * Runs a binary search to find the index of the
         * closest timestamp or the timestamp itself for
         * the given start and end times.
         *
         * Calculates the total given after the 2 indexes
         * have been found and returns the total
         *
         * @param start the start of the user inputted timestamp
         * @param end the end of the user inputted timestamp
         * @return total count of events between the 2 inputs
         */
        Timestamp startTime = Timestamp.valueOf(start);
        Timestamp endTime = Timestamp.valueOf(end);

        int startIdx = binarySearch(startTime);

        int endIdx = rightMostElementBinarySearch(endTime);
        int sum = 0;
        for(int i = startIdx; i <=endIdx; i++){
            sum += count.get(i);
        }
        return sum;
    }

    private int binarySearch(Timestamp target){
        /**
         * Binary Search implementation to return the index
         * of the target timestamp in the timestamp list
         *
         * @param target the timestamp to search for in the list
         * @return index of the target timestamp
         */
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

    private int rightMostElementBinarySearch(Timestamp target){
        /**
         * Binary Search implementation to return the rightmost index
         * of the target timestamp in the timestamp list.
         *
         * @param target the timestamp to search for in the list
         * @return index of the target timestamp
         */
        int left = 0;
        int right = timestamp.size()-1;
        while(left < right){
            int mid = left + (right - left)/2;
            int val = timestamp.get(mid).compareTo(target);
            if(val > 0){
                right = mid;
            } else{
                left = mid + 1;
            }
        }
        return right - 1;
    }

}
