package bank;

import java.util.*;

/**
 * Created by vr on 15.03.2017.
 */
public class Bank {
    private long opens;
    private long closes;
    private Event[] eventlog;



    public Bank(long opens, long closes, Event[] events) {
        this.opens = opens;
        this.closes = closes;
        this.eventlog = events;
    }

    public ArrayList<TimeRange> findMaxLoad(HashMap<Long, Integer> map){
        ArrayList<TimeRange> result = new ArrayList<TimeRange>();
        long timeFrom = this.opens;
        long timeTo = this.closes;
        int max = 0;
        for (Map.Entry<Long, Integer> pair : map.entrySet()) {
            if (pair.getValue() > max) {
                max = pair.getValue();
            }
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<Long, Integer> item = (Map.Entry) it.next();
            if (item.getValue() == max) {
                timeFrom = item.getKey();
                if (it.hasNext()){
                    timeTo =  ((Map.Entry<Long, Integer>) it.next()).getKey();
                }
                result.add(new TimeRange(timeFrom,timeTo));
                timeTo = this.closes;
            }
        }
        System.out.println(max);
        return result;
    }

    public TimeRange findMinLoad(){
        return null;
    }

    public HashMap<Long, Integer> createTimetable(){
        LinkedHashMap<Long, Integer> map = new LinkedHashMap<Long, Integer>();
        int count = 0;
        for (Event event: eventlog) {
            long eventTime = event.getTime();
            int increment = (event.getEventType() == 1) ? 1 : -1;
            count += increment;
            map.put(eventTime, count);
        }
        System.out.println(map);
        return map;
    }

//    public static void main(String[] args) {
//        Bank bank = new Bank(8,20, new Event[] {new In(9), new In(9), new Out(11),new In(12)});
//        bank.findMaxLoad(bank.createTimetable());
//    }

}
