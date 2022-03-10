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
}
