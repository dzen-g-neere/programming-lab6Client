package labwork;

import java.io.Serializable;

/**
 * Color.
 */
public enum Color implements Serializable {
    RED("RED"),
    ORANGE("ORANGE"),
    GREEN("GREEN"),
    BLUE("BLUE"),
    BROWN("BROWN"),
    BLACK("BLACK"),
    WHITE("WHITE");

    public final String name;

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Color{" +
                "name='" + name + '\'' +
                '}';
    }
}
