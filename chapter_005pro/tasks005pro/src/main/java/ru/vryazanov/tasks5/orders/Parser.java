package ru.vryazanov.tasks5.orders;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Class  Parser.
 * <p>
 * Parse xml file .
 *
 * @author vryazanov
 * @version 1.0
 * @since 20.07.2017
 */
public class Parser {
    /**
     * FileName to parse.
     */
    private String fileName;
    /**
     * Store where will be results of the parsing.
     */
    private BookStore bookStore;
    /**
     * Store parsing logic.
     */
    private DefaultHandler handler = new DefaultHandler() {
        /**
         * Метод вызывается, когда SAXParser начинает обработку тэга
         */
        @Override
        public void startElement(String uri, String localName,
                                 String qName, Attributes attributes)
                throws SAXException {

            if ("AddOrder".equals(qName)) {
                int bookID = Integer.parseInt(attributes.getValue("book").substring(5));
                int orderID = Integer.parseInt(attributes.getValue("orderId"));
                String operation = attributes.getValue("operation");
                Double price = Double.parseDouble(attributes.getValue("price"));
                int volume = Integer.parseInt(attributes.getValue("volume"));
                Order order = new Order(orderID, price, volume);

                bookStore.addOrder(bookID, operation, orderID, order);

            } else if ("DeleteOrder".equals(qName)) {
                int bookID = Integer.parseInt(attributes.getValue("book").substring(5));
                int orderID = Integer.parseInt(attributes.getValue("orderId"));

                bookStore.deleteOrder(bookID, orderID);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            super.endElement(uri, localName, qName);
        }

        @Override
        public void startDocument() throws SAXException {
            //System.out.println("Начало разбора документа!");
        }

        @Override
        public void endDocument() throws SAXException {
            //System.out.println("Разбор документа завершен!");
        }
    };
    /**
     * Parser constructor.
     *
     * @param fileName file to parse.
     * @param bookStore store where will be results of parsing..
     */
    public Parser(String fileName, BookStore bookStore) {
        this.fileName = fileName;
        this.bookStore = bookStore;
    }
    /**
     * Start parsing.
     *
     */
    public void start() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            // Стартуем разбор XML-документа
            saxParser.parse(fileName, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
