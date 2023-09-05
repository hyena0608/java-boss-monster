package bossmonster.console;

import bossmonster.attack.Attack;
import bossmonster.monster.Monster;
import bossmonster.player.Player;
import bossmonster.player.PlayerAttackType;
import bossmonster.vo.Damage;

import static bossmonster.console.common.ConsoleConst.ENTER;
import static bossmonster.console.common.ConsoleConst.HP;
import static bossmonster.console.common.ConsoleConst.LEFT_BRACKET;
import static bossmonster.console.common.ConsoleConst.MINUS;
import static bossmonster.console.common.ConsoleConst.MP;
import static bossmonster.console.common.ConsoleConst.ONE_LINE_BAR;
import static bossmonster.console.common.ConsoleConst.RIGHT_BRACKET;
import static bossmonster.console.common.ConsoleConst.SLASH;
import static bossmonster.console.common.ConsoleConst.SPACE;
import static bossmonster.console.common.ConsoleConst.TWO_LINE_BAR;

public final class ConsoleWriter {

    private ConsoleWriter() {
    }

    public static void printStartBattle() {
        System.out.println("보스 레이드를 시작합니다 !");
    }

    public static void printBattleWindow(final Monster monster, final Player player) {
        final StringBuilder sb = new StringBuilder();
        appendMonsterHp(monster, sb);
        appendMonsterPicture(sb);
        appendPlayerHpAndMp(monster, player, sb);

        sb.append(ENTER.value())
                .append(TWO_LINE_BAR.value())
                .append(ENTER.value())
                .append(ENTER.value());
        System.out.println(sb);
    }

    private static void appendMonsterHp(final Monster monster, final StringBuilder sb) {
        sb.append(TWO_LINE_BAR.value())
                .append(ENTER.value())
                .append(monster.getName().getValue()).append(SPACE.value())
                .append(HP.value())
                .append(LEFT_BRACKET.value())
                .append(monster.getHealthPoint().getValue())
                .append(SLASH.value())
                .append(monster.getHealthPoint().getMaxValue())
                .append(RIGHT_BRACKET.value());
    }

    private static void appendMonsterPicture(final StringBuilder sb) {
        sb.append(ENTER.value())
                .append(ONE_LINE_BAR.value())
                .append(ENTER.value())
                .append("")
                .append(ENTER.value())
                .append(ONE_LINE_BAR.value())
                .append(ENTER.value())
                .append(ENTER.value());
    }

    private static void appendPlayerHpAndMp(final Monster monster, final Player player, final StringBuilder sb) {
        sb.append(player.getName().getValue())
                .append(SPACE.value())
                .append(HP.value())
                .append(LEFT_BRACKET.value())
                .append(player.getHealthPoint().getValue())
                .append(SLASH.value())
                .append(player.getHealthPoint().getMaxValue())
                .append(RIGHT_BRACKET.value())
                .append(SPACE.value())
                .append(MP.value())
                .append(SPACE.value())
                .append(LEFT_BRACKET.value())
                .append(player.getMagicPoint().getValue())
                .append(SLASH.value())
                .append(player.getMagicPoint().getMaxValue())
                .append(RIGHT_BRACKET.value());
    }

    public static void printPlayerAttack(final PlayerAttackType playerAttackType) {
        System.out.println(playerAttackType.getDescription() + "을 했습니다." + ENTER.value());
    }

    public static void printBossAttack(final Damage playerDamaged) {
        final StringBuilder sb = new StringBuilder();
        sb.append("보스가 공격 했습니다.")
                .append(ENTER.value())
                .append(HP.value())
                .append(SPACE.value())
                .append(MINUS.value())
                .append(playerDamaged.getValue())
                .append(ENTER.value());

        System.out.println(sb);
    }

    public static void printBattleEnd(final Monster monster, final Player player, final int turn) {
        final StringBuilder sb = new StringBuilder();
        if (monster.isDied()) {
            sb.append(player.getName().getValue())
                    .append(SPACE.value())
                    .append("님이")
                    .append(SPACE.value())
                    .append(turn)
                    .append("번의 전투 끝에 보스 몬스터를 잡았습니다.");

            System.out.println(sb);
            return;
        }

        if (player.isDied()) {
            System.out.println("보스 레이드 실패 (x.x)");
        }
    }
}
