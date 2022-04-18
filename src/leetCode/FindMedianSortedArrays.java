package leetCode;

import done.javaFold.U;

/*
给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数 。

算法的时间复杂度应该为 O(log (m+n)) 
*/
public class FindMedianSortedArrays {
    public static void main(String[] args){

        //U.print("result = " + 9/2);
        
        //double result = new Solution().findMedianSortedArrays("abacba");
        //U.print("result = " + result);
    }

    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len01 = nums1.length;
            int len02 = nums2.length;
            if(len01==0){
                return getMedian(nums2);
            }
            if(len02 ==0){
                return getMedian(nums1);
            }
            int allLen = len01+len02;
            //第k个非索引
            int kth = allLen/2 + allLen%2;

            getKthWithNums(kth,nums1,0,nums2,0,allLen);
            return 1.2;
        }

        public double getKthWithNums(int kth,int[] nums1, int start01,int[] nums2,int start02,int allLen){
            if(kth == 1){
                if(allLen%2 ==0){
                    //注意边界条件
                    
                    double first = Double.valueOf(Math.min(nums1[start01+1],nums1[start02+1]));
                    double second = 0;
                    if(first == nums1[start01+1]){
                        second = Double.valueOf(Math.min(nums1[start01+2],nums1[start02+1]));
                    }else{
                        second = Double.valueOf(Math.min(nums1[start01+1],nums1[start02+2]));
                    }
                    return (first+second)/2;
                }else{
                    return Double.valueOf(Math.min(nums1[start01+1],nums1[start02+1]));
                }
                
            }
            //删除个数
            int deleteIndex = kth/2;
            //比较 2个数组的 前 kth/2-1, 删除谁
            // 小的部分删除
            if(nums1[start01 + deleteIndex]>nums1[start02 + deleteIndex]){
                start02 += deleteIndex;
                kth -= deleteIndex;
            }else if(nums1[start01 + deleteIndex]<nums1[start02 + deleteIndex]){
                start01 += deleteIndex;
                kth -= deleteIndex;
            }else{
                //next number is target
                if(allLen%2 ==0){
                    
                }
            }

        }
        public double getMedian(int [] arr){
            int len = arr.length;
            if(len%2==0){
                double first = arr[len/2-1];
                double second = arr[len/2];
                return (first+second)/2;
            }else{
                return arr[len/2];
            }
        }
    }
}
