package ru.vryazanov.tasks5.control;

/**
 * Created by vr on 27.07.2017.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;
/**
 * Класс BookOrdersTest тестирует класс BookOrders.
 *
 * @author Gureyev Ilya (mailto:ill-jah@yandex.ru)
 * @version 3
 * @since 2017-06-29
 */
public class BookOrdersTest {
    /**
     * Объект с заказами.
     */
    private BookOrders bo;
    /**
     * Тестирует BookOrders. Используется StAX-парсер.
     */
    @Test
    public void testBookOrdersUsingStAXParser() {
        try {
            long start = System.nanoTime();
            BookOrders bo = new BookOrders();
            bo.loadXML("orders.xml");
            bo.parse();
            bo.print();
            System.out.println(System.nanoTime() - start);
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Ошибка ввода-вывода.");
            ex.printStackTrace();
        } catch (XMLStreamException ex) {
            System.out.println("Ошибка XML-потока.");
            ex.printStackTrace();
        }
    }
}
