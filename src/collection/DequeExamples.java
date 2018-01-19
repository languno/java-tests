package collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Examples of Deque interface implementations.
 *
 * @author Tino Ernst
 */
public class DequeExamples {
    public static void main(String[] args) {

        /* Deque:
         *      A linear collection that supports element insertion and removal at both ends.
         *      can be used to as stack
         *      no index based access to elements
         */

        /* LinkedList:
         *      uses list implementation
         *      more flexible then ArrayDeque
         */
        Deque<String> linkedList = new LinkedList<>();
        fillDeque(linkedList);
        System.out.println("LinkedList: " + linkedList);
        cleanDeque(linkedList);

        /* ArrayDeque:
         *      uses resizable array implementation
         *      faster then LinkedList
         */
        Deque<String> arrayDeque = new ArrayDeque<>();
        fillDeque(arrayDeque);
        System.out.println("ArrayDeque: " + arrayDeque);
        cleanDeque(arrayDeque);

        /* LinkedBlockingDeque:
         *      concurrent implementation of the Deque interface
         *      takeFirst, takeLast and so on will block until element is retrieved
         */
        Deque<String> linkedBlockingDeque = new LinkedBlockingDeque<>();
        fillDeque(linkedBlockingDeque);
        System.out.println("LinkedBlockingDeque: " + linkedBlockingDeque);
        cleanDeque(linkedBlockingDeque);
    }

    public static void fillDeque(Deque<String> deque) {
        deque.push("one");
        deque.push("two");
        deque.push("three");
    }

    public static void cleanDeque(Deque<String> deque) {
        while (!deque.isEmpty()) {
            System.out.println(deque.pop());
        }
    }
}
