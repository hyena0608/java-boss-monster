package bossmonster.console.request;

import bossmonster.vo.HealthPoint;
import bossmonster.vo.MagicPoint;

import java.util.Objects;

public class PlayerStatusPointRequest {

    private final HealthPoint healthPoint;
    private final MagicPoint magicPoint;

    public PlayerStatusPointRequest(final HealthPoint healthPoint, final MagicPoint magicPoint) {
        this.healthPoint = healthPoint;
        this.magicPoint = magicPoint;
    }

    public HealthPoint getHealthPoint() {
        return healthPoint;
    }

    public MagicPoint getMagicPoint() {
        return magicPoint;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PlayerStatusPointRequest that = (PlayerStatusPointRequest) o;
        return Objects.equals(healthPoint, that.healthPoint) && Objects.equals(magicPoint, that.magicPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(healthPoint, magicPoint);
    }

    @Override
    public String toString() {
        return "PlayerStatusPointRequest{" +
               "healthPoint=" + healthPoint +
               ", magicPoint=" + magicPoint +
               '}';
    }
}
