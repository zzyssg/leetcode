package com.sort.algarthm.pq;

import java.util.Random;

/**
 * 有序链表实现优先队列--删除时，直接删除头结点；添加时，按照大小添加，较大数据在前面
 * @param <T>
 */
public class OrderedListPQ <T extends Comparable>{
    private Node head;
    private int N = 0;

    class Node{
        T t;
        Node next;
    }

    public void insert(T t) {
        Node newNode = new Node();
        newNode.t = t;

        Node dummyNode = new Node();
        dummyNode.next = head;

        while (dummyNode.next != null && less(newNode, dummyNode.next)) {
            dummyNode = dummyNode.next;
        }
        newNode.next = dummyNode.next;
        dummyNode.next = newNode;

        //TODO 原本为空 或者 新增节点为最大节点
        if (head == null || head == newNode.next) {
            head = newNode;
        }

        N++;

    }

    private boolean less(Node newNode, Node next) {
        return newNode.t.compareTo(next.t) < 0;
    }

    public T deleteMax() {
        T max = head.t;
        head = head.next;
        N--;
        return max;
//        Node maxNode = head;
//        head = head.next;
//        T max = maxNode.t;
//        N--;
//        return max;

    }



    public static void main(String[] args) {
        OrderedListPQ pq = new OrderedListPQ();
        String s = "EASYQUESTION";
        Character[] cs = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cs[i] = s.charAt(i);
        }
        System.out.println(cs.length);
        for (int i = 0; i < cs.length; i++) {
            System.out.print(cs[i] + " ");
            pq.insert(cs[i]);
        }
        System.out.println();
        for (int i = 0; i < cs.length; i++) {
            System.out.print(pq.deleteMax() + " ");
        }
        System.out.println();
    }


}
