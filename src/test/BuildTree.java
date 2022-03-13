package test;

import java.util.HashMap;

/*
给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。


链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

*/

public class BuildTree {
    static class Solution {
        HashMap<Integer,Integer> inorderMap = new HashMap<>();
        public void initMap(int[] inorder){
            for(int i=0;i<inorder.length;i++){
                inorderMap.put(inorder[i],i);
            }
        }
        
        public TreeNode buildChildTree(int[] preorder, int[] inorder,HashMap<Integer,Integer> inorderMap,int preStart,int preEnd, int inStart,int inEnd){
            //构造要给节点
            TreeNode tree = new TreeNode(preorder[preStart]);

            int leftPreStart = preStart + 1;
            int leftLen = inorderMap.get(preorder[preStart]) - inStart;
            int leftPreEnd = leftPreStart + leftLen - 1;

            int leftInStart = inStart;
            int leftInEnd = leftInStart + leftLen - 1;

            if(leftPreStart<=leftPreEnd && leftPreEnd<=preEnd){
                tree.left = buildChildTree(preorder,inorder,inorderMap,leftPreStart,leftPreEnd,leftInStart,leftInEnd);
            }
            
            int rightPreStart = leftPreEnd + 1;
            int rightPreEnd = preEnd;

            //获取 头和做节点结束的位置 + 1;
            int rightInStart = inorderMap.get(preorder[preStart]) + 1;
            int rightInEnd = inEnd;

            if(rightPreStart<=rightPreEnd && rightPreEnd<= preEnd){
                tree.right = buildChildTree(preorder,inorder,inorderMap,rightPreStart,rightPreEnd,rightInStart,rightInEnd);
            }
            return tree;
        }
        //递归版本
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if(preorder.length == 0 ){
                return null;
            }
            if(preorder.length == 1){
                return new TreeNode(preorder[0]);
            }
            initMap(inorder);

            return buildChildTree(preorder,inorder,inorderMap,0,preorder.length-1,0,preorder.length-1);
        }
        //迭代版本

    }
    
    public static void main(String[] args){

        int[] preOrder = {1,2,3};
        int[] inOrder = {2,3,1};
        new Solution().buildTree(preOrder,inOrder);

    }
}
