package leetCode;

import done.javaFold.U;

public class LongestPalindrome {
    public static void main(String[] args){
        String s = "abccbaqwe";
        String result = new Solution().longestPalindrome(s);
        U.print(result);
    }

    static class Solution {
        public String longestPalindrome(String s) {
            if(s.length() == 0 ){
                return "";
            }else if(s == null){
                return null;
            }
            char[] charArr = s.toCharArray();
            int len = charArr.length;
            int [][] dp = new int[len][len];
            int maxDp = 0;
            int left = 0;
            int right = 0;
            for(int i=0;i<=len-1;i++){
                dp[i][i] = 1;
            }
            // i  结束 索引
            // j 起始  索引i
            for(int i=0; i<len-1; i++){
                int n = i;
                for(int j=1+i; j<=len-1; j++){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i+1][j-1] + 2;
                    }else{
                        dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                    }
                    if( dp[i][j] > maxDp ){
                        maxDp = dp[i][j];
                        left  = i;
                        right = j;
                    }
                    i++;
                }
                i = n;
            }
            U.print("maxDp=" + maxDp);
            if(maxDp==0){
                return "";
            }else{
                return s.substring(left,right-left+1);
            }
        }
    }

}
