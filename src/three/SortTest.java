package three;
import java.util.PriorityQueue;

import done.javaFold.U;

public class SortTest{

     //希尔排序
    //第一个突破O(n^2)的算法
    public static int[] shellSort(int [] arr){
        if(arr==null || arr.length<=1){
            return arr;
        }
        int len = arr.length;
        //i,j,k
        // java 向下取整的数
        for(int gap=len/2;gap>0;gap/=2){

            U.print("gap=" + gap);

            //从第二个元素开始
            for(int i=gap;i<=len-1;i+=gap){
                //arr[i]
                int minIndex = i;
                //前面一个数
                int j = i-gap;
                while(j>=0 && arr[j]>arr[minIndex] ){
                    U.swap(arr,minIndex,j);
                    minIndex = j;
                    j -= gap;
                }
            }
        }
        return arr;
    }

    public static void shellSort02(int [] arr){
        if(arr==null || arr.length==1){
            return;
        }
        int len = arr.length;
        // java 整数向下取整
        for(int gap = len/2; gap>0; gap/=2){
            U.println("gap=" + gap);
            //从每组的第二个数开始插入排序
            for(int i=gap; i<len; i+=gap){
                int minIndex = i;
                for(int j=i-gap; j>=0; j-=gap){
                    if(j>=0 && arr[minIndex] > arr[j]){
                        U.swap(arr, minIndex, j);
                        if(gap == 1){
                            U.printArr(arr);
                        }
                        //交换后，比较数，翻到前面
                        minIndex = j;
                    }else{
                        break;
                    }
                }
            }
        }
    }

    
    public static void main(String[] args){
        int [] arr = {2,12,3,15,5,25,6,61,7,16,11,22,33,67,89,23,1,1,2,3,3,4};
        shellSort02(arr);
        U.printArr(arr);
    }
}
