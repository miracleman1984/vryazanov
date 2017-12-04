package ru.job4j.nonblockingalgoritm;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by vvryazanov on 04.12.2017.
 */
public class ModelStore {
    ConcurrentHashMap<Integer, Model> modelStore = new ConcurrentHashMap<Integer, Model>();

    public void add(int key, Model model) {
        modelStore.put(key, model);
    }

    public void update(int key, final Model newModel) {

        modelStore.computeIfPresent(key, (k, v) -> {
            System.out.println(k + "  " + v + Thread.currentThread().getName());
            newModel.setVersion(v.getVersion() + 1);
            if (newModel.getVersion() - 1 == v.getVersion()) {
                v = newModel;
                System.out.println(Thread.currentThread().getName() + " has changed version to " + v.getVersion());
                return v;
            } else {
                throw new OptimisticException(newModel.getVersion() - 1, v.getVersion());
            }

        });
    }

    public Model delete(int key) {
        return modelStore.remove(key);
    }


    public Model get(int key) {
        return modelStore.get(key);
    }

    public static void main(String[] args) {
        ModelStore modelStore = new ModelStore();
        modelStore.add(1, new Model("first"));
        ;
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Before " + modelStore.get(1) + "  " + Thread.currentThread().getName());
                modelStore.update(1, new Model("1"));
                System.out.println("After " + modelStore.get(1) + "  " + Thread.currentThread().getName());
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
                System.out.println("Before " + modelStore.get(1) + "  " + Thread.currentThread().getName());
                modelStore.update(1, new Model("2"));
                System.out.println("After " + modelStore.get(1) + "  " + Thread.currentThread().getName());
            }
        };

        for (int i = 0; i < 3; i++) {
            new Thread(r1).start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread(r2).start();
        }

//        new Thread() {
//            @Override
//            public void run() {
//                modelStore.update(1, new Model("1"));
//                System.out.println(modelStore.get(1) + "  " + Thread.currentThread().getName());
//            }
//        }.start();
//        new Thread() {
//            @Override
//            public void run() {
//                modelStore.update(1, new Model("2"));
//                System.out.println(modelStore.get(1) + "  " + Thread.currentThread().getName());
//            }
//        }.start();
//        new Thread() {
//            @Override
//            public void run() {
//                modelStore.update(1, new Model("3"));
//                System.out.println(modelStore.get(1) + "  " + Thread.currentThread().getName());
//            }
//        }.start();
//        new Thread() {
//            @Override
//            public void run() {
//                modelStore.update(1, new Model("4"));
//                System.out.println(modelStore.get(1) + "  " + Thread.currentThread().getName());
//            }
//        }.start();
//        new Thread() {
//            @Override
//            public void run() {
//                modelStore.update(1, new Model("5"));
//                System.out.println(modelStore.get(1) + "  " + Thread.currentThread().getName());
//            }
//        }.start();

    }
}
