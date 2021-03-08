package com.sort.algarthm.example;

/**
 * 有序链表 实现有序符号表
 * @param <Key>
 * @param <Val>
 */
public class C_3_1_3<Key extends Comparable<Key>, Val>{
    private int N;
    private Node head;

    class Node{

        Key key;
        Val val;
        Node next;

    }

    /**
     * 插入时注意：
     * 1-排序
     * 2-是否已经存在
     * @param key
     * @param val
     */
    public void put(Key key, Val val) {
        //找到要插入的位置，同时记录preNode
        Node dummyNode = new Node();
        dummyNode.next = head;
        Node preNode = dummyNode;
        Node curNode = head;
        // preNode - curNode
        while (preNode.next.next != null) {
            if (preNode.next.key.equals(key)) {
                curNode = preNode.next;
                break;
            }
            preNode = preNode.next;
        }

    }

    public Val get(Key key) {

    }

    public void delete(Key key) {

    }

    public boolean contains(Key key) {
        Node node = head;
        while (node != null) {
            if (node.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Iterable<Key> keys() {

    }

}
