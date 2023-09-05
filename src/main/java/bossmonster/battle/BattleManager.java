package bossmonster.battle;

import bossmonster.attack.Attack;
import bossmonster.console.ConsoleReader;
import bossmonster.console.ConsoleWriter;
import bossmonster.console.request.PlayerStatusPointRequest;
import bossmonster.monster.Monster;
import bossmonster.player.Player;
import bossmonster.player.PlayerAttackType;
import bossmonster.vo.Damage;
import bossmonster.vo.HealthPoint;
import bossmonster.vo.Name;

public class BattleManager {

    public void start() {
        final HealthPoint bossHP = ConsoleReader.readBossMonsterHealthPoint();
        final Name playerName = ConsoleReader.readPlayerName();
        final PlayerStatusPointRequest playerStatusPoint = ConsoleReader.readPlayerHealthPointAndMagicPoint();

        final Monster monster = Monster.newDefaultInstance(bossHP);
        final Player player = Player.newDefaultInstance(
                playerName,
                playerStatusPoint.getHealthPoint(),
                playerStatusPoint.getMagicPoint()
        );

        try {
            battleInProgress(monster, player);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void battleInProgress(final Monster monster, final Player player) {
        ConsoleWriter.printStartBattle();
        ConsoleWriter.printBattleWindow(monster, player);
        int turn = 0;
        while (!player.isDied() && !monster.isDied()) {
            turn++;
            playerTurn(monster, player);
            monsterTurn(monster, player);
            ConsoleWriter.printBattleWindow(monster, player);
        }

        ConsoleWriter.printBattleEnd(monster, player, turn);
    }

    private static void playerTurn(final Monster monster, final Player player) {
        while (true) {
            try {
                final PlayerAttackType playerAttackType = ConsoleReader.readPlayerAttackType();
                final Attack playerAttack = player.attack(playerAttackType);
                monster.attackedBy(playerAttack);
                ConsoleWriter.printPlayerAttack(playerAttackType);

                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void monsterTurn(final Monster monster, final Player player) {
        if (monster.isDied()) {
            return;
        }

        final Attack monsterAttack = monster.attack();
        final Damage playerDamaged = player.attackedBy(monsterAttack);
        ConsoleWriter.printBossAttack(playerDamaged);
    }
}
