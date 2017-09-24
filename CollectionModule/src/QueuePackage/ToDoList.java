package QueuePackage;

import java.util.PriorityQueue;

public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {
    static class ToDoItem implements Comparable<ToDoItem> {
        private char primary;
        private int secondary;
        private String item;

        public ToDoItem(char primary, int secondary, String item) {
            this.primary = primary;
            this.secondary = secondary;
            this.item = item;
        }

        @Override
        public int compareTo(ToDoItem o) {
            if (primary > o.primary) {
                return 1;
            }
            if (primary == o.primary) {
                if (secondary > o.secondary) {
                    return 1;
                } else if (secondary == o.secondary) {
                    return 0;
                }

            }
            return -1;
        }

        @Override
        public String toString() {
            return Character.toString(primary) + secondary + ": "+item;
        }
    }

    public void add(String id, char pri, int sec) {
        super.add(new ToDoItem(pri,sec,id));
    }

    public static void main(String[] args) {
        ToDoList doItems = new ToDoList();
        doItems.add("A", 'a', 1);
        doItems.add("C", 'a', 2);
        doItems.add("A",'b',4);
        while (!doItems.isEmpty()) {
            System.out.println(doItems.remove());
        }
    }
}
