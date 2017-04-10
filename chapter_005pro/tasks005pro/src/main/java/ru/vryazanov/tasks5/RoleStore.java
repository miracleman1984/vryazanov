package ru.vryazanov.tasks5;

/**
 * Class  RoleStore.
 * <p>
 * Container class for role objects.
 *
 * @author vryazanov
 * @version 1.0
 * @since 10.04.2017
 */
public class RoleStore implements Store<Role> {
    /**
     * Store role objects.
     */
    private SimpleList<Role> roleList;
    /**
     * RoleStore constructor.
     *
     * @param size initial size of the container
     */
    public RoleStore(int size) {
        this.roleList = new SimpleList<Role>(size);
    }
    @Override
    public void add(Role role) {
        this.roleList.add(role);
    }

    @Override
    public void update(Role oldRole, Role newRole) {
        this.roleList.update(oldRole, newRole);
    }
    @Override
    public void delete(Role role) {
        this.roleList.delete(role);
    }
    @Override
    public Role get(int position) {
        return roleList.get(position);
    }

}
