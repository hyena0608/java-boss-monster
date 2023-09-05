package bossmonster.monster;

import bossmonster.attack.Attack;
import bossmonster.monster.attack.BossAttackComposite;
import bossmonster.vo.Damage;
import bossmonster.vo.HealthPoint;
import bossmonster.vo.MagicPoint;
import bossmonster.vo.Name;

import java.util.Objects;

public final class Monster {

    private static final String DEFAULT_NAME = "BOSS";
    private static final int MIN_HP = 100;
    private static final int MAX_HP = 300;

    private final BossAttackComposite skills;
    private final Name name;
    private HealthPoint healthPoint;
    private MagicPoint magicPoint;

    private Monster(final BossAttackComposite skills, final Name name, final HealthPoint healthPoint, final MagicPoint magicPoint) {
        if (healthPoint.isCurrentHealthPointLowerThan(MIN_HP) && healthPoint.isCurrentHealthPointGreaterThan(MAX_HP)) {
            throw new IllegalArgumentException("[ERROR] 보스의 HP 는 100 이상 300 이하이어야 합니다.");
        }

        this.skills = skills;
        this.name = name;
        this.healthPoint = healthPoint;
        this.magicPoint = magicPoint;
    }

    public static Monster newDefaultInstance(final HealthPoint healthPoint) {
        return new Monster(new BossAttackComposite(), new Name(DEFAULT_NAME), healthPoint, MagicPoint.ZERO);
    }

    public boolean isDied() {
        return healthPoint.isZero();
    }

    public Attack attack() {
        final Attack monsterAttack = skills.attack(BossAttackType.PHYSICAL);
        if (magicPoint.isLessThan(monsterAttack.getNeedMagicPoint())) {
            throw new IllegalArgumentException("[ERROR] 보스의 마나가 충분하지 않습니다.");
        }
        magicPoint  = magicPoint.minus(monsterAttack.getNeedMagicPoint());

        return monsterAttack;
    }

    public Damage attackedBy(final Attack attack) {
        final Damage damaged = attack.getAttackDamage();
        this.healthPoint = healthPoint.minusBy(damaged);

        return damaged;
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
        final Monster monster = (Monster) o;
        return Objects.equals(name, monster.name) && Objects.equals(skills, monster.skills) && Objects.equals(healthPoint, monster.healthPoint) && Objects.equals(magicPoint, monster.magicPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, skills, healthPoint, magicPoint);
    }

    @Override
    public String toString() {
        return "Monster{" +
               "name=" + name +
               ", attackComposite=" + skills +
               ", healthPoint=" + healthPoint +
               ", magicPoint=" + magicPoint +
               '}';
    }
}
