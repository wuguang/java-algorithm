package test;

import done.javaFold.U;

class Solution {
    TreeNode x = null;
    TreeNode y = null;
    TreeNode preNode = null;
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
       
        TreeNode cur = root;
        
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
                    // 进入left节点
                    cur = cur.left;  

                }else{
                    // 任务完成,拆除逃生通道
                    leftNode.right  = null;
                    U.print( cur.val + " " );
                    findxy(cur);
                    // 向右走
                    cur = cur.right;
                }
            }else{
                U.print( cur.val + " " );
               
                findxy(cur);
                
                // 直接右边走
                cur = cur.right;
            }
            

        }
        
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }

    public void findxy(TreeNode cur){
        if(preNode == null){
            preNode = cur;
        }else{
            // 先找大于的值，再找小于的值
            if(x == null){
                //没找到错
                if(preNode.val>=cur.val){
                    x = preNode;
                    y = cur;
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
    }
}


class RecoverTree{
    public static void main(String[] args){

        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);


        tree.right.left = new TreeNode(2);

        Solution one = new Solution();
        one.recoverTree(tree);
        U.println(" ");
        U.print(one.x.val + " " + one.y.val);

    }
}