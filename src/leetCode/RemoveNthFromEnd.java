package leetCode;

import java.util.Scanner;

import javax.lang.model.util.Elements.Origin;

import done.javaFold.U;

public class RemoveNthFromEnd {
    public static void main(String[] args){
        ListNode one = new ListNode(1);
        
        /*
        ListNode cur = one;
        for(int i=2;i<=5;i++){
            cur.next = new ListNode(i);
            cur = cur.next;1
        }
        */
         
        ListNode result = new Solution().removeNthFromEnd(one,1);
        while(result !=null ){
            U.print( result.val + "=>");
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head == null) return null;
            ListNode first = head;
            ListNode second = head;
            int i = 0;

            //ListNode origin = head;
            while(first!=null){
                first = first.next;
                i++;
                if(i>n){
                    // 删除下一个节点
                    if(first == null){
                        //删除 second.next点
                        second.next  = second.next.next;
                        break;
                    }else{
                        second = second.next;
                    }
                }   
            }
            if(i == n){
                return head.next;
            }
            return head;
        }
    }

}