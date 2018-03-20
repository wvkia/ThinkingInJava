package QueuePackage;

import FullCollection.Generator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class QueueBehavior {
    private static int count=3;

    static <T> void test(Queue<T> queue, Generator<T> generator) {
        for (int i = 0; i < count; i++) {
            queue.offer(generator.next());

        }
        while (queue.peek() != null) {
            System.out.println(queue.remove() + " ");
        }
        System.out.println("=====================================");

    }

    static class Gen implements Generator<String> {
        String[] s="one two three".split(" ");
        int i;

        @Override
        public String next() {
            return s[i++];
        }
    }

    public static void main(String[] args) {
        test(new LinkedList<>(), new Gen());
        test(new PriorityQueue<>(), new Gen());
        test(new ArrayBlockingQueue<String>(count), new Gen());
        test(new ConcurrentLinkedQueue<>(), new Gen());
        test(new LinkedBlockingQueue<>(), new Gen());
        test(new PriorityBlockingQueue<>(), new Gen());
    }
}
