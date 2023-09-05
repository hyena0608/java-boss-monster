package bossmonster.player;

import bossmonster.attack.Attack;
import bossmonster.player.attack.PlayerAttackComposite;
import bossmonster.vo.Damage;
import bossmonster.vo.HealthPoint;
import bossmonster.vo.MagicPoint;
import bossmonster.vo.Name;

import java.util.Objects;

public final class Player {

    public static final int NEED_HP_MP = 200;
    private final PlayerAttackComposite skills;
    private final Name name;
    private HealthPoint healthPoint;
    private MagicPoint magicPoint;

    private Player(final PlayerAttackComposite skills, final Name name, final HealthPoint healthPoint, final MagicPoint magicPoint) {
        if (healthPoint.getValue() + magicPoint.getValue() != NEED_HP_MP) {
            throw new IllegalArgumentException("[ERROR] 플레이어의 초기 HP와 MP의 합은 200이어야 합니다.");
        }

        this.name = name;
        this.healthPoint = healthPoint;
        this.magicPoint = magicPoint;
        this.skills = skills;
    }

    public static Player newDefaultInstance(final Name name, final HealthPoint healthPoint, final MagicPoint magicPoint) {
        return new Player(new PlayerAttackComposite(), name, healthPoint, magicPoint);
    }

    public Attack attack(final PlayerAttackType attackType) {
        final Attack playerAttack = skills.attack(attackType);
        if (magicPoint.isLessThan(playerAttack.getNeedMagicPoint())) {
            throw new IllegalArgumentException("[ERROR] 플레이어의 마나가 충분하지 않습니다.");
        }

        this.magicPoint = magicPoint.minus(playerAttack.getNeedMagicPoint());
        this.magicPoint = magicPoint.plus(playerAttack.getHealMagicPoint());

        return playerAttack;
    }

    public Damage attackedBy(final Attack attack) {
        final Damage damaged = attack.getAttackDamage();
        this.healthPoint = healthPoint.minusBy(damaged);

        return damaged;
    }

    public boolean isDied() {
        return healthPoint.isZero();
    }

    public Name getName() {
        return name;
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
