package three;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

import done.javaFold.U;
import test.graph.Node;

public class DfsGraph {

    public static void bfsGraphFun(Node node){
        if(node == null){
            return;
        }
        //ArrayList <Node> levelList = new ArrayList<>();
        LinkedList<Node> levelList = new LinkedList<>();
        HashSet<Node> nodeSet = new HashSet<>();
        nodeSet.add(node);
        levelList.offer(node);
        
        
        while(levelList.size()>0){
            int len = levelList.size();
            for(int i=0;i<len;i++){
                Node cur = levelList.poll();
                U.println("value=" + cur.value);
                for(Node next:cur.nexts){
                    if(!nodeSet.contains(next)){
                        levelList.offer(next);
                        nodeSet.add(next);
                    }
                }   
            }
        }
    }
    


    public static void dfsGraphFun(Node node){
        if(node == null){
            return;
        }
        HashSet<Node> nodeSet = new HashSet<>();
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.add(node);
        nodeSet.add(node);
        while(true){
            boolean addNew = false;
            for(Node item:node.nexts){
                U.println("size = " + nodeSet.size());
                if(!nodeSet.contains(item)){
                    nodeStack.push(item);
                    nodeSet.add(item);
                    addNew = true;
                    break;
                }
            }
            if(!addNew){
                break;
            }
        }

        while(!nodeStack.isEmpty()){
            Node cur = nodeStack.pop();
            U.println("cur.value = " + cur.value);
        }
    }
    

    public static void dfs(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		HashSet<Node> set = new HashSet<>();
		stack.add(node);
		set.add(node);
		System.out.println(node.value);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			for (Node next : cur.nexts) {
				if (!set.contains(next)) {
					stack.push(cur);
					stack.push(next);
					set.add(next);
					System.out.println(next.value);
					break;
				}
			}
		}
	}
    public static void main(String[] args){

        Node myGraph = initGraph();
        dfsGraphFun(myGraph);
        dfs(myGraph);
    }


    public static Node initGraph(){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        Node[] oneNext = {two,three,four};
        addNexts(one,oneNext);

        Node[] twoNext = {one,three,four};
        addNexts(two,twoNext);

        Node[] threeNext = {one,two,four};
        addNexts(three,threeNext);
        
        Node[] fourNext = {one,two,three};
        addNexts(three,fourNext);

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
