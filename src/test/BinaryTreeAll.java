package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import done.javaFold.U;

public class BinaryTreeAll {
    public static int getLeafNodes(Node head){
        if(head == null){
            return 0;
        }
        int leftNum = 0; 
        int rightNum = 0; 
        if(head.left == null && head.right == null){
            return 1;
        }else{
            if(head.left!=null){
                leftNum = getLeafNodes(head.left);
            }
            if(head.right!=null){
                rightNum = getLeafNodes(head.right);
            }
        }
        return leftNum + rightNum;
    }

    /*
给定一个 n 叉树的根节点 root ，返回 其节点值的 后序遍历 。

n 叉树 在输入中【按层序遍历进行序列化】表示，每组子节点由空值 null 分隔（请参见示例）。
【按层序遍历进行序列化】=>宽度优先排列的
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
输入：root = [1,null,3,2,4,null,5,6]
输出：[5,6,3,2,4,1]

输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]

    */

    class MutiNode {
        public int val;
        public List<MutiNode> children;
    
        public MutiNode() {}
    
        public MutiNode(int _val) {
            val = _val;
        }
    
        public MutiNode(int _val, List<MutiNode> _children) {
            val = _val;
            children = _children;
        }
    };

    // 递归
    public static List<Integer> getPostOrderArr(MutiNode head){
        MutiNode cur = head;
        if(cur.children !=null){
            Iterator<MutiNode> c = cur.children.iterator();
            List<Integer> myList = new ArrayList<>();
            while(c.hasNext()){
                MutiNode child = c.next();
                //深度优先遍历
                myList.addAll(getPostOrderArr(child));
            }
            return myList;
        }else{
            List<Integer> list = new ArrayList<>();
            list.add(cur.val);
            return list;
        }
    }

     // 迭代后续遍历
     public static List<Integer> getPostOrderWithItration(MutiNode head){
        if(head == null ){
            return null;
        }
        List<Integer> targetList = new ArrayList<>();
        Stack<MutiNode> standbyStack = new Stack<>();
        Stack<MutiNode> popStack = new Stack<>();
        standbyStack.add(head);
        while(!standbyStack.isEmpty() ||!popStack.isEmpty()){
            if(!standbyStack.isEmpty()){
                MutiNode cur = standbyStack.pop();
                popStack.add(cur);
                if(cur.children != null){
                    Iterator<MutiNode> c = cur.children.iterator();
                    while(c.hasNext()){
                        //将前一个子节点全部添加进去
                        standbyStack.add(c.next());
                    }
                }

            }else{
                // standbyStack 子弹用尽
                targetList.add(popStack.pop().val);
            }
        }
        return targetList;
    }

/*
给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，并且总共有 N 枚硬币。

在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。(移动可以是从父结点到子结点，或者从子结点移动到父结点。)。

返回使每个结点上只有一枚硬币所需的移动次数。

 
链接：https://leetcode-cn.com/problems/distribute-coins-in-binary-tree

*/

    public static int distributeCoins(TreeNode root) {
        if(root == null){
            return 0;
        }
        int num = 0;
        if(root.left !=null){
            distributeCoins(root.left);
        }
        if(root.right != null){
            distributeCoins(root.right);
        }

        return 0;
    }

    public static int getNumFromNode(TreeNode root,int num){
    
        if(root.left == null && root.right == null){
            num += Math.abs(root.val-1);
            return root.val-1;
        }else{
            if(root.left !=null){
                num += getNumFromNode(root.left,num);
            }
            if(root.right != null){
                num += getNumFromNode(root.right,num);
            }
        }

        return num;
    }


    public static class NodeInfo{
        Integer val;
        int num = 0;
        NodeInfo(int val,int num){
            this.val = val;
            this.num = num;
        }
    }

    public static int distributeCoins02(TreeNode root) {
        if(root == null){
            return 0;
        }
        NodeInfo info = getNodeInfo(root);
        return info.num;
    }

    public static NodeInfo getNodeInfo(TreeNode root){
        NodeInfo leftInfo = null;
        NodeInfo rightInfo = null;
        int val = root.val;
        int num = 0;
        if(root.left != null){
            leftInfo = getNodeInfo(root.left);
            val += (leftInfo.val-1);
            num += Math.abs(leftInfo.val-1);
        }
        if(root.right != null){
            rightInfo = getNodeInfo(root.right);
            val += (rightInfo.val-1);
            num += Math.abs(rightInfo.val-1);
        }

        return new NodeInfo(val,num);
    }



    public static void main(String[] args){
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.left.left = new Node(5);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);
        tree.left.left.right = new Node(8);

        int num = getLeafNodes(tree);

        U.print("num=" + num);
        TreeNode tree01 = new TreeNode(0);
        tree01.left = new TreeNode(3);
        tree01.right = new TreeNode(0);
        
        int target = distributeCoins02(tree01);
        U.print("target=" + target);
    }
}
