package bossmonster.vo;

import java.util.Objects;

public final class HealthPoint {

    private static final int ZERO = 0;

    private final int maxValue;
    private final int value;

    private HealthPoint(final int maxValue, final int value) {
        this.maxValue = maxValue;
        this.value = value;
    }

    public static HealthPoint newInstance(final int value) {
        return new HealthPoint(value, value);
    }

    public boolean isZero() {
        return this.value == ZERO;
    }

    public boolean isCurrentHealthPointLowerThan(final int value) {
        return this.value < value;
    }

    public boolean isCurrentHealthPointGreaterThan(final int value) {
        return this.value > value;
    }

    public HealthPoint minusBy(final Damage minusDamage) {
        if (value - minusDamage.getValue() <= ZERO) {
            return new HealthPoint(maxValue, ZERO);
        }
        return new HealthPoint(maxValue, value - minusDamage.getValue());
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
        final HealthPoint that = (HealthPoint) o;
        return maxValue == that.maxValue && value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxValue, value);
    }

    @Override
    public String toString() {
        return "HealthPoint{" +
               "maxValue=" + maxValue +
               ", value=" + value +
               '}';
    }
}
