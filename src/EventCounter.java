import java.sql.Timestamp;
import java.util.*;

public class EventCounter {
    private int counter = 0;
    private List<Timestamp> timestamp = new ArrayList<>();
    private List<Integer> count = new ArrayList<>();

    public EventCounter(){
    }

    public int getCounter() {
        return counter;
    }

    public void incrementCounter(Timestamp t) {
        if(timestamp.size() == 0 || timestamp.size() == 1){
            timestamp.add(t);
            count.add(1);
            return;
        }

        counter += 1;

        int idx = binarySearch(t);

        if(idx == timestamp.size()-1){
            timestamp.add(t);
            count.add(1);
        }
        else{
            timestamp.add(idx, t);
            count.add(idx, 1);
        }
    }

    public int returnCountOverTime(String start, String end){

        Timestamp startTime = Timestamp.valueOf(start);
        Timestamp endTime = Timestamp.valueOf(end);

        int startIdx = binarySearch(startTime);
        System.out.print(startIdx);

        int endIdx = binarySearch(endTime);

        int sum = 0;
        for(int i = startIdx; i <=endIdx; i++){
            sum += count.get(i);
        }
        return sum;
    }

    private int binarySearch(Timestamp target){
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
