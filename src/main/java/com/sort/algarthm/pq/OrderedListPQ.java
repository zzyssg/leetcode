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
        Node preNode = dummyNode;
        //找到相应位置  node1 > node > [node2]
        while (preNode.next != null && less(newNode, preNode.next)) {
            preNode = preNode.next;
        }
        newNode.next = preNode.next;
        preNode.next = newNode;

        //TODO
        // ——以上为head不变的情况下
        // ——0节点新增节点，或者新增节点为最大时修改head
        if (head == null || head == newNode.next) {
            head = newNode;
        }
        N++;
    }

    private boolean less(Node next, Node newNode) {
        return next.t.compareTo(newNode.t) < 0;
    }

    public T deleteMax() {
        T max = head.t;
        head = head.next;
        N--;
        return max;
    }

    public static void main(String[] args) {
        OrderedListPQ pq = new OrderedListPQ();
//        pq.insert(20);
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int num = random.nextInt(19) + 1;
            pq.insert(num);
            System.out.print(num + " ");
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print(pq.deleteMax() + " ");
        }
        System.out.println();
    }


}
