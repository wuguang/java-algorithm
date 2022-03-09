package done.javaFold;

import java.util.Stack;

public class Morris {
    public static void morrisForPreOrder(Node head){
        Node cur = head;
        while(cur!=null){    
            if(cur.left != null){
                Node rightEst = cur.left;
                // 找出最右节点,
                // 第一次一定会找到最右节点
                // 如果是圈，将出错
                while(rightEst.right!=null && rightEst.right != cur){
                    rightEst = rightEst.right;
                }
                // 判断while条件是怎么中断的
                // 第一次建立逃生通道
                if(rightEst.right==null){
                    // 建立cur和最右节点的逃生通道
                    rightEst.right = cur;
                    System.out.print( cur.value + " ");
                    // 往左走一步
                    cur = cur.left;
                }else{
                    // 拆掉逃生通道
                    rightEst.right = null;
                    // 往右走
                    cur = cur.right;
                }
            }else{
                System.out.print( cur.value + " ");
                // 往最右走一步
                cur = cur.right;
            }
        }
    }

    public static void morrisForInOrder(Node head){
        Node cur = head;
        while(cur!=null){    
            if(cur.left != null){
                Node rightEst = cur.left;
                // 找出最右节点,
                // 第一次一定会找到最右节点
                // 如果是圈，将出错
                while(rightEst.right!=null && rightEst.right != cur){
                    rightEst = rightEst.right;
                }
                // 判断while条件是怎么中断的
                // 第一次建立逃生通道
                if(rightEst.right==null){
                    // 建立cur和最右节点的逃生通道
                    rightEst.right = cur;
                    // 往左走一步
                    cur = cur.left;
                }else{
                    // 拆掉逃生通道
                    rightEst.right = null;
                    System.out.print( cur.value + " ");
                    // 往右走
                    cur = cur.right;
                }
            }else{
                System.out.print( cur.value + " ");
                // 往最右走一步
                cur = cur.right;
            }
        }
    }


    
    public static void morrisForPostOrder(Node head){
        Node cur = head;
        while(cur!=null){    
            if(cur.left != null){
                Node rightEst = cur.left;
                // 找出最右节点,
                // 第一次一定会找到最右节点
                // 如果是圈，将出错
                while(rightEst.right!=null && rightEst.right != cur){
                    rightEst = rightEst.right;
                }
                // 判断while条件是怎么中断的
                // 第一次建立逃生通道
                if(rightEst.right==null){
                    // 建立cur和最右节点的逃生通道
                    rightEst.right = cur;
                    // 往左走一步
                    cur = cur.left;
                }else{
                    // 拆掉逃生通道
                    rightEst.right = null;
                    System.out.print( cur.value + " ");
                    // 往右走
                    cur = cur.right;
                }
            }else{
                System.out.print( cur.value + " ");
                // 往最右走一步
                cur = cur.right;
            }
        }
    }

    public static void print(String str){
        System.out.print(str);
    }

    public static void println(String str){
        System.out.println(str);
    }

    
    public static void preOrderWithIteration(Node head){
        if(head == null){
            return;
        }
        Stack <Node> myStack = new Stack<>();
        myStack.add(head);
        while(!myStack.isEmpty()){
            Node outNode = myStack.pop();
            System.out.print(outNode.value + " ");
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

    public static void main(String[] args){
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.left.left = new Node(5);
        tree.left.left.left.left = new Node(6);
        tree.left.left.left.left.right = new Node(7);
        tree.left.left.left.left.right.right = new Node(8);
        tree.left.right = new Node(9);
        tree.left.right.right = new Node(10);
        tree.left.right.right.right = new Node(11);
        tree.left.right.right.right.right = new Node(12);
        tree.left.right.right.right.right.left = new Node(13);
        tree.left.right.right.right.right.left.left = new Node(14);
        morrisForInOrder(tree);
        println(" ");
        inOrderWithIteration(tree);
    }
}
