package ru.vryazanov.tasks5;

/**
 * Created by vr on 19.04.2017.
 * @param <E> any type of the generic
 */
public abstract class BaseStore<E extends Base> implements Store<E> {
    /**
     * Store role objects.
     */
    private SimpleList<E> baseList;
    /**
     * RoleStore constructor.
     *
     * @param size initial size of the container
     */
    public BaseStore(int size) {
        this.baseList = new SimpleList<E>(size);
    }
    @Override
    public void add(E e) {
        this.baseList.add(e);
    }

    @Override
    public void update(E oldThing, E newThing) {
        this.baseList.update(oldThing, newThing);
    }
    @Override
    public void delete(E e) {
        this.baseList.delete(e);
    }
    @Override
    public E get(int position) {
        return baseList.get(position);
    }
}
