package bossmonster.player.attack.physical;

import bossmonster.attack.Attack;
import bossmonster.vo.Damage;
import bossmonster.vo.MagicPoint;

public class PlayerDefaultPhysicalAttack implements Attack {

    private static final Damage DAMAGE = new Damage(10);
    private static final MagicPoint NEED_MP = MagicPoint.ZERO;
    private static final MagicPoint HEAL_MP = new MagicPoint(10);

    @Override
    public Damage getAttackDamage() {
        return DAMAGE;
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
