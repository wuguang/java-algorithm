package test;
import java.util.*;
import done.javaFold.U;

public class IsSymmetric {

    static class Solution {

        public boolean isSymmetricWithIteration(TreeNode root) {
            if(root == null){
                return true;
            }

            Stack<TreeNode> leftStack = new Stack<>();
            Stack<TreeNode> rightStack = new Stack<>();
            leftStack.push(root.left);
            rightStack.push(root.right);
            while(!leftStack.isEmpty() && !rightStack.isEmpty()){
                TreeNode leftPop = leftStack.pop();
                TreeNode rightPop = rightStack.pop();
                if((leftPop==null && rightPop == null)){
                    // 进入下次循环
                    continue;
                }else if(leftPop !=null && rightPop !=null && leftPop.val == rightPop.val ){
                    leftStack.add(leftPop.left);
                    leftStack.add(leftPop.right);
                    rightStack.add(rightPop.right);
                    rightStack.add(rightPop.left);
                }else{
                    return false;
                }
            }
            return true;
        }



        public boolean isSymmetric(TreeNode root) {
            if(root == null){
                return true;
            }
            return compareTwoNode(root.left,root.right);  
        }
        // 迭代法 求递归法
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
        tree.left.right.left = new TreeNode(7);
        tree.right = new TreeNode(1);
        tree.right.left = new TreeNode(5);
        tree.right.left.right = new TreeNode(7);
        Boolean result = new Solution().isSymmetricWithIteration(tree);
        U.print("result=" + result);
    }
}
