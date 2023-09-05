package bossmonster.monster.attack;

import bossmonster.attack.Attack;
import bossmonster.monster.BossAttackType;
import bossmonster.monster.attack.physical.BossDefaultPhysicalAttack;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static bossmonster.monster.BossAttackType.*;

public class BossAttackComposite {

    private final Map<BossAttackType, Attack> skills = new HashMap<>();

    {
        skills.put(PHYSICAL, new BossDefaultPhysicalAttack());
    }

    public Attack attack(final BossAttackType bossAttackType) {
        final Attack attack = skills.getOrDefault(bossAttackType, null);
        if (Objects.isNull(attack)) {
            throw new IllegalArgumentException("[ERROR] 보스에게 맞는 공격 타입이 존재하지 않습니다.");
        }

        return attack;
    }
}
