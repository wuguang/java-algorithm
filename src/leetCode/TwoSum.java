package leetCode;

import done.javaFold.U;

class TwoSum {
    public static void main(String[] args){
        /*
        [9,9,9,9,9,9,9]
        [9,9,9,9]
        */
        
        ListNode list01 = new ListNode(9);
        ListNode cur01 = list01;
        for(int i=0;i<=5;i++){
            cur01.next = new ListNode(9);
            cur01 = cur01.next;
        }
        ListNode list02 = new ListNode(9);
        ListNode cur02 = list02;
        for(int i=0;i<=2;i++){
            cur02.next = new ListNode(9);
            cur02 = cur02.next;
        }

        /*
        while(list01 != null){
            U.print(list01.val + "=>");
            list01 = list01.next;
        }

        U.println("-----------");

        while(list02 != null){
            U.print(list02.val + "=>");
            list02 = list02.next;
        }
        U.println("-----------");
        */

        ListNode result = new Solution().addTwoNumbers(list01,list02);

        while(result != null){
            U.print(result.val + "=>");
            result = result.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(l1 == null || l2==null){
                return null;
            }
            int add = 0;
            ListNode target = null;
            ListNode lastEnd = null;
            while(l1!=null && l2!=null){
                int num01 = l1.val;
                int num02 = l2.val;
                int curVal = num01+num02+add;
                if(curVal>=10){
                    curVal = curVal%10;
                    add = 1;
                }else{
                    add = 0;
                }
                ListNode newNode = new ListNode(curVal);
                if(target == null){
                   target = newNode;
                }else{
                   lastEnd.next = newNode;
                }
                lastEnd = newNode;
                l1 = l1.next;
                l2 = l2.next;
            }
            while(l1!=null){
                int curVal =  l1.val;
                if(add>0){
                    curVal = add + l1.val;
                    if(curVal>=10){
                        curVal = curVal%10;
                        add = 1;
                    }else{
                        add = 0;
                    }
                }
    
                //浅复制
                lastEnd.next = new ListNode(curVal);
                lastEnd = lastEnd.next;
                l1= l1.next;
            }
            while(l2!=null){
                int curVal =  l2.val;
                if(add>0){
                    curVal = add + l2.val;
                    if(curVal>=10){
                        curVal = curVal%10;
                        add = 1;
                    }else{
                        add = 0;
                    }
                }
    
                //浅复制
                lastEnd.next = new ListNode(curVal);
                lastEnd = lastEnd.next;
                l2= l2.next;
                
            }
            if(add>0){
                lastEnd.next = new ListNode(add);
            }
            return target;
        }
    }
}