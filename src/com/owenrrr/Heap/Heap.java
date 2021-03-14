package com.owenrrr.Heap;

import java.util.*;

/**
 * @Author: Owen
 * @Date: 2021/3/14 10:44
 * @Description:
 */
public class Heap {

    public Node[] heaps;

    public Heap(){}

    public Heap(Node[] heaps, boolean isMaxHeaps){
        if (isMaxHeaps){
            Arrays.sort(heaps, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.value >= o2.value ? -1 : 1;
                }
            });
            System.out.print("maxHeap: ");
        }else{
            Arrays.sort(heaps, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.value < o2.value ? -1 : 1;
                }
            });
            System.out.print("minHeap: ");
        }

        Queue<Node> queue = new LinkedList<>();
        List<Node> dynamicList = new ArrayList<>();
        Node node;
        queue.add(heaps[0]);
        while (!queue.isEmpty()){
            node = queue.poll();
            dynamicList.add(node);
            if (node.leftChild != null){
                queue.add(node.leftChild);
            }
            if (node.rightChild != null){
                queue.add(node.rightChild);
            }
        }
        this.heaps = new Node[dynamicList.size()];
        dynamicList.toArray(this.heaps);
    }


    public static class Node{
        public Integer value;
        public Node leftChild;
        public Node rightChild;

        public Node(Integer value){
            this.value = value;
        }

        public Node(Integer value, Node leftChild, Node rightChild){
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public void print(){
            System.out.print(this.value + " ");
        }
    }

    public void printHeaps(){
        for (Node n: this.heaps){
            System.out.print(n.value + " ");
        }
    }
}
