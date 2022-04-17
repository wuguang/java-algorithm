package leetCode;

import java.util.ArrayList;

import done.javaFold.U;

public class MergeKLists {
    public static void main(String[]args){
        //[[1,4,5],[1,3,4],[2,6,9]]
        int[] one = {1};
        int[] two = null;
        int[] three = {0};
        int[][] all = {one,two,three};
        ListNode[] lists = new ListNode[3];

        for(int i=0;i<all.length;i++){
            ListNode preNode = null;
            ListNode head = null;
            if(all[i] !=null){
                for(int j=0;j<all[i].length;j++){
                    if(head==null){
                        head = new ListNode(all[i][j]);
                        preNode = head;
                    }else{
                        preNode.next = new ListNode(all[i][j]);
                        preNode = preNode.next;
                    }            
                }
            }
            lists[i] = head;
        }
        ListNode result = new Solution().mergeKLists(lists);
        while(result!=null){
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
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null){
                return null;
            }
            ListNode target = null;
            ListNode preNode = null;
            ListNode[] arr = doHeap(lists);

            int endIndex = arr.length -1;
            int i = arr.length-1;
            while(i>=0){
                if(arr[i] == null){
                    endIndex --;
                    i--;
                }else{
                    break;
                }
            }
            while(endIndex>=0){
                if(target == null){
                    target = arr[0];
                    preNode = target;
                }else{
                    preNode.next = arr[0];
                    preNode = preNode.next;
                }
                if(endIndex == 0){
                    break;
                }
                endIndex = resolveForEndIndex(lists,arr,endIndex);
            }
            return target;
        }

        public int resolveForEndIndex(ListNode[] lists,ListNode[] arr,int endIndex){
            ListNode curNode = arr[0];
            //当前Link结束
            if(curNode.next !=null){
                arr[0] = curNode.next;
                heapify(arr, 0 ,endIndex);
            }else{
                arr[0] = arr[endIndex];
                endIndex = endIndex-1;
                heapify(arr, 0, endIndex);
            }
            return endIndex;
        }

        public ListNode [] doHeap(ListNode[] lists){
            ListNode [] arr = new ListNode[lists.length];
            int endIndex = arr.length-1;
            int nextIndex = 0;
            for(int i=0;i<lists.length;i++){
                if(lists[i] == null){
                    endIndex --;
                }else{
                    arr[nextIndex] = lists[i];
                    nextIndex ++;
                }
            }
            
            //从第一个非叶节点，开始调整
            int startIndex = (endIndex+1)/2-1;
            for(int i=startIndex;i>=0;i--){
                heapify(arr,i,endIndex);
            }
            return arr;
        }

        // 子节点 n*2+1 n*2+2
        // 父节点 (n+1)/2-1
        public void heapify(ListNode[] arr,int index,int endIndex){
            // 从 第一个非叶节点开堆化
            int leftIndex = index*2+1;
            int curVal = arr[index].val;
            // 左节点是最后一个节点
            if(leftIndex == endIndex){
                ListNode leftNode = arr[leftIndex];
                if(curVal>leftNode.val){
                    swap(arr,index,leftIndex);
                }
            }else if(endIndex >= leftIndex+1){
                //必然是2个子节点都有
                ListNode min = arr[leftIndex];
                ListNode rightNode = arr[leftIndex+1];
                int minIndex = leftIndex;
                if(min.val>rightNode.val){
                    min = rightNode; 
                    minIndex = leftIndex+1;
                }
                if(curVal>min.val){
                    swap(arr, index, minIndex);
                    heapify(arr,minIndex,endIndex);
                } 
            }
        }

        public void swap(ListNode [] arr,int a, int b){
            ListNode temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

}
