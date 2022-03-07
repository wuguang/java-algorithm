package done.javaFold;
import java.util.Stack;
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
        Stack<Node> myStack = new Stack<>();
        Node cur = head;
        myStack.push(cur);
        while(cur !=null){
            /*
            2个栈实现
            if(cur.right != null){
                myStack.push(cur.right);
                cur = cur.right;
                continue;
            };

            if(cur.left != null){
                myStack.push(cur.left);
                cur = cur.left;
            }
            */
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
        inOrderWithIteration(head);
    }

}