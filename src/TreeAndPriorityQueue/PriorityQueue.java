/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreeAndPriorityQueue;

/**
 *
 * @author Harshilkumar Vaghela,3116318
 * @param <K>
 * @param <V>
 * @date Nov 26,2020(Assignment-3)
 */
public interface PriorityQueue<K,V> {

  /**
   * Returns the number of items in the priority queue.
   * @return number of items
   */
  int size();

  /**
   * Tests whether the priority queue is empty.
   * @return true if the priority queue is empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Inserts a key-value pair and returns the entry created.
   * @param key     the key of the new entry
   * @param value   the associated value of the new entry
   * @return the entry storing the new key-value pair
   * @throws IllegalArgumentException if the key is unacceptable for this queue
   */
  Entry<K,V> insert(K key, V value) throws IllegalArgumentException;

  /**
   * Returns (but does not remove) an entry with minimal key.
   * @return entry having a minimal key (or null if empty)
   */
  Entry<K,V> min();

  /**
   * Removes and returns an entry with minimal key.
   * @return the removed entry (or null if empty)
   */
  Entry<K,V> removeMin();
}

