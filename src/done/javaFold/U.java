package done.javaFold;

public class U {
    public static void  print(String str){
        System.out.print(str);
    }

    public static void  println(String str){
        System.out.println(str);
    }

    public static int[] swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    public static void  printArr(int[] arr){
        System.out.println(" ");
        System.out.println("-------打印数组开始--------");
        for(int v:arr){
            print( v + " ");
        }
        System.out.println(" ");
        System.out.println("-------打印数组结束--------");
        System.out.println(" ");
    }
}
