package test;

import done.javaFold.U;

// 加速搜索字符的算法
public class Kmp {
    public static int kmpIndexOf(String src,String target){
        
        char[] srcCharArr = src.toCharArray();
        char[] targetArr= target.toCharArray();
        int[] nextArr = getNextArr(targetArr);

        //U.printArr(nextArr);

        int j = 0;
        
        for(int i=0; i<srcCharArr.length; i++){
            if(srcCharArr[i] == targetArr[j]){
                j++;
            }else if(i>0){
                if(j>0){
                    // 不变抵消后面的++
                    i--;
                    j = nextArr[j];
                }else{
                    j = 0;
                }
            }
            
            if(j==targetArr.length){
                return i - j + 1;
            }
        }
        

        return -1;


    }
    public static int[] getNextArr(char[] charArr){
        int[] nextArr = new int[charArr.length];
        nextArr[0] = 0;
        if(nextArr.length>=2){
            nextArr[1] = 0;
        }
        
        for(int i=2;i<charArr.length;i++){
            //target.getChars(, srcEnd, dst, dstBegin);
            //判断上一个是否大于0
            if(nextArr[i-1]>0){
                //新的长度是否相等
                if(charArr[i-1] == charArr[nextArr[i-1]]){
                    nextArr[i] = nextArr[i-1] + 1;
                }if(charArr[i-1] == charArr[0]){
                    nextArr[i] = 1;
                }else{
                    nextArr[i] = 0;
                }

            }else{
                if(charArr[i-1] == charArr[0]){
                    nextArr[i] = 1;
                }
            }
        }
        return nextArr;
    }

    // for test
	public static String getRandomString(int possibilities, int size) {
		char[] ans = new char[(int) (Math.random() * size) + 1];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = (char) ((int) (Math.random() * possibilities) + 'a');
		}
		return String.valueOf(ans);
	}

	public static void main(String[] args) {
        
       
        //kmpIndexOf
        /*
        String target = "ebeee";
        String src = "dbccebeebeeedcdcddd";

        int result = kmpIndexOf(src,target);
        U.print("result="+ result);
        */
       

        
		int possibilities = 5;
		int strSize = 20;
		int matchSize = 5;
		int testTimes = 50000000;
		System.out.println("test begin");
		for (int i = 0; i < testTimes; i++) {
			String str = getRandomString(possibilities, strSize);
			String match = getRandomString(possibilities, matchSize);
			if (kmpIndexOf(str, match) != str.indexOf(match)) {
                U.println("str=" + str +";match=" + match);
                U.println("kmpIndexOf(str, match)=" + kmpIndexOf(str, match));
                U.println("str.indexOf(match)=" + str.indexOf(match));
			}
		}
		System.out.println("test finish");
    
	}
}


/*
function test(){
    for(let i=0;i<100;i++){
        if(i<10){
            console.log('111');
        }else if(i>90){
            console.log('222');
        }
    }
}

function test02(){
    for(let i=0;i<100;i++){
        if(i<10){
            console.log('111');
            continue;
        }
        if(i>90){
            console.log('222');
            continue;
        }
    }
}
*/