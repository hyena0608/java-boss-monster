package bossmonster.console;

import bossmonster.console.request.PlayerStatusPointRequest;
import bossmonster.player.PlayerAttackType;
import bossmonster.vo.HealthPoint;
import bossmonster.vo.MagicPoint;
import bossmonster.vo.Name;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static bossmonster.console.common.ConsoleConst.DOT;
import static bossmonster.console.common.ConsoleConst.ENTER;
import static bossmonster.console.common.ConsoleConst.SPACE;

public final class ConsoleReader {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private ConsoleReader() {
    }

    public static HealthPoint readBossMonsterHealthPoint() {
        while (true) {
            System.out.println("보스 몬스터의 HP를 입력해주세요.");
            try {
                final String bossMonsterHealthPoint = br.readLine();
                validateDigit(bossMonsterHealthPoint, "[ERROR] 보스 몬스터의 HP는 숫자로만 입력되어야 합니다.");

                return HealthPoint.newInstance(Integer.parseInt(bossMonsterHealthPoint));
            } catch (IOException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateDigit(final String value, final String message) {
        final boolean isNotDigit = value.strip()
                .chars()
                .anyMatch(Character::isAlphabetic);

        if (isNotDigit) {
            throw new IllegalArgumentException(message);
        }
    }


    public static Name readPlayerName() {
        while (true) {
            System.out.println("플레이어의 이름을 입력해주세요.");
            try {
                return new Name(br.readLine());
            } catch (IOException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static PlayerStatusPointRequest readPlayerHealthPointAndMagicPoint() {
        while (true) {
            System.out.println("플레이어의 HP와 MP를 입력해주세요.(,로 구분)");
            try {
                final String[] healthPointAndMagicPoint = br.readLine().split(",");
                validateDigit(healthPointAndMagicPoint[0], "[ERROR] 플레이어의 HP는 숫자로만 입력되어야 합니다.");
                validateDigit(healthPointAndMagicPoint[1], "[ERROR] 플레이어의 MP는 숫자로만 입력되어야 합니다.");

                return new PlayerStatusPointRequest(
                        HealthPoint.newInstance(Integer.parseInt(healthPointAndMagicPoint[0])),
                        MagicPoint.newInstance(Integer.parseInt(healthPointAndMagicPoint[1]))
                );
            } catch (IOException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static PlayerAttackType readPlayerAttackType() {
        while (true) {
            System.out.println("어떤 공격을 하시겠습니까?");

            final StringBuilder sb = new StringBuilder();
            for (PlayerAttackType attackType : PlayerAttackType.values()) {
                sb.append(attackType.getCode())
                        .append(DOT.value())
                        .append(SPACE.value())
                        .append(attackType.getDescription())
                        .append(ENTER.value());
            }
            System.out.println(sb);

            try {
                final String playerAttackType = br.readLine();
                validateDigit(playerAttackType, "[ERROR] 플레이어의 공격 타입은 숫자로만 입력되어야 합니다.");

                return PlayerAttackType.from(Integer.parseInt(playerAttackType));
            } catch (IOException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
