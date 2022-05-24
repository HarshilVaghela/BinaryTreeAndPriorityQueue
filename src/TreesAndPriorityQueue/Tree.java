/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreesAndPriorityQueue;

import java.util.Iterator;

/**
 *
 * @author Harshilkumar Vaghela,3116318
 * @param <E>
 * @date Nov 26,2020(Assignment-3)
 */
public interface Tree<E> extends Iterable<E> {

    /**
     * Returns the root Position of the tree (or null if tree is empty).
     *
     * @return root Position of the tree (or null if tree is empty)
     */
    Position<E> root();

    /**
     * Returns the Position of p's parent (or null if p is root).
     *
     * @param p A valid Position within the tree
     * @return Position of p's parent (or null if p is root)
     * @throws IllegalArgumentException if p is not a valid Position for this
     * tree.
     */
    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns an iterable collection of the Positions representing p's
     * children.
     *
     * @param p A valid Position within the tree
     * @return iterable collection of the Positions of p's children
     * @throws IllegalArgumentException if p is not a valid Position for this
     * tree.
     */
    Iterable<Position<E>> children(Position<E> p)
            throws IllegalArgumentException;

    /**
     * Returns the number of children of Position p.
     *
     * @param p A valid Position within the tree
     * @return number of children of Position p
     * @throws IllegalArgumentException if p is not a valid Position for this
     * tree.
     */
    int numChildren(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns true if Position p has one or more children.
     *
     * @param p A valid Position within the tree
     * @return true if p has at least one child, false otherwise
     * @throws IllegalArgumentException if p is not a valid Position for this
     * tree.
     */
    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns true if Position p does not have any children.
     *
     * @param p A valid Position within the tree
     * @return true if p has zero children, false otherwise
     * @throws IllegalArgumentException if p is not a valid Position for this
     * tree.
     */
    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns true if Position p represents the root of the tree.
     *
     * @param p A valid Position within the tree
     * @return true if p is the root of the tree, false otherwise
     * @throws IllegalArgumentException if p is not a valid Position for this
     * tree.
     */
    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the number of nodes in the tree.
     *
     * @return number of nodes in the tree
     */
    int size();

    /**
     * Tests whether the tree is empty.
     *
     * @return true if the tree is empty, false otherwise
     */
    boolean isEmpty();

    Iterator<E> iterator();

    Iterable<Position<E>> positions();
}
