package QueuePackage.Deque;

import java.util.LinkedList;

 class Deque <T>{
    private LinkedList<T> deque = new LinkedList<>();

    public void addFirst(T t) {
        deque.addFirst(t);
    }

    public void addLast(T t) {
        deque.addLast(t);
    }
    public T getFirst() {
        return deque.getFirst();
    }
    public T getLast(){
        return deque.getLast();
    }

    public T remveFirst(){
        return deque.removeFirst();
    }
    public T removeLast(){
        return deque.removeLast();
    }

    public int size() {
        return deque.size();
    }

    @Override
    public String toString() {
        return deque.toString();
    }

}
public class DequeTest{
    static void fillTest(Deque<Integer> deque) {
        for (int i = 0; i < 20; i++) {
            deque.addFirst(i);

        }
        for (int i = 0; i < 30; i++) {
            deque.addLast(i);
        }

    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        fillTest(deque);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.remveFirst() + " ");
        }
        System.out.println();
        fillTest(deque);

    }
}
