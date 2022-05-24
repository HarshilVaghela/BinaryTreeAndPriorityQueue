/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreeAndPriorityQueue;

/**
 *
 * @author Harshilkumar Vaghela,3116318
 * @date Nov 26,2020(Assignment-3)
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public interface Queue<E> {

    /**
     * Returns the number of elements in the queue.
     *
     * @return number of elements in the queue
     */
    int size();

    /**
     * Tests whether the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Inserts an element at the rear of the queue.
     *
     * @param e the element to be inserted
     */
    void enqueue(E e);

    /**
     * Returns, but does not remove, the first element of the queue.
     *
     * @return the first element of the queue (or null if empty)
     */
    E first();

    /**
     * Removes and returns the first element of the queue.
     *
     * @return element removed (or null if empty)
     */
    E dequeue();
}
