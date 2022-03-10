package done.javaFold;

import java.sql.Array;
import java.util.Arrays;

public class Bfprt {
    /**
     * 寻找数组中第K小的数,
     * 最好的排序O(nlogn),请用优于O(nlogn)的复杂度实现
     **/
    public static void bfprtQuickSort(int[] arr,int k){
        if(arr==null){
            return;
        }
        //使用荷兰国旗 快排方式实现
        int result = doBfprt(arr,0,arr.length-1,k);
        U.print("target=" + result);
    }

    // k不满足要求时,递归执行下面的代码
    public static int doBfprt(int[]arr,int start,int end, int k){
        // 对数组 arr [left,right-1]区域进行扫描
        int i = start;
        //在区域之外的领地
        int left = start-1;
        int right = end + 1;
        int pivot = arr[left];
        while(i<right){
            if(arr[i]<pivot){
                //left领地扩大,i 继续
                U.swap(arr,i,left+1);
                left++;
                i++;
            }else if(arr[i]>pivot){
                arr = U.swap(arr,i,right-1);
                right --;
            }else{
                i++;
            }
        }

        if(k>left && k<right){
            // 终止寻找，找到了，就是它
            return arr[left+1];
        }else{
            if(k<=left){
                //继续寻找[左边]
                return doBfprt(arr,start,left,k);
            }else{
                 //继续寻找[右边]
                 return doBfprt(arr,right,end,k);
            }
        }
    }

    public static void bfprtQuickSortClassic(int[] arr,int k){
        if(arr==null){
            return;
        }
        // 5个好友算法
        int target = doBfprtClassic(arr,0,arr.length-1,k);
        U.print("target=" + target);
    }

    public static int doBfprtClassic(int[]arr,int start,int end, int k){
        int pivot = getPivot(arr);
        // 对数组 arr [left,right-1]区域进行扫描
        int i = start;
        //在区域之外的领地
        int left = start-1;
        int right = end + 1;
        while(i<right){
            if(arr[i]<pivot){
                //left领地扩大,i 继续
                U.swap(arr,i,left+1);
                left++;
                i++;
            }else if(arr[i]>pivot){
                arr = U.swap(arr,i,right-1);
                right --;
            }else{
                i++;
            }
        }

        if(k>left && k<right){
            // 终止寻找，找到了，就是它
            return arr[left+1];
        }else{
            if(k<=left){
                //继续寻找[左边]
                return doBfprtClassic(arr,start,left,k);
            }else{
                 //继续寻找[右边]
                 return doBfprtClassic(arr,right,end,k);
            }
        }
    }


    public static int getPivot(int[] arr){
        int step = 5;
        //Arrays.sort(array);
        int arrLen = arr.length;
        int[] medianArr = new int[arrLen/5 + (arrLen%step!=0?0:1)];
        int i = 0;
        int j = 0;
        for(;i<arrLen;i+=step){
            if(i+5<=arrLen){
                int[] groupArr = Arrays.copyOfRange(arr, i, i+step);
                Arrays.sort(groupArr);
                //取数组的中位数，默认是5
                medianArr[j++] = groupArr[2];
            }else{
                //不足5个数目
                int[] groupArr = Arrays.copyOfRange(arr, i, arrLen);
                Arrays.sort(groupArr);
                //取数组的中位数
                medianArr[j++] = groupArr[groupArr.length/2];
            }
        }
        //得到 中位数 数组 
        Arrays.sort(medianArr);
        int target = medianArr[medianArr.length/2];
        return target;
    }

    public static void main(String[] args){
        int[] arr = {4,13,2,18,1,23,7,29,5,3,2,2};
        int k = 6;
        bfprtQuickSortClassic(arr,k-1);
    }
}
