
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static int difficultGame;

    public static void main (String[] args) {
        int step = 0;
        int castleY = 0;
        Random random = new Random();
        int castleX = random.nextInt(Board.board);
        Person person = new Person();
        person.x = 1;
        person.y = 5;
        String castle = "\uD83C\uDFF0";
        String[][] board = new String[Board.board][Board.board];
        for (int y = 0; y < Board.board; y++) {
            for (int x = 0; x < Board.board; x++) {
                board[y][x] = "  ";
            }
        }
        int countMonster = Board.board * (Board.board - 1) - 1;
        for (int i = 0; i <= countMonster; i++) {
            board[random.nextInt(Board.board - 1)][random.nextInt(Board.board)] = Monster.monsterr();
        }
        {
            board[random.nextInt(Board.board - 1)][random.nextInt(Board.board)] = BigMonster.bigMonster();
        }

        board[castleY][castleX] = castle;
        System.out.println("Привет! Начнем игру? (Напиши да или нет)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        System.out.println("Ваш ответ: " + answer);
        switch (answer) {
            case "да":
                System.out.println("Погнали!");
                System.out.println("Выбери уровень сложности игры(от 1 до 5):");
                int difficultGame;
                difficultGame = scanner.nextInt();

                while (true) {
                    if (difficultGame <= 5 && difficultGame >= 1) {
                        board[person.y - 1][person.x - 1] = person.image;
                        outputboard(board);
                        System.out.println("Количество жизней: " + person.live);
                        System.out.println("Координаты персонажа: X = " + person.x + ", Y = " + person.y);
                        System.out.println("Введи куда будешь ходить: ");
                        int x = scanner.nextInt();
                        int y = scanner.nextInt();
                        if (x != person.x && y != person.y || x < 1 || y < 1 || y > 5 || x > 5) {
                            System.out.println("Координаты введены неверно!");
                        } else {
                            if (Math.abs(person.x - x) == 1 || Math.abs(person.y - y) == 1) {
                                if (board[y - 1][x - 1].equals("  ")) {
                                    board[person.y - 1][person.x - 1] = "  ";
                                    step += 1;
                                    person.x = x;
                                    person.y = y;
                                    System.out.println("Номер хода: " + step + "\nКоординаты персонажа: " + person.x + ", " + person.y);
                                } else {
                                    if (board[y - 1][x - 1].equals(castle)) {
                                        System.out.println("Вы прошли игру!");
                                        System.out.println("Всего было сделано ходов: " + step);
                                        System.out.println("Осталось жизней: " + person.live);
                                        break;

                                    } else {

                                        if (board[y - 1][x - 1].equals(Monster.monsterr())) {
                                            if (Monster.taskMonster(difficultGame)) {
                                                board[person.y - 1][person.x - 1] = "  ";
                                                person.x = x;
                                                person.y = y;
                                            } else {
                                                board[person.y - 1][person.x - 1] = "  ";
                                                person.x = x;
                                                person.y = y;
                                            }
                                        } else if (board[y - 1][x - 1].equals(BigMonster.bigMonster())) {
                                            if (BigMonster.bigTask(difficultGame)) {
                                                board[person.y - 1][person.x - 1] = "  ";
                                                person.x = x;
                                                person.y = y;
                                            } else {
                                                board[person.y - 1][person.x - 1] = "  ";
                                                person.x = x;
                                                person.y = y;
                                            }
                                        }

                                    }
                                }
                            } else {
                                System.out.println("Координаты не изменились.");
                            }
                            if (person.live <= 0) {
                                System.out.println("Жизни закончились. Ваш результат: ");
                                System.out.println("Всего было сделано ходов: " + step);

                                break;
                            }
                        }
                    } else {
                        System.out.println("Такого уровня неcуществует!!!");
                        break;
                    }
                }
                break;
            case "нет":
                System.out.println(person.bay);
                break;
            default:
                System.out.println("Некоректный ввод!");
        }
    }


    static void outputboard(String[][] board) {
        String leftBlock = "| ";
        String rightBlock = "|";
        String wall = "+ —— + —— + —— + —— + —— +";

        for (String[] raw : board) {
            System.out.println(wall);
            for (String col : raw) {
                System.out.print(leftBlock + col + " ");
            }
            System.out.println(rightBlock);
        }
        System.out.println(wall);
    }
}




