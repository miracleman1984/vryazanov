package ru.vryazanov.tasks5.set;


import java.util.Random;

/**
 * Perfomance class
 * <p>
 * Class for testing speed of sets.
 *
 * @author vryazanov
 * @version 1.0
 * @since 04.05.2017
 */
public class Perfomance {
    /**
     * Add amount of new element into the array.
     *
     * @param collection testing collection
     * @param lines that have to be added
     * @param amount of lines
     * @return time of execution
     */
    public static long add(MySet<String> collection, String[] lines, int amount) {
        long time1 = System.currentTimeMillis();
        for (String line : lines) {
            collection.add(line);
        }
        long time2 = System.currentTimeMillis();
        return time2 - time1;
    }
    /**
     * Store string of desirable symbols.
     */
    private static final String MCHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    /**
     * Store length of formin string.
     */
    private static final int STR_LENGTH = 50; // длина генерируемой строки
    /**
     * Store random number.
     */
    private static Random random = new Random();

    /**
     * Return string with desireble parametrs.
     *
     * @return random string
     */
    public static String createRandomString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < STR_LENGTH; i++) {
            int number = random.nextInt(MCHAR.length());
            char ch = MCHAR.charAt(number);
            builder.append(ch);
        }
        return builder.toString();
    }

    /**
     * Main testing method.
     *
     * @param args some args
     */
    public static void main(String[] args) {
        // количество строк в коллекции для теста
        int number = 40000;
        // инициализация тестируемых коллекций
        SimpleSet<String> stringSimpleSet = new SimpleSet<String>();
        LinkedSimpleSet<String> stringLinkedSimpleSet = new LinkedSimpleSet<String>();
        ImprovedSet<String> stringImprovedSet50 = new ImprovedSet<String>(50);
        ImprovedSet<String> stringImprovedSet100 = new ImprovedSet<String>(100);
        ImprovedSet<String> stringImprovedSet1000 = new ImprovedSet<String>(1000);
        ImprovedSet<String> stringImprovedSet5000 = new ImprovedSet<String>(5000);
        ImprovedSet<String> stringImprovedSet10000 = new ImprovedSet<String>(10000);
        // создание массива случайных строк
        String[] strings = new String[number];
        for (int i = 0; i < number; i++) {
            strings[i] = createRandomString();
        }
        System.out.println("Операция вставки");
        System.out.println("SimpleSet: " + Perfomance.add(stringSimpleSet, strings, number));
        System.out.println("LinkedSimpleSet: " + Perfomance.add(stringLinkedSimpleSet, strings, number));
        System.out.println("ImprovedSet with hashtable for 50 elements: " + Perfomance.add(stringImprovedSet50, strings, number) + "    Соотношение хэштаблицы к кол-ву элементов: " + 50. / number);
        System.out.println("ImprovedSet with hashtable for 100 elements: " + Perfomance.add(stringImprovedSet100, strings, number) + "    Соотношение хэштаблицы к кол-ву элементов: " + 100. / number);
        System.out.println("ImprovedSet with hashtable for 1000 elements: " + Perfomance.add(stringImprovedSet1000, strings, number) + "    Соотношение хэштаблицы к кол-ву элементов: " + 1000. / number);
        System.out.println("ImprovedSet with hashtable for 5000 elements: " + Perfomance.add(stringImprovedSet5000, strings, number) + "    Соотношение хэштаблицы к кол-ву элементов: " + 5000. / number);
        System.out.println("ImprovedSet with hashtable for 10000 elements: " + Perfomance.add(stringImprovedSet10000, strings, number) + "    Соотношение хэштаблицы к кол-ву элементов: " + 10000. / number);
    }
}
