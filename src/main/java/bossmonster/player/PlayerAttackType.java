package bossmonster.player;

import java.util.Arrays;

public enum PlayerAttackType {

    PHYSICAL(1),
    MAGICAL(2);

    private final int code;

    PlayerAttackType(final int code) {
        this.code = code;
    }

    public static PlayerAttackType from(final int code) {
        return Arrays.stream(PlayerAttackType.values())
                .filter(attackType -> attackType.code == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 플레이어의 공격 타입입니다."));
    }
}
