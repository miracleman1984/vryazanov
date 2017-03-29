package ru.vryazanov.hierachy;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;

/**
 * Hierachy class that store departments and sorting it.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 29.03.2017
 */
public class Hierachy {
    /**
     * Store unique departments.
     */
    private Set<String> departments;

    /**
     * Comparator for ascending order.
     */
    private Comparator<String> ascending = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            int result = 0;
            String[] strings1 = s1.split("\\\\");
            String[] strings2 = s2.split("\\\\");
            int levelLen1 = strings1.length;
            int levelLen2 = strings2.length;
            int lim = Math.min(levelLen1, levelLen2);
            //обозначаем (учитываем) разницу в уровне сравниваемых подразделений
            result += (levelLen1 - levelLen2);
            //обозначаем (учитываем) разницу в головных подразделениях
            int k = 0;
            while (k < lim) {
                if (!strings1[k].equals(strings2[k])) {
                    result += strings1[k].compareTo(strings2[k]) * (1000 / (k + 1));
                    break;
                }
                k++;
            }

            return result;
        }
    };

    /**
     * Comparator for descending order.
     */
    private Comparator<String> descending = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            int result = 0;
            String[] strings1 = s1.split("\\\\");
            String[] strings2 = s2.split("\\\\");
            int levelLen1 = strings1.length;
            int levelLen2 = strings2.length;
            int lim = Math.min(levelLen1, levelLen2);
            //обозначаем (учитываем) разницу в уровне сравниваемых подразделений
            result += (levelLen1 - levelLen2);
            //обозначаем (учитываем) разницу в головных подразделениях
            int k = 0;
            while (k < lim) {
                if (!strings1[k].equals(strings2[k])) {
                    result += strings2[k].compareTo(strings1[k]) * (1000 / (k + 1));
                    break;
                }
                k++;
            }

            return result;
        }
    };

    /**
     * Hierachy class constructor.
     *
     */
    public Hierachy() {
        this.departments = new HashSet<String>();
    }

    /**
     * Initializing programm.
     *
     * @param strings initial strings
     *
     */
    public void init(List<String> strings) {
        for (String s : strings) {
            addToStructure(s);
        }
    }

    /**
     * Adding unique hierarchy strings from the string.
     *
     * @param string a department sting
     *
     */
    private void addToStructure(String string) {
        departments.add(string);
        if (string.lastIndexOf('\\') != -1) {
            addToStructure(new String(string.substring(0, string.lastIndexOf('\\'))));
        }
    }
    /**
     * Return departments in ascendingOrder.
     *
     * @return departments in ascendingOrder.
     *
     */
    public List<String> ascendingOrder() {
        Set<String> set = new TreeSet<String>(ascending);
        List<String> strings = new ArrayList<String>();
        set.addAll(departments);
        strings.addAll(set);
        return strings;
    }
    /**
     * Return departments in desceningOrder.
     *
     * @return departments in desceningOrder.
     *
     */
    public List<String> desceningOrder() {
        Set<String> set = new TreeSet<String>(descending);
        List<String> strings = new ArrayList<String>();
        set.addAll(departments);
        strings.addAll(set);
        return strings;
    }


}
