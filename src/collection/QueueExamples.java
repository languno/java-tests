package collection;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Examples of Queue interface implementations.
 *
 * @author Tino Ernst
 */
public class QueueExamples {
    public static void main(String[] args) {

        /* LinkedList:
         *      provides FIFO queue operations
         */
        Queue<String> linkedList = new LinkedList<>();
        fillQueue(linkedList);
        System.out.println("LinkedList: " + linkedList);
        cleanQueue(linkedList);

        /* PriorityQueue:
         *      FIFO with natural ordering or via comparator
         */
        Queue<String> priorityQueue = new PriorityQueue<>();
        fillQueue(priorityQueue);
        System.out.println("PriorityQueue: " + priorityQueue);
        cleanQueue(priorityQueue);
    }

    private static void fillQueue(Queue<String> queue) {
        queue.add("one");
        queue.add("two");
        queue.add("three");
    }

    private static void cleanQueue(Queue<String> queue) {
        while (!queue.isEmpty()) {
            String s = queue.poll();
            System.out.println(s);
        }
    }
}
