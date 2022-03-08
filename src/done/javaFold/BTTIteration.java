package done.javaFold;
import java.util.*;
/**
 * 
 * 二叉树的遍历
 * 
**/
class BTTIteration{

    public static void preOrderWithIteration(Node head){
        if(head == null){
            return;
        }
        Stack <Node> myStack = new Stack<>();
        myStack.add(head);
        while(!myStack.isEmpty()){
            Node outNode = myStack.pop();
            System.out.println(outNode.value + " ");
            Node leftNode = outNode.left;
            Node rightNode = outNode.right;
            if(rightNode!=null){
                myStack.push(rightNode);
            }
            if(leftNode!= null){
                myStack.push(leftNode);
            }
        }

    }

    public static void inOrderWithIteration(Node head){
        if(head == null){
            return;
        }
        Stack<Node> myStack = new Stack<>();
        Node cur = head;
        myStack.push(cur);
        while(cur.left != null || !myStack.isEmpty()){
            if(cur.left != null){
                myStack.push(cur.left);
                cur = cur.left;
            }else{
                //已经没有左侧节点可以被加入经历了
                // 可以pop节点了
                Node popNode = myStack.pop();
                System.out.print( popNode.value + " ");
                if(popNode.right != null){
                    myStack.push(popNode.right);
                    cur = popNode.right;
                }
            }     
        }
    }


    public static void postOrderWithIteration(Node head){
        if(head == null){
            return;
        }
        Stack<Node> myStack01 = new Stack<>();
        Stack<Node> myStack02 = new Stack<>();
        Node cur = head;
        myStack01.push(cur);
        while(!myStack01.isEmpty()){
            Node popNode = myStack01.pop();
            if(popNode.left!=null){
                myStack01.push(popNode.left);
            }
            if(popNode.right!=null){
                myStack01.push(popNode.right);
            }
            myStack02.push(popNode);
        }

        while(!myStack02.isEmpty()){
            System.out.print(myStack02.pop().value + " ");
        }
    }

    // 宽度优先遍历
    // good
    public static void levelTraverse(Node head){
        if(head == null){
            return;
        }
        Queue<Node> myQueue01 = new LinkedList<>();
        Queue<Node> myQueue02 = new LinkedList<>();
        Node cur = head;
        myQueue01.offer(cur);
        while(!myQueue01.isEmpty() || !myQueue02.isEmpty()){
            if(myQueue01.isEmpty()){
                myQueue01 = myQueue02;
                myQueue02 = new LinkedList<>();
            }
            Node popNode = myQueue01.poll();
            System.out.print(popNode.value + " ");
            if(popNode.left!=null){
                myQueue02.offer(popNode.left);
            }
            if(popNode.right!=null){
                myQueue02.offer(popNode.right);
            }
        }
    }

    // 只用一个栈，用计数的方式计算
    // 完美!!!,顺序也对
    public static void levelTraverseWithNum(Node head){
        if(head == null){
            return;
        }
        Queue <Node> myQueue = new LinkedList<>();
        myQueue.offer(head);
        int preLevelNum = 1;
        int nextLevelNum = 0;
        while(!myQueue.isEmpty()){
            if(preLevelNum == 0){
                preLevelNum = nextLevelNum;
            }
            Node popNode = myQueue.poll();
            System.out.print(popNode.value + " "); 
            preLevelNum --;
            if(popNode.left !=null){
                myQueue.offer(popNode.left);
                nextLevelNum ++;
            }
            if(popNode.right !=null){
                myQueue.offer(popNode.right);
                nextLevelNum ++;
            }
        }
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node (3);
        head.left.left = new Node (4);
        head.left.left.right = new Node (8);
        head.left.left.right.left = new Node (9);
        head.left.left.right.left.right = new Node (10);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        levelTraverse(head);
        System.out.println(" ");
        System.out.println("---------------------");
        levelTraverseWithNum(head);
    }

}