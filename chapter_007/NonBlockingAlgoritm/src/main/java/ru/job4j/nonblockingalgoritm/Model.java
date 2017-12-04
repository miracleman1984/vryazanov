package ru.job4j.nonblockingalgoritm;

/**
 * Created by vvryazanov on 04.12.2017.
 */
public class Model {
    private int version;
    private String name;

    public Model(String name) {
        this.version = 0;
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        if (version != model.version) return false;
        return name != null ? name.equals(model.name) : model.name == null;
    }

    @Override
    public int hashCode() {
        int result = version;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Model{" +
                "version=" + version +
                ", name='" + name + '\'' +
                '}';
    }
}
