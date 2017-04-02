package banks;

import java.util.*;

/**
 * Created by vr on 30.03.2017.
 */
@SuppressWarnings("Since15")
public class Bank {
    private List<Visitor> visitors;
    Map<Date, Integer> currentTimetable;

    /**
     * Store when bank is opens.
     */
    private Date opens;
    /**
     * Store when bank is closes.
     */
    private Date closes;

    public Bank(Date opens, Date closes) {
        this.opens = opens;
        this.closes = closes;
        this.visitors = new ArrayList<Visitor>();
    }

    public void add(Visitor visitor) {
        visitors.add(visitor);
    }
    private void addEventToTimetable(Date date, int iter) {
        if (!currentTimetable.containsKey(date)) {
            currentTimetable.put(date, iter);
        } else {
            currentTimetable.put(date, currentTimetable.get(opens)+ iter);
        }
    }

    public Map<Date, Integer> createTimetable() {
        this.currentTimetable = new TreeMap<Date, Integer>();
        int count = 0;
        for (Visitor visitor : visitors) {
            //если время входа и выхода до открытия - игнорируем поситителя
            if (visitor.in.compareTo(opens) < 0 && visitor.out.compareTo(closes) < 0) {
                continue;
            }
            //если время входа и выхода после загрытия - игнорируем поситителя
            if (visitor.in.compareTo(closes) > 0 && visitor.out.compareTo(closes) > 0) {
                continue;
            }
            //если время входа  до открытия - заносим поситителя, как будто он вошел во время открытия
            if (visitor.in.compareTo(opens) < 0) {
                addEventToTimetable(opens, 1);
                continue;
            }
            //если время выхода после закрытия - заносим поситителя, как будто он вышел во время закрытия
            if (visitor.out.compareTo(closes) > 0) {
                addEventToTimetable(closes, -1);
                continue;
            }
            //иначе просто добавляем в массив с соответствующим временем входа и выхода
            addEventToTimetable(visitor.in, 1);
            addEventToTimetable(visitor.out, -1);
        }

        System.out.println(currentTimetable);

        List entryList = new ArrayList(currentTimetable.entrySet());

        System.out.println(entryList);

        Collections.max(entryList, new Comparator() {
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
        return currentTimetable;
    }

    public void analazyLoad(List<Visitor> visitors){

        Comparator<Visitor> dateInAscending = new Comparator<Visitor>() {
            public int compare(Visitor o1, Visitor o2) {
                return o1.in.compareTo(o2.out);
            }
        };
        Collections.sort(visitors, dateInAscending);
    }

    public static void main(String[] args) {
        Date opens = new Date(2017,3,30,8,00,00);
        Date closes = new Date(2017,3,30,20,00,00);
        Visitor visitor1 = new Visitor(new Date(2017,3,30,9,30),
                new Date(2017,3,30,10,00));
        Visitor visitor2 = new Visitor(new Date(2017,3,30,9,40),
                new Date(2017,3,30,10,05));
        Bank bank = new Bank(opens, closes);
        bank.add(visitor1);
        bank.add(visitor2);
        bank.createTimetable();
    }


}
