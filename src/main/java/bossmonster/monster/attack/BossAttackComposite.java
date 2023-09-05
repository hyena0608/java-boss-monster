package bossmonster.monster.attack;

import bossmonster.attack.Attack;
import bossmonster.monster.BossAttackType;
import bossmonster.monster.attack.physical.BossDefaultPhysicalAttack;

import java.util.HashMap;
import java.util.Map;

import static bossmonster.monster.BossAttackType.*;

public class BossAttackComposite {

    private final Map<BossAttackType, Attack> skills = new HashMap<>();

    {
        skills.put(PHYSICAL, new BossDefaultPhysicalAttack());
    }

    public Attack attack(final BossAttackType bossAttackType) {
        return skills.getOrDefault(bossAttackType, null);
    }
}
