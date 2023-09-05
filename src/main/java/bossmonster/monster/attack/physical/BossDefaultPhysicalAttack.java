package bossmonster.monster.attack.physical;

import bossmonster.attack.Attack;
import bossmonster.vo.Damage;
import bossmonster.vo.MagicPoint;

import java.util.Random;

public class BossDefaultPhysicalAttack implements Attack {

    private static final int MAX_DAMAGE = 20;
    private static final MagicPoint NEED_MP = MagicPoint.ZERO;
    private static final MagicPoint HEAL_MP = MagicPoint.ZERO;

    @Override
    public Damage getAttackDamage() {
        return new Damage(new Random().nextInt(MAX_DAMAGE));
    }

    @Override
    public MagicPoint getNeedMagicPoint() {
        return NEED_MP;
    }

    @Override
    public MagicPoint getHealMagicPoint() {
        return HEAL_MP;
    }
}
