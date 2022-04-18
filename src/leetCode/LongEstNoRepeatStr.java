package leetCode;

import java.util.HashMap;
import java.util.HashMap;
import java.util.LinkedList;

import done.javaFold.U;

public class LongEstNoRepeatStr {
    public static void main(String[] args){
        
        int result = new Solution02().lengthOfLongestSubstring("abacba");
        U.print("result = " + result);
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s == null){
                return 0;
            }
            HashMap<Character,Integer> windowMap = new HashMap<>();
            int startIndex = 0;
            int endIndex = -1;
            int i = 0;
            int maxLen = 0;
            int len = s.length();
            
            while(i<=len-1){  
                char curChar = s.charAt(i);
                if( windowMap.containsKey(curChar) ){
                    int deleteS = startIndex;
                    int deleteE= windowMap.get(curChar);
                    startIndex = deleteE + 1;
                    //删除map
                    while(deleteS<=deleteE){
                        windowMap.remove(s.charAt(deleteS));
                        deleteS += 1;
                    }
                }
                //每次endIndex更新 ，map 更新
                endIndex += 1;
                windowMap.put(curChar,i);
                //保持最大值更新
                maxLen = Math.max(maxLen,endIndex-startIndex + 1);
                i++;
            }
            return maxLen;
        }
    }


    static class Solution02 {
        public int lengthOfLongestSubstring(String s) {
            int[] charArr = new int[128];
            int i = 0;
            for(;i<charArr.length;i++){
                charArr[i] = -1;
            }
            int len = s.length();
            int result = 0;
            int lastIndex = -1;
            i = 0;
            while(i<len){
                // char 转 int
                int index = s.charAt(i);
                //当前字符没有重复
                if(charArr[index] != -1 && charArr[index]>lastIndex){
                    lastIndex = charArr[index];
                }
                result = Math.max(result,i-lastIndex);
                charArr[index] = i;
                i++;
            };
            return result;
        }
    }

}
