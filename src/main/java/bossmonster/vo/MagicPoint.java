package bossmonster.vo;

import java.util.Objects;

public final class MagicPoint {

    public static final MagicPoint ZERO = new MagicPoint(0);

    private final int value;

    public MagicPoint(final int value) {
        this.value = value;
    }

    public boolean isSameOrGreaterThan(final MagicPoint other) {
        return this.value >= other.value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final MagicPoint that = (MagicPoint) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "MagicPoint{" +
               "value=" + value +
               '}';
    }
}
