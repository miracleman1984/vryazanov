package ru.job4j.nonblockingalgoritm;

/**
 * Class Model
 * <p>
 * Class store model properties.
 *
 * @author vryazanov
 * @version 1.0
 * @since 05.12.2017
 */
public class Model {
    /**
     * Store Model version
     */
    private int version;
    /**
     * Store model name
     */
    private String name;

    /**
     * Model constructor
     *
     * @param name initial name of the model
     */
    public Model(String name) {
        this.version = 0;
        this.name = name;
    }

    /**
     * Return vesrion of the model
     *
     * @return vesrion of the model
     */
    public int getVersion() {
        return version;
    }

    /**
     * Return name of the model
     *
     * @return name of the model
     */
    public String getName() {
        return name;
    }

    /**
     * Set version of the model
     *
     * @param version desired value of the version
     */
    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * Set name of the model
     *
     * @param name desired name of the model
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Model model = (Model) o;

        if (version != model.version) {
            return false;
        }
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
        return "Model{"
                + "version="
                + version
                + ", name='"
                + name
                + '\''
                + '}';
    }
}
