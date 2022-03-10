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
                Node leftNode = cur.left;
                Node rightEst = leftNode;
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
                    // 后续遍历在，拆掉逃生通道之后，离开该节点去往有节点之前，逆序打印当前节点的左节点
                    reversePrint(leftNode);
                    // 往右走
                    cur = cur.right;
                }
            }else{
                // 往最右走一步
                cur = cur.right;
            }
        }
        reversePrint(head);
    }

    public static Node reverseRightNode(Node node){
        //leftNode
        Node pre = node;
        Node cur = node.right;
        pre.right = null;
        while(cur != null){
            Node nextRight = cur.right;
            //交换指针
            cur.right = pre;

            //更新节点位置
            pre = cur;
            cur = nextRight;
        }

        return pre;
    }

    public static void reversePrint(Node node){
        Node newNode = reverseRightNode(node);
        Node cur = newNode;
        while(cur!=null){
            print(cur.value + " ");
            cur = cur.right;
        }
        //复原 原来的节点指针
        reverseRightNode(newNode);
    }
    //15804395

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

    public static void postOrderIteration(Node head){
        if(head == null){
            return;
        }
        Stack<Node> s = new Stack<>();
        Stack<Node> reversStack = new Stack<>();
        s.push(head);

        while(!s.isEmpty()  ){
            Node cur = s.pop();
            reversStack.push(cur);
            if(cur.left != null){
                s.push(cur.left);
            }
            if(cur.right != null){
                s.push(cur.right);
            }
        }

        while(!reversStack.isEmpty()){
            System.out.print(reversStack.pop().value + " ");
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
        morrisForPostOrder(tree);
        println(" ");
        postOrderIteration(tree);
    }
}
