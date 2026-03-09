import java.util.Random;
import java.util.Scanner;

public class Monster {
    private final int x, y;
    static Random r = new Random();

    Monster(int sizeBoard) {
        this.y = r.nextInt(sizeBoard - 1);
        this.x = r.nextInt(sizeBoard);
    }

    public static boolean taskMonster(int difficultGame) {
        return taskMonster();
    }

    public String getImage() {
        return monsterr;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public boolean conflictPerson(int perX, int perY) {
        return perY - 1 == this.y && perX - 1 == this.x;
    }

    public static String monsterr = "\uD83E\uDDDF\u200D";

    public static int monsterDefeated;

    public static String monsterr() {
        return monsterr;
    }

    public static boolean taskMonster() {
        System.out.println("Решите задачу:");
        int x = r.nextInt(50);
        int y = r.nextInt(50);
        int trueAnswer = x + y;
        int count = 1;
        System.out.println("Реши пример: " + x + " + " + y + " = ?");
        System.out.println("Количество попыток: " + count);
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();
        if (count > 0) {
            if (trueAnswer == ans) {
                System.out.println("Верно! Ты победил монстра");
                Monster.monsterDefeated++;
                return true;
            } else {
                System.out.println("Ответ неверный!");
                Person.live--;
                count--;

                System.out.println("Количество попыток: " + count);

                System.out.println("Ты проиграл эту битву!");

                return false;
            }
        }
        return false;
    }
}










