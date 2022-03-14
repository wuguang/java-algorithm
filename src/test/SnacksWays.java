package test;
/*
背包容量为W
一共有n袋零食，第i袋零食体积为 arr = V[i]>0,
总体积不超过背包容量的情况下，
1、 一共有多少钟零食放法?(总体积为0也算一种放法)

2、体积必须凑到 ===j时，有多少种选法?
*/

import done.javaFold.U;

public class SnacksWays {
    public static int ways1(int[]arr,int w){
        return process(arr,0,w);
    }
    // 、索引 从0开始但并没有计数，从依赖度额下一个开始技术的 所以jindex == arr.length
    // return 1
    public static int process(int[] arr, int index, int rest){
        //没有体积了，上次的选择撤离，不计入统计
        if(rest<0){
            return -1;
        }

        //没有了选择  
        if(index == arr.length && rest >=0){
            return 1;
        }

        //不选 ，知道尽头
        int next1 = process(arr,index+1,rest);
        int next2 = process(arr,index+1,rest-arr[index]);

        return next1 + (next2==-1?0:next2);  
    }

    // w 为剩余体积
    public static int ways(int[] arr,int w){
        int N = arr.length;
        int[][] dp = new int[N][w+1];
        // 体积为 0
        for(int i=0;i<N;i++){
            dp[i][0] = 1;
        }
        // 体积 小于 ??
        if(arr[0]<=w){
            dp[0][arr[0]] = 1; 
        }

        for (int i = 1; i < N; i++) {
			for (int j = 1; j <= w; j++) {
				dp[i][j] = dp[i - 1][j] + ((j - arr[i]) >= 0 ? dp[i - 1][j - arr[i]] : 0);
			}
		}
		int ans = 0;
		for (int j = 0; j <= w; j++) {
			ans += dp[N - 1][j];
		}
		return ans;

    }

    public static void main(String[] args){
        int []arr = {1,2,3};
        int result = ways1(arr,20);
        U.print("result=" + result);
    } 
}
