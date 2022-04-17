package leetCode;

import done.javaFold.U;
import java.util.*;
class TwoSumMap {

    public static void main(String[] args){
        int [] nums = {3,2,4};
        int[] result = new Solution().twoSum(nums, 6);
        U.printArr(result);
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            if(nums==null || nums.length<=1){
                return null;
            }
            int [] targetArr = new int[2];
            HashMap<Integer,Integer> restIndexMap = new HashMap<>();

            int i = 0;
            while(i<=nums.length-1){
                int curVal = nums[i];
                restIndexMap.put(target-curVal,i);
                i++;
            }
            
            i = 0;
            while(i<=nums.length-1){
                int curVal = nums[i];
                if(restIndexMap.containsKey(curVal) && i !=restIndexMap.get(curVal)){
                    targetArr[0] = i;
                    targetArr[1] = restIndexMap.get(curVal);
                    break;
                } 
            }
            return targetArr;
        }
    }

}