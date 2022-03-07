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
    public static void levelTraverse(Node head){
        if(head == null){
            return;
        }
        Stack<Node> preStack = new Stack<>();
        Stack<Node> nextStack = new Stack<>();
        preStack.push(head);
        //计数pop
        while(!preStack.isEmpty() || !nextStack.isEmpty()){
            if(!preStack.isEmpty()){
                Node popNode = preStack.pop();
                System.out.print(popNode.value + " ");
                if(popNode.right != null){
                    nextStack.push(popNode.right);
                }
                if(popNode.left != null){
                    nextStack.push(popNode.left);
                }
            }else{
                // 切换主题，继续pop()
                preStack = nextStack;
                nextStack = new Stack<>();
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
    }

}