import java.sql.Array;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;

public class EventCounter {
    private int counter = 0;
//    private Map<String, Integer> map = new HashMap<>();
//    private Map<String, Integer> map = new LinkedHashMap<>();


    private List<Timestamp> timestamp = new ArrayList<>();
    private List<Integer> count = new ArrayList<>();
    public EventCounter(){
    }

    public int getCounter() {
        return counter;
    }

    public void incrementCounter(Timestamp t) {
        counter += 1;
        int left = 0;
        int right = timestamp.size();

        while(left < right){
            int mid = left + (right - left) /2 ;
            int val = timestamp.get(mid).compareTo(t);
            if(val < 0){
                left = mid + 1;
            }
            else right = mid;
        }
        timestamp.add(left, t);
        count.add(left, 1);


    }

    public int returnCountOverTime(String start, String end){
        int count = 0;
//        int startIdx = map.get(start);
//        int endIdx = map.get(end);
//        for(int i = startIdx; i <= endIdx; i++){
//            count += list.get(i);
//        }
//        return count;

        // find the first key is larger than the start

        return 0;
    }

}
