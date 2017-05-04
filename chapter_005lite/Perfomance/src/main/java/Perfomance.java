import java.util.*;

/**
 * Created by vr on 21.03.2017.
 */
public class Perfomance {

//    Написать программу, которая замеряет время вставки в коллекцию большого количества случайных строк и удаления в коллекции первых n элементов для:
//    LinkedList
//    ArrayList
//    TreeSet
//    В классе должно быть 2 метода:
//    public long add(Collection<String> collection, String line, int amount) {}
//    public long delete(Collection<String> collection, String line, int amount) {}
//
//    По результатам тестов расставьте коллекции по местам и объясните результат.

//    Примечание: так как эти 3 коллекции имеют одинаковый интерфейс Collection мы можем использовать методы add и remove для всех них.
    public static long add(Collection<String> collection, String[] lines, int amount) {
        long time1 = System.currentTimeMillis();
        for (String line: lines) {
            collection.add(line);
        }
        long time2 = System.currentTimeMillis();
        return time2 - time1;
    }

    public static long delete(Collection<String> collection, int amount) {
        long time1 = System.currentTimeMillis();
        Iterator<String> iter = collection.iterator();
        for (int i = 0; i < amount ; i++) {
            iter.next();
            iter.remove();
        }
        long time2 = System.currentTimeMillis();
        return time2 - time1;
    }
    private static final String mCHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int STR_LENGTH = 50; // длина генерируемой строки
    static Random random = new Random();


    public static String createRandomString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < STR_LENGTH; i++) {
            int number = random.nextInt(mCHAR.length());
            char ch = mCHAR.charAt(number);
            builder.append(ch);
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        // количество строк в коллекции для теста
        int number = 500000;
        // инициализация тестируемых коллекций
        ArrayList<String> stringArrayList = new ArrayList<String>();
        LinkedList<String> stringLinkedList = new LinkedList<String>();
        TreeSet<String> stringTreeSet = new TreeSet<String>();
        // создание массива случайных строк
        String[] strings = new String[number];
        for (int i = 0; i < number; i++) {
            strings[i] = createRandomString();
        }
        System.out.println("Операция вставки");
        System.out.println("ArrayList: " + Perfomance.add(stringArrayList, strings, number));
        System.out.println("LinkedList: " + Perfomance.add(stringLinkedList, strings, number));
        System.out.println("TreeSet: " + Perfomance.add(stringTreeSet, strings, number));
        System.out.println("Операция удаления первых  n элементов ");
        System.out.println("ArrayList: " +Perfomance.delete(stringArrayList, number));
        System.out.println("LinkedList: " + Perfomance.delete(stringLinkedList, number));
        System.out.println("TreeSet: " +Perfomance.delete(stringTreeSet, number));
    }
}
