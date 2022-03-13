package test;
import java.util.*;

import done.javaFold.U;

public class LevelOrder {

    static class Solution {

        public List<List<Integer>> levelOrder(TreeNode root) {
    
            List<List<Integer>> tList = new ArrayList<>();

            if(root == null){
                return tList;
            }else{
                Stack<TreeNode> addNodeFromLeft  = new Stack<>();
                Stack<TreeNode> addNodeFromRight  = new Stack<>();
                List<Integer> nextLevelVal  = new ArrayList<>();

                //从左至右
                addNodeFromLeft.add(root);
                nextLevelVal.add(root.val);

                while(!addNodeFromLeft.isEmpty() || !addNodeFromRight.isEmpty()){
                    tList.add(nextLevelVal);

                    //执行下一行， 值先清空
                    nextLevelVal  = new ArrayList<>();

                    if(!addNodeFromLeft.isEmpty()){
                        // 从左开始的List有节点,pop出后给右节点
                        while(!addNodeFromLeft.isEmpty()){
                            TreeNode curItem = addNodeFromLeft.pop();
                            // 先右 后左
                            if(curItem.right !=null){
                                addNodeFromRight.add(curItem.right);
                                nextLevelVal.add(curItem.right.val);
                            }
                            
                            if(curItem.left !=null){
                                addNodeFromRight.add(curItem.left);
                                nextLevelVal.add(curItem.left.val);
                            }
                        }
                    }else{
                        while(!addNodeFromRight.isEmpty()){
                            TreeNode curItem = addNodeFromRight.pop();
                            
                            if(curItem.left !=null){
                                addNodeFromLeft.add(curItem.left);
                                nextLevelVal.add(curItem.left.val);
                            }
    
                            // 先右 后左
                            if(curItem.right !=null){
                                addNodeFromLeft.add(curItem.right);
                                nextLevelVal.add(curItem.right.val);
                            }
                        }    
                    }
                   

                }
            }
            return tList;
        }
    
    }
    public static void main(String []args){
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(4);
        tree.left.left.left = new TreeNode(8);
        tree.left.left.right = new TreeNode(9);
        tree.left.right = new TreeNode(5);
        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        tree.right.right.left = new TreeNode(10);
        tree.right.right.right = new TreeNode(11);

        List<List<Integer>> result = new Solution().levelOrder(tree);
        U.print("result = " + result);

    }
}
