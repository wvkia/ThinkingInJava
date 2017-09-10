package EnumMethod;

import java.util.Random;

import static EnumMethod.OutCome.DRAW;
import static EnumMethod.OutCome.LOSE;
import static EnumMethod.OutCome.WIN;

/**
 * 多路分发
 */
enum OutCome{
    WIN,LOSE,DRAW;
}
interface Item{
    OutCome compete(Item item);
    OutCome eval(Paper paper);
    OutCome eval(Scissors scissors);
    OutCome eval(Rock rock);
}
//Paper
class Paper implements Item{
    @Override
    public OutCome compete(Item item) {
        return item.eval(this);
    }

    @Override
    public OutCome eval(Paper paper) {
        return DRAW;
    }

    @Override
    public OutCome eval(Scissors scissors) {
        return WIN;
    }

    @Override
    public OutCome eval(Rock rock) {
        return LOSE;
    }

    @Override
    public String toString() {
        return "Paper";
    }
}
//Scissors
class Scissors implements Item{
    @Override
    public OutCome compete(Item item) {
        return item.eval(this);
    }

    @Override
    public OutCome eval(Paper paper) {
        return LOSE;
    }

    @Override
    public OutCome eval(Scissors scissors) {
        return DRAW;
    }

    @Override
    public OutCome eval(Rock rock) {
        return WIN;
    }

    @Override
    public String toString() {
        return "Scissors";
    }
}
class Rock implements Item{
    @Override
    public OutCome compete(Item item) {
        return item.eval(this);
    }

    @Override
    public OutCome eval(Paper paper) {
        return WIN;
    }

    @Override
    public OutCome eval(Scissors scissors) {
        return LOSE;
    }

    @Override
    public OutCome eval(Rock rock) {
        return DRAW;
    }

    @Override
    public String toString() {
        return "Rock";
    }
}
public class RoShamBo1 {
    static final int SIZE = 20;
    private static Random random = new Random(47);
    public static Item newItem(){
        switch (random.nextInt(3)){
            default:
            case 0:
                return new Scissors();
            case 1:
                return new Paper();
            case 2:
                return new Rock();
        }
    }
    public static void match(Item a,Item b){
        System.out.println(a+" vs> "+b+" : "+a.compete(b));
    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            match(newItem(),newItem());
        }
    }
}
