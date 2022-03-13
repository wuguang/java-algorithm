package test;

import done.javaFold.U;

public class BinaryTreeCoin {

    public static class Solution{
        int num = 0;

        public int distributeCoins(TreeNode root) {
            if(root == null){
                return 0;
            }
            getNum(root);
            return this.num;
        }
    
        public int getNum(TreeNode root){
            int curVal = root.val;
            if(root.left == null && root.right == null){
                this.num += Math.abs(root.val-1);
                return root.val-1;
            }else{
                if(root.left !=null){
                    curVal += getNum(root.left);
                }
                if(root.right != null){
                    curVal += getNum(root.right);
                }
                this.num += Math.abs(curVal - 1);
                return curVal - 1;
            }
        }
    
        
    }

    public static class TreeNode {
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

    public static void main(String[]args){
        TreeNode tree = new BinaryTreeCoin.TreeNode(0);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(0);
        int target = new Solution().distributeCoins(tree);
        U.print("target=" + target);
    }
}


