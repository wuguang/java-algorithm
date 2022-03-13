package done.javaFold;


public class IsSymmetric {

    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root == null){
                return true;
            }
            return compareTwoNode(root.left,root.right);  
        }
        // 比较 2个节点是否 对称
        public boolean compareTwoNode(TreeNode left,TreeNode right){
            if(left == null && right == null){
                return true;
            }

            if(left !=null && right!=null && left.val == right.val){
                return compareTwoNode(left.left,right.right) && compareTwoNode(left.right,right.left);
            }else{
                return false;
            }
        }
    }

    public static void main(String []args){
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.left.right = new TreeNode(5);
        tree.right = new TreeNode(1);
        tree.right.left = new TreeNode(5);
        Boolean result = new Solution().isSymmetric(tree);
        U.print("result=" + result);
    }
}
