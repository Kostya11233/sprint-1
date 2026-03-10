import java.util.Random;
import java.util.Scanner;

public class BigMonster {

    public static String bigMonster = "👹";

    public static String bigMonster() {
        return bigMonster;
    }

    public static int bigMonsterDefeated;

    public static boolean bigTask(int difficultGame) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("БОЛЬШАЯ ЗАДАЧА");
        int count = 2;
        int a, b, c, d, trueAns;


        if (difficultGame <= 2) {
            a = random.nextInt(10);
            b = random.nextInt(10);
            c = random.nextInt(20);
            trueAns = a * b + c;
            System.out.println(a + " * " + b + " + " + c + " = ?");
        } else if (difficultGame <= 4) {
            a = random.nextInt(12);
            b = random.nextInt(10);
            c = random.nextInt(30);
            d = random.nextInt(15);
            trueAns = a * b + c - d;
            System.out.println(a + " * " + b + " + " + c + " - " + d + " = ?");
        } else {
            a = random.nextInt(10);
            b = random.nextInt(10);
            c = random.nextInt(8);
            d = random.nextInt(20);
            int e = random.nextInt(10);
            trueAns = a * b * c + d - e;
            System.out.println(a + " * " + b + " * " + c + " + " + d + " - " + e + " = ?");
        }

        System.out.println("Количество попыток: " + count);

        while (count > 0) {
            int ans = scanner.nextInt();
            if (trueAns == ans) {
                System.out.println("Верно! Ты одолел БОЛЬШОГО монстра!");
                BigMonster.bigMonsterDefeated++;
                return true;
            } else {
                System.out.println("Ответ неверный!");
                count--;
                if (count > 0) {
                    System.out.println("Осталось попыток: " + count);
                }
            }
        }

        System.out.println("Попытки закончились! Ты проиграл битву с большим монстром!");
        Person.live--;
        return false;
    }
}