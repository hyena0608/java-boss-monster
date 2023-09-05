package bossmonster.vo;

import java.util.Objects;

public final class MagicPoint {

    public static final MagicPoint ZERO = new MagicPoint(0, 0);

    private final int maxValue;
    private final int value;

    private MagicPoint(final int maxValue, final int value) {
        this.maxValue = maxValue;
        this.value = value;
    }

    public static MagicPoint newInstance(final int value) {
        return new MagicPoint(value, value);
    }

    public boolean isLessThan(final MagicPoint other) {
        return this.value < other.value;
    }

    public MagicPoint minus(final MagicPoint minusMagicPoint) {
        if (value <= minusMagicPoint.value) {
            return new MagicPoint(maxValue, 0);
        }

        return new MagicPoint(maxValue, value - minusMagicPoint.value);
    }

    public MagicPoint plus(final MagicPoint plusMagicPoint) {
        if (maxValue <= value + plusMagicPoint.value) {
            return new MagicPoint(maxValue, maxValue);
        }

        return new MagicPoint(maxValue, value - plusMagicPoint.value);
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getValue() {
        return value;
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
