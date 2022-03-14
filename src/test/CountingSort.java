package test;

import done.javaFold.U;

/*
计数排序，正整数，一定范围类的
整数，一定范围类的
*/
public class CountingSort{
    //正整数
    public static int[] sortForCounting(int[] array){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            max = Math.max(max,array[i]);
        }

        int[] indexArray = new int[max+1];
        for(int i=0; i<array.length; i++){
            indexArray[array[i]] += 1;
        }

        int i = 0;
        for(int j=0;j<indexArray.length;j++){
            int k = indexArray[j];
            while(k>0){
                array[i++] = j;
                k--;
            }
        }
        return array;
    }

    public static void main(String[] args){
        int[] arr = {9,2,16,3,19,5,23,5,36,3};
        sortForCounting(arr);
        for(int val :arr ){
            U.print(val + " ");
        }
    }

}
