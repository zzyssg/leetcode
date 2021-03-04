package com.sort.algarthm.example;

/**
 * 无序链表实现优先队列
 * 特点：删除较为麻烦；插入较为方便
 * @param <T>
 */
public class C2_4_6<T extends Comparable> {
    private Node head;
    private int N = 0;

    private class Node {
        T t;
        Node next;
    }

    public void insert(T t) {
        Node newNode = new Node();
        newNode.t = t;
        newNode.next = head;
        head = newNode;

        N++;
    }

    /**
     * 遍历找到最大的node，删除
     * 记录maxNode的preNode
     * @return
     */
    public T deleteMax() {
        //创建哑结点
        Node dummyNode = new Node();
        dummyNode.next = head;
        Node preNode = dummyNode;

        //preNode - maxNode - nextNode : 找到maxNode时的情况（）
        Node maxNode = head;
        //TODO 区分dummyNode和preNode
        while (dummyNode.next.next != null) {
            if (less(maxNode, dummyNode.next.next)) {
                maxNode = dummyNode.next.next;
                preNode = dummyNode.next;
            }
            dummyNode = dummyNode.next;
        }

        //删除maxNode
        T max = maxNode.t;
        N--;
        preNode.next = maxNode.next;
        //如果maxNode 是新增的点
        if (maxNode == head) {
            head = head.next;
        }

        //打印当前堆
        return max;

    }

    public int size() {
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    private boolean less(Node maxNode, Node next) {
        return maxNode.t.compareTo(next.t) < 0;
    }

    public void printPQ() {
        Node node = head;
        while (node != null) {
            System.out.print(node.t + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        //处理字符串为字符数组
        String s = "P R I O * R * * I * T * Y * * * Q U E * * U * E";
        String[] ss = s.split(" ");
        Character[] cs = new Character[ss.length];
        for (int i = 0; i < ss.length; i++) {
            cs[i] = ss[i].charAt(0);
        }

        //调用优先队列的insert和deleteMax
        C2_4_6 pq = new C2_4_6();
        for (Character c : cs) {
            if (c == '*') {
                System.out.print("删除max： ");
                Character max = (Character) pq.deleteMax();
                System.out.print(max + " 删除后 ");
                pq.printPQ();
            }else if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                System.out.print("新增" + c + " 新增后：");
                pq.insert(c);
                pq.printPQ();
            }
            System.out.println();
        }
        System.out.println();
    }

}
