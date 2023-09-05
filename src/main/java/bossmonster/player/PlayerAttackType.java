package bossmonster.player;

import java.util.Arrays;

public enum PlayerAttackType {

    PHYSICAL(1, "물리 공격"),
    MAGICAL(2, "마법 공격");

    private final int code;
    private final String description;

    PlayerAttackType(final int code, final String description) {
        this.code = code;
        this.description = description;
    }

    public static PlayerAttackType from(final int code) {
        return Arrays.stream(PlayerAttackType.values())
                .filter(attackType -> attackType.code == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 플레이어의 공격 타입입니다."));
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
