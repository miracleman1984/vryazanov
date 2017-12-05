package ru.job4j.nonblockingalgoritm;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Class  ModelStore.
 * <p>
 * Class for store model objects.
 *
 * @author vryazanov
 * @version 1.0
 * @since 05.12.2017
 */
public class ModelStore {
    /**
     * Store model objects
     */
    ConcurrentHashMap<Integer, Model> modelStore = new ConcurrentHashMap<Integer, Model>();

    /**
     * Add new model to store
     *
     * @param key   appropriate to the model
     * @param model to add
     */
    public void add(int key, Model model) {
        modelStore.put(key, model);
    }

    /**
     * Update model in store by key.
     *
     * @param key
     * @param newModel
     */
    public void update(int key, final Model newModel) {
        modelStore.computeIfPresent(key, (k, v) -> {
            newModel.setVersion(v.getVersion() + 1);
            if (newModel.getVersion() - 1 == v.getVersion()) {
                v = newModel;
                return v;
            } else {
                throw new OptimisticException(newModel.getVersion() - 1, v.getVersion());
            }

        });
    }

    /**
     * Delete model from the store by key
     *
     * @param key
     * @return model that was deleted
     */
    public Model delete(int key) {
        return modelStore.remove(key);
    }

    /**
     * Return model from store by the key.
     *
     * @param key
     * @return model by the key
     */
    public Model get(int key) {
        return modelStore.get(key);
    }

    /**
     * Main method
     *
     * @param args appropriate args
     */
    public static void main(String[] args) {
        ModelStore modelStore = new ModelStore();
        for (int i = 0; i < 50; i++) {
            modelStore.add(i, new Model("first"));
        }
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                modelStore.update(5, new Model("1"));
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                modelStore.update(5, new Model("2"));

            }
        };

        for (int i = 0; i < 10000; i++) {
            new Thread(r1).start();
        }
        for (int i = 0; i < 10000; i++) {
            new Thread(r2).start();
        }


    }
}
