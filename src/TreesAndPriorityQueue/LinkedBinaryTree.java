/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreesAndPriorityQueue;

/**
 *
 * @author Harshilkumar Vaghela,3116318
 * @param <E>
 * @date Nov 26,2020(Assignment-3)
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    //---------------- nested Node class ----------------

    protected static class Node<E> implements Position<E> {

        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        @Override
        public E getElement() {
            return element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setElement(E e) {
            element = e;
        }

        public void setParent(Node<E> parentNode) {
            parent = parentNode;
        }

        public void setLeft(Node<E> leftChild) {
            left = leftChild;
        }

        public void setRight(Node<E> rightChild) {
            right = rightChild;
        }
    }

    protected Node<E> createNode(E e, Node<E> parent,
            Node<E> left, Node<E> right) {
        return new Node<>(e, parent, left, right);
    }

    protected Node<E> root = null;
    private int size = 0;

    public LinkedBinaryTree() {
    }

    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Not valid position type");
        }
        Node<E> node = (Node<E>) p;
        if (node.getParent() == node) {
            throw new IllegalArgumentException("p is no longer in the tree");
        }
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException("Tree is not empty");
        }
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    public Position<E> addLeft(Position<E> p, E e)
            throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null) {
            throw new IllegalArgumentException("p already has a left child");
        }
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    public Position<E> addRight(Position<E> p, E e)
            throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null) {
            throw new IllegalArgumentException("p already has a right child");
        }
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(p) == 2) {
            throw new IllegalArgumentException("p has two children");
        }
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if (child != null) {
            child.setParent(node.getParent());
        }
        if (node == root) {
            root = child;
        } else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft()) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }
        size--;
        E temp = node.getElement();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);
        return temp;
    }

    public void attach(Position<E> p, LinkedBinaryTree<E> t1,
            LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (isInternal(p)) {
            throw new IllegalArgumentException("p must be a leaf");
        }
        size += t1.size() + t2.size();
        if (!t1.isEmpty()) { // attach t1 as left subtree of node
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if (!t2.isEmpty()) { // attach t2 as right subtree of node
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Position<E> p : this.positions()) {
            sb.append(p.getElement() + "\n");
        }
        
        return sb.toString();
      
    }
}
