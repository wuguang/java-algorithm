package done.javaFold;
/*
给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，并且总共有 N 枚硬币。

在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。(移动可以是从父结点到子结点，或者从子结点移动到父结点。)。

返回使每个结点上只有一枚硬币所需的移动次数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/distribute-coins-in-binary-tree

*/

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


