/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreesAndPriorityQueue;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Harshilkumar Vaghela,3116318
 * @param <E>
 * @date Nov 26,2020(Assignment-3)
 */
public abstract class AbstractTree<E> implements Tree<E> {

    private class ElementIterator implements Iterator<E> {

        Iterator<Position<E>> posIterator = positions().iterator();

        @Override
        public boolean hasNext() {
            return posIterator.hasNext();
        }

        @Override
        public E next() {
            return posIterator.next().getElement();
        } // return element!

        @Override
        public void remove() {
            posIterator.remove();
        }
    }

    /**
     * Returns an iterator of the elements stored in the tree.
     * @return 
     */
    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    public Iterable<Position<E>> preorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            preorderSubtree(root(), snapshot); // fill the snapshot recursively
        }
        return snapshot;
    }

    public Iterable<Position<E>> postorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            postorderSubtree(root(), snapshot); // fill the snapshot recursively
        }
        return snapshot;
    }

    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p); // for preorder, we add position p before exploring subtrees
        for (Position<E> c : children(p)) {
            preorderSubtree(c, snapshot);
        }
    }

    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> c : children(p)) {
            postorderSubtree(c, snapshot);
        }
        snapshot.add(p); // for postorder, we add position p after exploring subtrees
    }

    public Iterable<Position<E>> breadthfirst() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            Queue<Position<E>> fringe = new ArrayQueue<>();
            fringe.enqueue(root()); // start with the root
            while (!fringe.isEmpty()) {
                Position<E> p = fringe.dequeue(); // remove from front of the queue
                snapshot.add(p); // report this position
                for (Position<E> c : children(p)) {
                    fringe.enqueue(c); // add children to back of queue
                }
            }
        }
        return snapshot;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return breadthfirst();
    }

    @Override
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    @Override
    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    @Override
    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public int depth(Position<E> p) {
        if (isRoot(p)) {
            return 0;
        } else {
            return 1 + depth(parent(p));
        }
    }

    public int height(Position<E> p) {
        int h = 0; // base case if p is external
        for (Position<E> c : children(p)) {
            h = Math.max(h, 1 + height(c));
        }
        return h;
    }

    public static String spaces(int l) {
        String k = "";
        for (int i = 0; i < l; i++) {
            k = k + " ";
        }
        return k;
    }

    public static <E> void printPreorderIndent(Tree<E> T, Position<E> p, int d) {
        System.out.println(spaces(2 * d) + p.getElement()); // indent based on d
        for (Position<E> c : T.children(p)) {
            printPreorderIndent(T, c, d + 2); // child depth is d+1
        }
    }

}
