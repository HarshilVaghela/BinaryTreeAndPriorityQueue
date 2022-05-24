/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreeAndPriorityQueue;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Harshilkumar Vaghela,3116318
 * @param <K>
 * @param <V>
 * @date Nov 26,2020(Assignment-3)
 */
public class LinkedHeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

    /**
     * primary collection of priority queue entries
     */
    public LinkedBinaryTree<Entry<K, V>> heap = new LinkedBinaryTree<>();

    /**
     * Creates an empty priority queue based on the natural ordering of its
     * keys.
     */
    public LinkedHeapPriorityQueue() {
        super();
    }

    /**
     * Creates an empty priority queue using the given comparator to order keys.
     * @param comp
     */
    public LinkedHeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }  // protected utilities
    // truncating division

    /**
     * Exchanges the entries at indices i and j of the array list.
     * @param i
     * @param j
     */
    protected void swap(Position<Entry<K, V>> i, Position<Entry<K, V>> j) {
        Entry<K, V> temp = i.getElement();

        heap.set(i,
                j.getElement());
        heap.set(j, temp);

    }

    /**
     * Moves the entry at index j higher, if necessary, to restore the heap
     * property.
     * @param j
     */
    protected void upheap(Position<Entry<K, V>> j) {
        while (heap.parent(j) != null) { // continue until reaching root (or break statement)
            Position<Entry<K, V>> p = heap.parent(j);
            if (compare(j.getElement(), p.getElement()) >= 0) {
                break;
            } // heap property verified
            swap(j, p);
            j = p; // continue from the parent's location
        }
    }

    protected void downheap(Position<Entry<K, V>> j) {
        while (heap.left(j) != null) { // continue to bottom (or break statement)
            Position<Entry<K, V>> leftIndex = heap.left(j);
            Position<Entry<K, V>> smallChildIndex = leftIndex; // although right may be smaller
            if (heap.right(j) != null) {
                Position<Entry<K, V>> rightIndex = heap.right(j);
                if (compare(leftIndex.getElement(), rightIndex.getElement()) > 0) {
                    smallChildIndex = rightIndex;
                } // right child is smaller
            }
            if (compare(smallChildIndex.getElement(), j.getElement()) >= 0) {
                break;
            } // heap property has been restored
            swap(j, smallChildIndex);
            j = smallChildIndex; // continue at position of the child
        }
    }
    // public methods

    /**
     * Returns the number of items in the priority queue.
     */
    @Override
    public int size() {
        return heap.size();
    }

    /**
     * Returns (but does not remove) an entry with minimal key (if any).
     */
    @Override
    public Entry<K, V> min() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.root.getElement();
    }

    /**
     * Inserts a key-value pair and returns the entry created.
     */
    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key); // auxiliary key-checking method (could throw exception)
        Entry<K, V> newest = new PQEntry<>(key, value);
        int k = heap.size() + 1;
        if (heap.size() == 0) {
            heap.addRoot(newest);
        } else {
            String bin = Integer.toBinaryString(k);
            Position<Entry<K, V>> rt = heap.root();
            for (int i = 1; i < bin.length() - 1; i++) {
                rt = (bin.charAt(i) == '0' ? heap.right(rt) : heap.left(rt));
            }
            if (bin.charAt(bin.length() - 1) == '1') {
                rt = heap.addRight(rt, newest);
            } else {
                rt = heap.addLeft(rt, newest);
            } // add to the end of the list
            upheap(rt); // upheap newly added entry
        }
        return newest;
    }

    /**
     * Removes and returns an entry with minimal key (if any).
     */
    @Override
    public Entry<K, V> removeMin() {
        if (heap.isEmpty()) {
            return null;
        } else if (heap.size() == 1) {
            Entry<K, V> answer = heap.root().getElement();
            heap.remove(heap.root);
            return answer;
        } else {
            int k = heap.size();

            String bin = Integer.toBinaryString(k);
            Position<Entry<K, V>> rt = heap.root();
            for (int i = 1; i < bin.length() - 1; i++) {
                rt = (bin.charAt(i) == '0' ? heap.right(rt) : heap.left(rt));
            }
            if (bin.charAt(bin.length() - 1) == '1') {
                rt = heap.right(rt);
            } else {
                rt = heap.left(rt);
            }
            Entry<K, V> answer = heap.root().getElement();
            swap(heap.root, rt);
            heap.remove(rt);
            downheap(heap.root);
            return answer;
        }
    }

    private void preorderSubtree(Position<Entry<K, V>> p, List<Position<Entry<K, V>>> snapshot) {
        snapshot.add(p); // for preorder, we add position p before exploring subtrees
        for (Position<Entry<K, V>> c : heap.children(p)) {
            preorderSubtree(c, snapshot);
        }
    }

    public Iterable<Position<Entry<K, V>>> preorder() {
        List<Position<Entry<K, V>>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            preorderSubtree(heap.root(), snapshot); // fill the snapshot recursively
        }
        return snapshot;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Position<Entry<K, V>> p : this.preorder()) {
            sb.append(p.getElement().getKey() + "   ");
        }
        return sb.toString();
    }
}
