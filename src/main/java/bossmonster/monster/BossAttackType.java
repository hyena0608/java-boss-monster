package bossmonster.monster;

import bossmonster.player.PlayerAttackType;

import java.util.Arrays;

public enum BossAttackType {

    PHYSICAL(1);

    private final int code;

    BossAttackType(final int code) {
        this.code = code;
    }

    public static BossAttackType defaultPhysicalAttack() {
        return PHYSICAL;
    }
}
