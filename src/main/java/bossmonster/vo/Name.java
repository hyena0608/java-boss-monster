package bossmonster.vo;

import java.util.Objects;

public final class Name {

    private static final int MAX_LENGTH = 5;
    private final String value;

    public Name(final String value) {
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능합니다.");
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Name{" +
               "value='" + value + '\'' +
               '}';
    }
}
