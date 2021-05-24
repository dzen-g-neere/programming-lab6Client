package labwork;

import java.io.Serializable;

/**
 * Nationality.
 */
public enum Country implements Serializable {
    FRANCE("FRANCE"),
    VATICAN("VATICAN"),
    ITALY("ITALY"),
    THAILAND("THAILAND");

    private final String name;

    Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                '}';
    }
}
