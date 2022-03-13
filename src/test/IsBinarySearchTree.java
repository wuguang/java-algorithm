package test;

import java.util.*;

import javax.swing.text.StyledEditorKit;

import done.javaFold.U;

public class IsBinarySearchTree {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    // 中序遍历， 升序的结果
    static public class Solution {
        Integer preNode = null;

        public boolean isValidBST(TreeNode root) {
            if(root == null){
                return true;
            }
            Boolean leftResult = true;
            Boolean rightResult = true;

            leftResult = isValidBST(root.left);

            if(this.preNode == null){
                this.preNode = root.val;
            }else{
                if(root.val <= this.preNode){
                    return false;
                }else{
                    this.preNode = root.val;
                }
            }
            rightResult = isValidBST(root.right);
            return leftResult && rightResult;
        }
        //[-2147483648]
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        if(root == null){
            return result;
        }
        
        Stack<TreeNode> sandByStack = new Stack<>();
        //Stack<TreeNode> popStack = new Stack<>();
        TreeNode cur = root;
        sandByStack.push(cur);
        while( !sandByStack.isEmpty()){
            //添加左侧所有节点
            while(cur.left!=null){
                sandByStack.push(cur.left);
                cur = cur.left;
            }
            TreeNode popNode = sandByStack.pop();
            result.add(popNode.val);
            if(popNode.right != null){
                sandByStack.push(popNode.right);
                cur = popNode.right;
            }  
        }

        return result;
    }

    public static void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode x = null;
        TreeNode y = null;
        TreeNode cur = root;
        TreeNode preNode = null;
        while(cur !=null){
            TreeNode leftNode = cur.left;
            if(leftNode !=null){
                // 判断未完善
                while( leftNode.right !=null && leftNode.right != cur){
                    leftNode = leftNode.right;
                }

                if(leftNode.right == null){
                    // 建立逃生通道
                    leftNode.right = cur;

                    //U.print( cur.left.val + " ");

                    // 进入left节点
                    cur = cur.left;  

                }else{
                    // 任务完成,拆除逃生通道
                    leftNode.right  = null;
                    if(preNode == null){
                        preNode = cur;
                    }else{
                        // 先找大于的值，再找小于的值
                        if(x == null){
                            //没找到错
                            if(preNode.val>=cur.val){
                                x = preNode;
                            }else{
                                preNode = cur;
                            }
                        }else{
                            if(cur.val <= preNode.val){
                                y = cur;
                            }else{
                                preNode = cur;
                            }
                        }
                        
                    }
                    // 向右走
                    cur = cur.right;
                }
            }else{
                U.print( cur.val + " " );
               
                if(preNode == null){
                    preNode = cur;
                }else{
                    // 先找大于的值，再找小于的值
                    if(x == null){
                        //没找到错
                        if(preNode.val>=cur.val){
                            x = preNode;
                        }else{
                            preNode = cur;
                        }
                    }else{
                        if(cur.val <= preNode.val){
                            y = cur;
                        }else{
                            preNode = cur;
                        }
                    }
                    
                }
                
                // 直接右边走
                cur = cur.right;
            }
            

        }
    }

    public static void main(String[]args){
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
       
     

        recoverTree(tree);
    }
}
