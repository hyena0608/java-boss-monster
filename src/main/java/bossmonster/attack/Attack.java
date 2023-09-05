package bossmonster.attack;

import bossmonster.vo.Damage;
import bossmonster.vo.MagicPoint;

public interface Attack {

    Damage getAttackDamage();

    MagicPoint getNeedMagicPoint();

    MagicPoint getHealMagicPoint();
}
