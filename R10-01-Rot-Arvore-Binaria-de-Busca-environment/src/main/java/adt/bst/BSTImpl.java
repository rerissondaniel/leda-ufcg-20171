package adt.bst;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

    protected BSTNode<T> root;

    public BSTImpl() {
        root = new BSTNode<T>();
    }

    public BSTNode<T> getRoot() {
        return this.root;
    }

    @Override
    public boolean isEmpty() {
        return root.isEmpty();
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(BSTNode<T> node){
        if(node.isEmpty()){
            return -1;
        }else{
            return 1 + Math.max(height((BSTNode<T>)node.getLeft()), height((BSTNode<T>)node.getRight()));
        }
    }

    @Override
    public BSTNode<T> search(T element) {
        return search(element, this.root);
    }

    private BSTNode<T> search(T element, BSTNode<T> node) {
        BSTNode<T> result = null;
        if (!node.isEmpty()) {
            if (node.getData().equals(element)) {
                result = node;
            } else if (node.getData().compareTo(element) < 0) {
                result = search(element, (BSTNode<T>) node.getLeft());
            } else if (node.getData().compareTo(element) > 0) {
                result = search(element, (BSTNode<T>) node.getLeft());
            }
        }

        return result;
    }

    @Override
    public void insert(T element) {
        this.insert(element, this.root, null);
    }

    @SuppressWarnings("unchecked")
    private void insert(T element, BSTNode<T> node, BSTNode parent) {
        if (node.isEmpty()) {
            node.setParent(parent);
            node.setData(element);
            node.setLeft(new BSTNode());
            node.setRight(new BSTNode());
        } else if (node.getData().compareTo(element) < 0) {
            insert(element, (BSTNode) node.getLeft(), node);
        } else if (node.getData().compareTo(element) > 0) {
            insert(element, (BSTNode) node.getRight(), node);
        }
    }

    @Override
    public BSTNode<T> maximum() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public BSTNode<T> minimum() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public BSTNode<T> sucessor(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public BSTNode<T> predecessor(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public void remove(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] preOrder() {
        return (T[]) preOrder(root).toArray();
    }

    private List<T> preOrder(BSTNode<T> node){
        List<T> result = new LinkedList<>();
        if(!node.isEmpty()) {
            if (node.isLeaf()) {
                result.add(node.getData());
            } else if (!node.isEmpty()) {
                result.addAll(preOrder((BSTNode<T>) node.getLeft()));
                result.addAll(preOrder((BSTNode<T>) node.getRight()));
                result.add(node.getData());
            }
        }

        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] order() {
        Comparable[] result1 = makeArrayFromList(order(root));
        return (T[]) result1;
    }

    private Comparable[] makeArrayFromList(List<T> result) {
        Comparable[] result1 = new Comparable[result.size()];
        for(int i = 0; i < result.size(); i++){
            result1[i] = result.get(i);
        }
        return result1;
    }

    private List<T> order(BSTNode<T> node){
        List<T> result = new LinkedList<>();
        if(!node.isEmpty()) {
            if (node.isLeaf()) {
                result.add(node.getData());
            } else if (!node.isEmpty()) {
                result.addAll(order((BSTNode<T>) node.getLeft()));
                result.addAll(order((BSTNode<T>) node.getRight()));
                result.add(node.getData());
            }
        }

        return result;
    }

    @Override
    public T[] postOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    /**
     * This method is already implemented using recursion. You must understand
     * how it work and use similar idea with the other methods.
     */
    @Override
    public int size() {
        return size(root);
    }

    private int size(BSTNode<T> node) {
        int result = 0;
        // base case means doing nothing (return 0)
        if (!node.isEmpty()) { // indusctive case
            result = 1 + size((BSTNode<T>) node.getLeft())
                    + size((BSTNode<T>) node.getRight());
        }
        return result;
    }

}
