package test;

public class Manacher {
    public static void main(String[] args){


    }

    public static int manacher(String s){
        if(s==null || s.length() == 0){
            return 0;
        }
        char[] str = manacherString(s);
        int[] pArr = new int[str.length];
        int C = -1;
        int R = -1;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<str.length;i++){
            pArr[i] = R>i?Math.min(pArr[2*C - i]):1;
            while(i+pArr[i]<str.length && i-pArr[i]>-1){
                if(str[i+pArr[i]] == str[i-pArr[i]]){
                    pArr[i]++;
                }else{
                    break;
                }
            }
            if(i + pArr[i]>R){
                R = i+ pArr[i];
                C= i;
            }
            max = Math.max(max,pArr[i]);
        }
        return max -1;
    }


    public static char[] manacherString(String str){
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length()*2 + 1];
        int index = 0;
        for(int i=0;i<res.length;i++){
            // #1#2#3#4#
            //res[i] = (i&1)==0?'#':charArr[index];
            res[i] = i%2==0?'#':charArr[index];
            index += 1;
        }
        return res;
    }
}
