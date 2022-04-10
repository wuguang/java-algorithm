package three;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import done.javaFold.U;
import test.graph.Node;

public class TopologicalOrder {

    public static void topOrderfunBfs(Node start){
        HashSet<Node> overSet = new HashSet<>();
        Queue<Node> sortList = new LinkedList<>();
        sortList = orderFun(sortList,overSet,start);

        while(!sortList.isEmpty()){
            Node cur = sortList.poll();
            U.println("cur.value=" + cur.value);
        }

    }

    public static Queue<Node> orderFun(Queue<Node> sortList,HashSet<Node> overSet, Node start){
        sortList.offer(start);
        overSet.add(start);
        Node nextTarget  = null;
        for(Node next:start.nexts){
            if(!overSet.contains(next)){
                next.in -= 1;
                if(next.in == 0){
                    nextTarget = next;
                }
            }
        }
        if(nextTarget!=null){
            orderFun(sortList,overSet,nextTarget);
        }
        return sortList;
    }
    
    public static void main(String[] args){
        Node one = initGraph();
        topOrderfunBfs(one);
    }


    public static Node initGraph(){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        Node[] oneNext = {two};
        addNexts(one,oneNext);
        one.in = 0;
        one.out = 1;

        Node[] twoNext = {three,four,five};
        addNexts(two,twoNext);
        two.in = 1;
        two.out = 3;

        Node[] threeNext = {five};
        addNexts(three,threeNext);
        three.in = 2;
        three.out = 1;
        
        Node[] fourNext = {three,five};
        addNexts(four,fourNext);
        four.in = 1;
        four.out = 2;

        five.in = 3;

        return one;
    }

    public static void addNexts(Node node,Node[] nodeList){
        ArrayList<Node> nextList = new ArrayList<>();
        for(Node next:nodeList){
            nextList.add(next);
        }
        node.nexts = nextList;
    }

}
