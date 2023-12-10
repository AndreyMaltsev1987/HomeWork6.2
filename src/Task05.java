import java.util.Scanner;

public class Task05 {
    public static void main(String[] args) {
        System.out.println("Задание 5");

        Scanner input = new Scanner(System.in);

        System.out.print("Введите здоровье дракона: ");
        int dragonHealth = input.nextInt();

        System.out.print("Введите атаку дракона: ");
        int dragonAttack = input.nextInt();

        System.out.print("Введите здоровье одного копейщика: ");
        int soldierHealth = input.nextInt();

        System.out.print("Введите атаку одного копейщика: ");
        int soldierAttack = input.nextInt();

        int soldiersNeeded = calculateSoldiersNeeded(dragonHealth, dragonAttack, soldierHealth, soldierAttack);
        System.out.println("Минимальное количество копейщиков, необходимых для убийства дракона: " + soldiersNeeded);
    }

    public static int calculateSoldiersNeeded(int dragonHealth, int dragonAttack, int soldierHealth, int soldierAttack) {
        int soldiers = 0;

        while (dragonHealth > 0) {
            int damagePerTurn = soldiers * soldierAttack;
            int turnsToKillDragon = (int) Math.ceil((double) dragonHealth / damagePerTurn);
            int turnsToKillSoldiers = (int) Math.ceil((double) soldiers * dragonAttack / soldierHealth);

            if (turnsToKillDragon <= turnsToKillSoldiers) {
                soldiers++;
            } else {
                dragonHealth -= soldiers * soldierAttack;
            }
        }

        return soldiers;
    }
}




