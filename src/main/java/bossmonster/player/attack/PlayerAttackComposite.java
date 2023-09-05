package bossmonster.player.attack;

import bossmonster.attack.Attack;
import bossmonster.player.PlayerAttackType;
import bossmonster.player.attack.magical.PlayerDefaultMagicalAttack;
import bossmonster.player.attack.physical.PlayerDefaultPhysicalAttack;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static bossmonster.player.PlayerAttackType.MAGICAL;
import static bossmonster.player.PlayerAttackType.PHYSICAL;

public class PlayerAttackComposite {

    private final Map<PlayerAttackType, Attack> skills = new HashMap<>();

    {
        skills.put(PHYSICAL, new PlayerDefaultPhysicalAttack());
        skills.put(MAGICAL, new PlayerDefaultMagicalAttack());
    }

    public Attack attack(final PlayerAttackType playerAttackType) {
        final Attack attack = skills.getOrDefault(playerAttackType, null);
        if (Objects.isNull(attack)) {
            throw new IllegalArgumentException("[ERROR] 플레이어에게 맞는 공격 타입이 존재하지 않습니다.");
        }

        return attack;
    }
}
