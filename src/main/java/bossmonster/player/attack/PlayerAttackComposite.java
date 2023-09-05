package bossmonster.player.attack;

import bossmonster.attack.Attack;
import bossmonster.player.PlayerAttackType;
import bossmonster.player.attack.magical.PlayerDefaultMagicalAttack;
import bossmonster.player.attack.physical.PlayerDefaultPhysicalAttack;

import java.util.HashMap;
import java.util.Map;

import static bossmonster.player.PlayerAttackType.*;

public class PlayerAttackComposite {

    private final Map<PlayerAttackType, Attack> skills = new HashMap<>();

    {
        skills.put(PHYSICAL, new PlayerDefaultPhysicalAttack());
        skills.put(MAGICAL, new PlayerDefaultMagicalAttack());
    }

    public Attack attack(final PlayerAttackType playerAttackType) {
        return skills.getOrDefault(playerAttackType, null);
    }
}
