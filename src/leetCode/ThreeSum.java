package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import done.javaFold.U;

public class ThreeSum {
    public static void main(String[] args){
        int [] nums = {-1,0,1,2,-1,-4};
        Arrays.sort(nums);
        U.printArr(nums);
        ArrayList<ArrayList<Integer>> result = new Solution().threeSum(nums);
        for(ArrayList<Integer> item :result){
            for (int i = 0; i < item.size(); i++) {
                U.print(item.get(i) + "@");
            }
            U.println("-------");
        }
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            ArrayList<ArrayList<Integer>> ans =  new ArrayList<ArrayList<Integer>>();
            if(nums==null || nums.length<3){
                return ans;
            }
            HashSet<String> multSet= new HashSet<>();
            HashSet<String> mySet = new HashSet<>();
            int curNum;
            for(int i=0;i<nums.length;i++){
                curNum = nums[i];
                if(!mySet.contains(curNum)){
                    getTwoNum(i,0-curNum,nums,multSet,ans);
                }
            }

            return ans;
        }

        public void getTwoNum(int exceptIndex,int target,int[]nums,HashSet<String> multSet,ArrayList<ArrayList<Integer>> ans){
            HashMap<Integer,Integer> targetMap = new HashMap<>(); 
            int i=0;
            for(;i<nums.length;i++){
                if(i!=exceptIndex){
                    int key = target - nums[i];
                    targetMap.put(key,i);
                }
            }
            i=0;
            for(;i<nums.length;i++){
                if(i!=exceptIndex){
                    if(targetMap.containsKey(nums[i]) && i != targetMap.get(nums[i])){
                        ArrayList<Integer> item =  new ArrayList<Integer>();
                        int[] itemArr = {nums[exceptIndex],nums[targetMap.get(nums[i])],nums[i]};
                        Arrays.sort(itemArr);
                        String hasKey = Arrays.toString(itemArr);
                        
                        if(!multSet.contains(hasKey)){
                            item.add(nums[exceptIndex]);
                            item.add(nums[targetMap.get(nums[i])]);
                            item.add(nums[i]);
                            ans.add(item);
                            multSet.add(hasKey);
                        }
                    }
                }
            }
        }
    }
}
