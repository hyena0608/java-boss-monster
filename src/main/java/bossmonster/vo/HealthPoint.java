package bossmonster.vo;

import java.util.Objects;

public final class HealthPoint {

    private final int value;

    public HealthPoint(final int value) {
        this.value = value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final HealthPoint that = (HealthPoint) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "HealthPoint{" +
               "value=" + value +
               '}';
    }
}
