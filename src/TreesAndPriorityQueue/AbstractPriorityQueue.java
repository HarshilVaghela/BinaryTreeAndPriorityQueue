/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreesAndPriorityQueue;

import java.util.Comparator;

/**
 *
 * @author Harshilkumar Vaghela,3116318
 * @param <K>
 * @param <V>
 * @date Nov 26,2020(Assignment-3)
 */
public abstract class AbstractPriorityQueue<K, V>
        implements PriorityQueue<K, V> {  //---------------- nested PQEntry class ----------------

    protected static class PQEntry<K, V> implements Entry<K, V> {

        private K k; // key
        private V v; // value

        public PQEntry(K key, V value) {
            k = key;
            v = value;
        }  // methods of the Entry interface

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }  // utilities not exposed as part of the Entry interface

        protected void setKey(K key) {
            k = key;
        }

        protected void setValue(V value) {
            v = value;
        }
    } //----------- end of nested PQEntry class -----------

    // instance variable for an AbstractPriorityQueue
    /**
     * The comparator defining the ordering of keys in the priority queue.
     */
    private Comparator<K> comp;

    /**
     * Creates an empty priority queue using the given comparator to order keys.
     * @param c
     */
    protected AbstractPriorityQueue(Comparator<K> c) {
        comp = c;
    }

    /**
     * Creates an empty priority queue based on the natural ordering of its
     * keys.
     */
    protected AbstractPriorityQueue() {
        this(new DefaultComparator<K>());
    }

    /**
     * Method for comparing two entries according to key
     * @param a
     * @param b
     * @return 
     */
    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }

    /**
     * Determines whether a key is valid.
     * @param key
     * @return 
     */
    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return (comp.compare(key, key) == 0); // see if key can be compared to itself
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    /**
     * Tests whether the priority queue is empty.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

}
