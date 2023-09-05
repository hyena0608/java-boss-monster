package bossmonster.player;

import bossmonster.attack.Attack;
import bossmonster.player.attack.PlayerAttackComposite;
import bossmonster.vo.HealthPoint;
import bossmonster.vo.MagicPoint;
import bossmonster.vo.Name;

import java.util.Objects;

public final class Player {

    private final Name name;
    private final HealthPoint healthPoint;
    private final MagicPoint magicPoint;
    private final PlayerAttackComposite skills;

    private Player(final Name name, final HealthPoint healthPoint, final MagicPoint magicPoint, final PlayerAttackComposite skills) {
        this.name = name;
        this.healthPoint = healthPoint;
        this.magicPoint = magicPoint;
        this.skills = skills;
    }

    public static Player defaultAttackSkills(final Name name, final HealthPoint healthPoint, final MagicPoint magicPoint) {
        return new Player(name, healthPoint, magicPoint, new PlayerAttackComposite());
    }

    public Attack attack(final PlayerAttackType attackType) {
        return skills.attack(attackType);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(healthPoint, player.healthPoint) && Objects.equals(magicPoint, player.magicPoint) && Objects.equals(skills, player.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, healthPoint, magicPoint, skills);
    }

    @Override
    public String toString() {
        return "Player{" +
               "name=" + name +
               ", healthPoint=" + healthPoint +
               ", magicPoint=" + magicPoint +
               ", skills=" + skills +
               '}';
    }
}
