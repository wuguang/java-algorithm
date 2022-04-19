package leetCode;

import done.javaFold.U;

public class MaxArea {
    public static void main(String[]args){
        int [] height = {1,8,6,2,5,4,8,3,7};
        int result = new Solution().maxArea(height);
        U.println("result = " + result);
    }
    
    static class Solution {
        public int maxArea(int[] height) {
            if(height == null ||height.length == 1){
                return 0;
            }
            int left  = 0;
            int right = height.length-1;
            int area = getArea(left, right, height);
            while(left != right){
                if(height[left]<height[right]){
                    left++;
                }else{
                    right--;
                }
                area = Math.max(area,getArea(left, right, height));
            }
            return area;
        }

        public int getArea(int left, int right,int[]height){
            return Math.min(height[left],height[right]) * (right-left);
        }
    }
}
