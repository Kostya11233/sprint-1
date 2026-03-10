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
        System.out.println("Решите задачу: ");

        int x, y, z, trueAnswer;
        int count = 3 - Main.difficultGame;
        if (count < 1) count = 1;


        if (Main.difficultGame == 1) {
            x = r.nextInt(10);
            y = r.nextInt(10);
            trueAnswer = x + y;
            System.out.println(x + " + " + y + " = ?");
        } else if (Main.difficultGame == 2) {
            x = r.nextInt(15);
            y = r.nextInt(10);
            trueAnswer = x + y;
            System.out.println(x + " + " + y + " = ?");
        } else if (Main.difficultGame == 3) {
            x = r.nextInt(10);
            y = r.nextInt(10);
            trueAnswer = x * y;
            System.out.println(x + " * " + y + " = ?");
        } else if (Main.difficultGame == 4) {
            x = r.nextInt(10);
            y = r.nextInt(10);
            z = r.nextInt(10);
            trueAnswer = x + y - z;
            System.out.println(x + " + " + y + " - " + z + " = ?");
        } else {
            x = r.nextInt(8);
            y = r.nextInt(8);
            z = r.nextInt(15);
            trueAnswer = x * y + z;
            System.out.println(x + " * " + y + " + " + z + " = ?");
        }

        System.out.println("Количество попыток: " + count);
        Scanner sc = new Scanner(System.in);

        while (count > 0) {
            int ans = sc.nextInt();
            if (trueAnswer == ans) {
                System.out.println("Верно! Ты победил монстра");
                Monster.monsterDefeated++;
                return true;
            } else {
                System.out.println("Ответ неверный!");
                count--;
                if (count > 0) {
                    System.out.println("Осталось попыток: " + count);
                }
            }
        }

        System.out.println("Ты проиграл эту битву!");
        Person.live--;
        return false;
    }
}










