import java.util.Random;
import java.util.Scanner;

public class BigMonster  {

    public static  String bigMonster = "👹";
    public static String bigMonster() {
        return bigMonster;
    }
    public static int bigMonsterDefeated;
    public static boolean bigTask(int difficultGame) {
        if (difficultGame == 1) {
            Random random = new Random();
            Scanner scanner = new Scanner(System.in);
            int count = 1;
            System.out.println("Решите задачу: ");
            System.out.println("Количество попыток: " + count);
            int a = random.nextInt(10);
            int b = random.nextInt(10);
            int c = random.nextInt(100);
            int d = random.nextInt(100);
            int trueAns = a * b + c - d;
            System.out.println(a + " * " + b + " + " + c + " - " + d + "= ?");
            while (count > 0) {
                int ans = scanner.nextInt();
                if (trueAns == ans) {
                    System.out.println("Верно! Ты одолел монстра!");
                    BigMonster.bigMonsterDefeated++;
                    return true;
                } else {
                    System.out.println("Ответ неверный!");


                    count--;
                    System.out.println("Количество попыток: " + count);
                }
            }
            System.out.println("Попытки закончились");
        }
        return false;
    }   }