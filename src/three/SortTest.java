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

    public static void shellSort03(int[] arr){
        if(arr==null || arr.length==1){
            return;
        }
        //用间隔来是数组，来使数组初步有序
        int len = arr.length;
        //Java向下取整，其他语言注意调整终止条件
        for(int gap = len/2; gap>0; gap = gap/2){
            for(int i=gap;i<len;i+=gap){
                //检测插入排序
                //while有中断条件，for需要自己break;
                int j = i-gap;
                int tIndex = i;
                //arr[tIndex] 找到合适自己的地方
                while(j>=0 && arr[tIndex]<arr[j] ){
                    //交换位置
                    U.swap(arr, tIndex, j);
                    tIndex = j;
                    j -= gap;
                }
            }
        }
    }

    
    public static void mergeSort(int[] arr){
        if(arr==null || arr.length==1){
            return;
        }
        doMergSort(arr,0,arr.length-1);
    }

    public static void doMergSort(int[] arr, int left, int right){
        if(left == right){
            return;
        }
        int mid = (right+left)/2;
        doMergSort(arr,left,mid);
        doMergSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    public static void merge(int[] arr,int left,int mid,int right){
        int[] tempArr = new int [right-left+1];
        int leftIndex = left;
        int rightIndex = mid+1;
        int i = 0;
        while(leftIndex<=mid && rightIndex<=right){
            // 等于是必要的!!此处 保持稳定性的必要条件
            if(arr[leftIndex]<= arr[rightIndex]){
                tempArr[i++] = arr[leftIndex++];
            }else{
                tempArr[i++] = arr[rightIndex++];
            }
        }

        while(leftIndex<=mid){
            tempArr[i++] = arr[leftIndex++];
        }

        while(rightIndex<=right){
            tempArr[i++] = arr[rightIndex++];
        }
        i = 0;
        while(i<= tempArr.length-1){
            arr[left++] = tempArr[i++];
        }
    }


    public static void quickSort(int[]arr){
        if(arr==null || arr.length==1){
            return;
        }
        doQuickSort(arr,0,arr.length-1);
    }

    public static void doQuickSort(int[]arr,int left,int right){
        if(right==left){
            return;
        }
        int leftIndex = left -1;
        int rightIndex= right+1;
        int i = left;
        int pivot = arr[left];
        // i进入 right占领区立即停止
        while(i<rightIndex){
            if(arr[i]<pivot){
                leftIndex++;
                U.swap(arr, i, leftIndex);
                i++;
            }else if(arr[i] == pivot){
                i++;
            }else{
                rightIndex--;
                U.swap(arr,i,rightIndex);
            }
        }

        if(leftIndex>left){
            doQuickSort(arr,left, leftIndex);
        }
        
        if(right>rightIndex){
            doQuickSort(arr, rightIndex, right);
        }
        
    }

    public static void quickSortClassic(int[] arr){
        if(arr == null || arr.length==1){
            return;
        }
        doQuickSortClassic(arr, 0, arr.length-1);
    }

    public static void doQuickSortClassic(int[]arr,int left,int right){
        if(left == right){
            return;
        }
        int pivot = arr[left];
        int leftIndex = left + 1;
        int rightIndex = right;
        while(leftIndex<=rightIndex){
            // 至少有一个携带等于号,防止2个都是pivot重复无限交换
            while(arr[rightIndex]>=pivot){
                rightIndex--;
            }
            while(arr[leftIndex]<=pivot){
                leftIndex++;
            }
            U.swap(arr, leftIndex, rightIndex);
        }
    }

    // 计数排序
    // 正整数 一定范围类的数 大于0
    public static void countSort(int[] arr){
        if(arr==null || arr.length==1){
            return;
        }
        int max = arr[0];
        int min = arr[0];
        for(int i=0;i<=arr.length-1;i++){
            if(arr[i]<min){
                min = arr[i];
            }
            if(arr[i]>max){
                max = arr[i];
            }
        }
        int k = max-min+1;
        int[] newArr = new int[max+1];

        for(int i=0;i<=arr.length-1;i++){
            newArr[arr[i]] += 1;
        }
        U.printArr(newArr);
    
        int j = 0;
        for(int i=0;i<=newArr.length-1;i++){
            while(newArr[i]>0){
                arr[j] = i;
                j++;
                newArr[i] -= 1;
            }
        }
    }

    public static void countSort02(int[] arr){
        if(arr==null || arr.length == 1){
            return;
        }
        int max = arr[0];
        int min = arr[0];
        for(int i=0;i<=arr.length-1;i++){
            if(arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                min = arr[i];
            }
        }
        int k = max - min + 1;
        int [] tempArr = new int[k+1];
        for(int i=0;i<=arr.length-1;i++){
            //所有的值都肖去min
            tempArr[arr[i]-min] += 1;
        }

        int i = 0;
        for(int j=0;j<=tempArr.length-1;j++){
            int t = tempArr[j];
            while(t>0){
                //还原时加上min
                arr[i] = j+min;
                i++;
                t--;
            }
        }



    }

    public static void main(String[] args){
        int [] arr = {2,12,3,15,5,25,6,61,7,16,11,22,33,67,89,23,1,1,2,3,3,4};
        countSort(arr);
        U.printArr(arr);
    }
}
