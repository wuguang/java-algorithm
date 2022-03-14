package three;
import done.javaFold.U;

public class HeapSort {
    public static void heapify(int[] arr,int end){
        if(arr == null){
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
        int largetIndex = leftIndex;

        if(leftIndex<=end && rightIndex<=end ){
            if(arr[rightIndex]>arr[largetIndex]){
                largetIndex = rightIndex;
            }

            // 做交换 堆化
            if(arr[i]< arr[largetIndex]){
                U.swap(arr, i, largetIndex);
                // 交换之后还不达当前节点要求
                doHeapify(arr, largetIndex,end);
            } 
        }
    }

    public static void heapSort(int[] arr){
        //heapify(arr,arr.length-1);
       
        for(int i=arr.length-1;i>0;i--){
            // 交换 数据 
            heapify(arr,i);
            U.swap(arr,i,0);
        }

    }

    public static void main(String[] args){
        int[] arr = {9,2,12,1,15,3,18,6,19};
        heapSort(arr);
        for(int v:arr){
            U.print( v +" ");
        }
    }
}
