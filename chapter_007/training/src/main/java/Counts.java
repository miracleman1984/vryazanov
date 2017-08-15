/**
 * Class  Counts.
 * <p>
 * class for demonstration of multithreading.
 *
 * @author vryazanov
 * @version 1.0
 * @since 02.04.2017
 */
public class Counts {
    /**
     * Store string to analyze.
     */
    public static final String STRING = "My favourite soup is Solyanka. My mum cooks it and I usually help her. Solyanka is a traditional Russian soup, very delicious, thick and spicy. It is a meat lover’s dream and especially nice on cold winter days. It can be cooked in different variations with beef, pork, chicken, sausage and pickles. I’m going to describe my mother’s recipe of Solyanka. She doesn’t add potatoes, by the way.";
    /**
     * Store string with letters.
     */
    public static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
    /**
     * Class  CountWords.
     * <p>
     * couts words in string.
     *
     */
    public static final class CountWords implements Runnable {
        public void run() {
            int count1 = 0;
            boolean isWord = false;
            for (Character c : STRING.toLowerCase().toCharArray()) {
                //если было не слово, а сейчас буквенный символ - началось слово
                if (!isWord && LETTERS.indexOf(c) != -1) {
                    System.out.println("Найдено новое слово, текущее количество: " + ++count1);
                    isWord = true;
                }
                //если было слово, а сейчас небуквенный символ - значит слово закончилось, присваиваем isWord false
                if (isWord && LETTERS.indexOf(c) == -1) {
                    isWord = false;
                }
            }
            System.out.println("Общее количество слов: " + count1);
        }
    }

    /**
     * Class  CountDashes.
     * <p>
     * couts dashes in string.
     *
     */
    public static final class CountDashes implements Runnable {
        public void run() {
            int count2 = 0;
            for (Character c : STRING.toLowerCase().toCharArray()) {
                if (c.equals(' ')) {
                    System.out.println("Найден новый пробел, текущее количество: " + ++count2);
                }
            }
            System.out.println("Общее количество пробелов: " + count2);
        }
    }


    public static void main(String[] args) {
        new Thread(new CountWords()).start();
        new Thread(new CountDashes()).start();
    }
}
