package ru.job4j.monitorysynchronizy;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Class  ParallerSearch.
 * <p>
 * Class that search fo files with definite extensions and definite text inside them from root directory.
 *
 * @author vryazanov
 * @version 1.0
 * @since 06.10.2017
 */
public class ParallerSearch extends Thread {
    /**
     * Internal storage for founded file paths.
     */
    private final List<String> result = new ArrayList<String>();
    /**
     * Internal storage for work threads.
     */
    private final List<Thread> threads = new ArrayList<Thread>();
    /**
     * Internal storage for directories to process.
     */
    private final Queue<File> dirs = new LinkedList<File>();
    /**
     * Internal storage for initial directory to process.
     */
    private final String root;
    /**
     * Internal storage for text to find.
     */
    private static String text;
    /**
     * Internal storage file extensions to search.
     */
    private static List<String> exts;

    /**
     * UserStorage constructor.
     *
     * @param exts file extensions to search.
     * @param root initial directory to process.
     * @param text text to find.
     */
    public ParallerSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }


    public static void main(String[] args) throws InterruptedException {
        String root = "c:\\1";
        String text = "198478";
        List<String> exts = new ArrayList<String>();
        exts.add("java");
        ParallerSearch search = new ParallerSearch(root, text, exts);
        search.start();
        search.join();
        System.out.println(search.result());
    }

    /**
     * Search files in the directory.
     *
     * @param file directory to search file
     * @param text text to find.
     * @param exts file extensions to search.
     */
    public void search(File file, String text, List<String> exts) {
        for (final File fileEntry : file.listFiles()) {
            if (!fileEntry.isDirectory()) {
                String filePath = fileEntry.getPath();
                //проверить файл на соответствие расширениям
                for (String s : exts) {
                    //если расширение совпало - запустить поиск по файлу
                    if (filePath.endsWith(s)) {
                        //найти текст внутри файла
                        try {
                            BufferedReader inputStream = new BufferedReader(new FileReader(filePath));
                            String l;
                            while ((l = inputStream.readLine()) != null) {
                                if (!l.equals("")) {
                                    if (l.contains(text)) {
                                        synchronized (result) {
                                            result.add(filePath);
                                        }
                                        break;
                                    }
                                }
                            }
                            inputStream.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
            }
        }
    }

    /**
     * Search files in the directory.
     *
     * @param dir directory to process
     */
    public void searchDirs(File dir) {
        dirs.add(dir);
        //проверить файл на соответствие расширениям
        for (final File fileEntry : dir.listFiles()) {
            if (fileEntry.isDirectory()) {
                //запустить новый поток поиска по этой директории
                searchDirs(fileEntry);
            }
        }
    }

    @Override
    public void run() {
        File folder = new File(root);
        searchDirs(folder);
        for (int i = 0; i < dirs.size(); i++) {
            threads.add(new Thread(new Runnable() {
                public void run() {
                    search(dirs.poll(), text, exts);
                }
            }));
        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Return search results.
     *
     * @return list of founded file paths
     */
    public List<String> result() {
        return result;
    }
}
