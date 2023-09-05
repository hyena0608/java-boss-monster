package bossmonster.player.attack.magical;

import bossmonster.attack.Attack;
import bossmonster.vo.Damage;
import bossmonster.vo.MagicPoint;

public class PlayerDefaultMagicalAttack implements Attack {

    private static final Damage DAMAGE = new Damage(20);
    private static final MagicPoint NEED_MP = MagicPoint.newInstance(20);
    private static final MagicPoint HEAL_MP = MagicPoint.ZERO;

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
