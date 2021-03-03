package com.sort.algarthm.pq;

import java.util.Random;

public class UnorderedListPQ<T extends Comparable> {

    protected class Node {
        T t;
        Node next;
    }

    private Node head;
    private int N;

    public void insert(T t) {
        Node node = new Node();
        node.t = t;
        node.next = head;
        head = node;

        N++;
    }

    public T deleteMax() {
        //定位最大点，断开连接   preNode-maxNode-curNode
        Node dummyNode = new Node();
        dummyNode.next = head;
        Node maxNode = head;
        Node preNode = dummyNode;
        while (dummyNode.next.next != null) {
            if (less(maxNode, dummyNode.next.next)) {
                maxNode = dummyNode.next.next;
                preNode = dummyNode.next;
            }
            dummyNode = dummyNode.next;
        }
        //
        T max = maxNode.t;
        preNode.next = maxNode.next;
        //TODO 若恰好头结点为最大节点
        // ——head 可能改变
        if (head == maxNode) {
            head = maxNode.next;
        }
//        maxNode.next = null;
        maxNode = null;
        N--;
        return max;

    }

    private boolean less(Node maxNode, Node curNode) {
        return maxNode.t.compareTo(curNode.t) < 0;
    }

    public static void main(String[] args) {

        UnorderedListPQ pq = new UnorderedListPQ();
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
