import java.util.Random;
import java.util.Scanner;

public class Person {

    public static int live = 3;

    public String bay = "Очень жаль! Заходи ещё!";
    void move(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }
    public static int x = 1;

    public static int y = 5;


    public String image = "\uD83E\uDDD9\u200D";


}