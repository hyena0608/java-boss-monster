package bossmonster.vo;

import java.util.Objects;

public final class Damage {

    private final int value;

    public Damage(final int value) {
        this.value = value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Damage damage = (Damage) o;
        return value == damage.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Damage{" +
               "value=" + value +
               '}';
    }
}
