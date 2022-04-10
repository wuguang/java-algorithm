package three;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import done.javaFold.U;
import test.graph.Graph;
import test.graph.Node;

public class TopologicalOrder {

    public static void topOrderfunBfs(Graph myGraph){
        Queue<Node> sortList = new LinkedList<>();
        Queue<Node> zeroInNodes = new LinkedList<>(); 

        for(Node node : myGraph.nodes.values()){
            if(node.in == 0){
                zeroInNodes.add(node);
            }
        }

        while(!zeroInNodes.isEmpty()){
            orderFun(sortList,zeroInNodes);
        }

        while(!sortList.isEmpty()){
            Node cur = sortList.poll();
            U.println("cur.value=" + cur.value);
        }

    }

    public static Queue<Node> orderFun(Queue<Node> sortList, Queue<Node>  zeroInNodes){
        while(!zeroInNodes.isEmpty()){
            Node cur = zeroInNodes.poll();
            sortList.offer(cur);
            for(Node next: cur.nexts){
                next.in -= 1;
                if(next.in == 0){
                    zeroInNodes.offer(next);
                }
            }
        }
        return sortList;
    }
    
    public static void main(String[] args){
        Graph myGraph = initGraph();
        topOrderfunBfs(myGraph);
    }


    public static Graph initGraph(){
        Graph myGraph = new Graph();
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        myGraph.nodes.put(1,one);
        myGraph.nodes.put(2,two);
        myGraph.nodes.put(3,three);
        myGraph.nodes.put(4,four);
        myGraph.nodes.put(5,five);

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



        return myGraph;
    }

    public static void addNexts(Node node,Node[] nodeList){
        ArrayList<Node> nextList = new ArrayList<>();
        for(Node next:nodeList){
            nextList.add(next);
        }
        node.nexts = nextList;
    }

}
