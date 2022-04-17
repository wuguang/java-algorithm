package three;
import java.util.PriorityQueue;

import done.javaFold.U;

public class HeapSort02 {

    public static void heapSort(int[] arr){
        int lastParentIndex = arr.length/2 - 1;
        //规定了一个结尾
        int endIndex = arr.length-1;
        for(int i=lastParentIndex; i>=0; i-- ){
            heapify(arr,i,endIndex);
        }
        //堆化完毕
        //交换定点
        swapIndex(arr);
    }

    public static void swapIndex(int[] arr){
        //堆的长度
        int endIndex = arr.length-1;
        while(endIndex>0){
            //交换
            swap(arr,0,endIndex);
            //堆化
            heapify(arr, 0, endIndex-1);
            endIndex --;
        }
    }
    
    //java向下取整的特点
    // leftIndex = n*2+1;
    // rightIndex = n*2+2;
    // paretIndex = (n+1)/2 - 1;
    //堆化
    //小顶堆
    public static void heapify(int[] arr,int index,int endIndex){
        int leftIndex = index*2+1;
        int rightIndex = index*2 + 2;
        
        //最后一个,刚好只有一个左节点
        if(endIndex==leftIndex){
            if(arr[leftIndex]> arr[index]){
                swap(arr,index,leftIndex);
                //没有可交换的数据了，不需要迭代了
            }
        }else if(endIndex >=rightIndex){
            int max = arr[index];
            max = Math.max(arr[leftIndex],max);
            max = Math.max(arr[rightIndex],max);
            int swapIndex = max == arr[leftIndex]?leftIndex:rightIndex;
            if(max != arr[index]){
                swap(arr,index,swapIndex);
                heapify(arr,swapIndex,endIndex);
            }
        }
    }

    public static void swap (int[]arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp; 
    }
 
    public static void main(String[] args){
        int[] arr = {9,2,12,1,15,3,18,6,19,5,28,13,45,7,58,9,134,45,156,23,178,1,1,1,2,2,2,33333,3,3,44,4,4};

        heapSort(arr);

        U.printArr(arr);
   
    }
}
