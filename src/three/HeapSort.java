package three;
import java.util.PriorityQueue;

import done.javaFold.U;

public class HeapSort {
    public static void heapify(int[] arr,int end){
        if(arr == null || arr.length == 1){
            return;
        }
        for(int i=end;i>=0;i--){
            if(2*i+1<=end){
                doHeapify(arr,i,end);
            }
        }
    }

    public static void doHeapify(int[] arr ,int i,int end){
        int leftIndex = 2*i+1;
        int rightIndex = 2*i+2;
        int largetIndex = -1;

        if(leftIndex<=end ){
            largetIndex = leftIndex;
            if(rightIndex<=end && arr[rightIndex]>arr[largetIndex]){
                largetIndex = rightIndex;
            }
        }

        // 做交换 堆化
        if(largetIndex != -1 && arr[i]< arr[largetIndex]){
            U.swap(arr, i, largetIndex);
            // 交换之后还不达当前节点要求
            doHeapify(arr, largetIndex,end);
        } 
    }

    public static void heapSort(int[] arr){
        //构建大顶堆
        heapify(arr,arr.length-1);

        U.printArr(arr);

        for(int i=arr.length-1;i>0;i--){
            // 交换 数据 
            U.swap(arr,i,0);
            // heap 以i-1结尾 包括i-1
            doHeapify(arr,0,i-1);
            //U.println(" 堆化===;  i=" + i);
            //U.printArr(arr);
        }
    }

    //heapify 小顶堆
    public static void heapifySamllHeap(int[] arr){
        if(arr == null || arr.length==1){
            return;
        }
        int len = arr.length;
        for(int i=len-1;i>=0;i--){
            doHeapifyForSamll(arr,i,len-1);
        }
        //U.printArr(arr);
        U.swap(arr, len-1, 0);
        //第一次堆化完毕
        for(int end=len-2;end>0;end--){
            // 第一个和end交换，最小的放最后
            //堆化从头开始
            doHeapifyForSamll(arr,0,end); 
            U.swap(arr, end, 0);
        }
    }

    // 包括end点
    // 从上到下堆化过程
    public static void doHeapifyForSamll(int[] arr, int i, int end){
        int leftIndex = i*2+1;
        int rightIndex = i*2 + 2;
        int samllIndex = -1;
        if(leftIndex<=end){
            samllIndex = leftIndex;
            if(rightIndex<=end && arr[rightIndex]<arr[leftIndex]){
                samllIndex = rightIndex;
            }
        }
        if(samllIndex!=-1 && arr[samllIndex]<arr[i]){
            U.swap(arr, i, samllIndex);
            doHeapifyForSamll(arr, samllIndex,end);
        }
    }


    public static void main(String[] args){

        int[] arr = {9,2,12,1,15,3,18,6,19,5,28,13,45,7,58,9,134,45,156,23,178,1,1,1,2,2,2,33333,3,3,44,4,4};

        /*
        heapSort(arr);
        for(int v:arr){
            U.print( v +" ");
        }
        */
        heapifySamllHeap(arr);
        for(int v:arr){
            U.print( v +" ");
        }
    }
}
