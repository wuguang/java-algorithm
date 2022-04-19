package leetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import three.HasHMap;

public class LetterCombinations {

    static class Solution {
        public List<String> letterCombinations(String digits) {
            //List<String>  myList 
            ArrayList <String> myList = new ArrayList<String>();
            if(digits == null || digits.length() == 0){
                return  (List<String>) myList;
            }
            HashMap<Integer,String[]>  myMap = new HashMap<>();
            String [] str02 = {"a","b","c"};
            String [] str03 = {"d","e","f"};
            String [] str04 = {"g","h","i"};
            String [] str05 = {"j","k","l"};
            String [] str06 = {"m","n","o"};
            String [] str07 = {"p","q","r","s"};
            String [] str08 = {"t","u","v"};
            String [] str09 = {"w","x","y","z"};
            myMap.put(2, str02);
            myMap.put(3, str03);
            myMap.put(4, str04);

            myMap.put(5, str05);
            myMap.put(6, str06);
            myMap.put(7, str07);

            myMap.put(8, str08);
            myMap.put(9, str09);

            //String[] numArr = digits.ch
            
            ArrayList<String[]> myStrList = new ArrayList<>();
            for(int i=0;i <digits.length(); i++){
                myStrList.add(myMap.get(digits.charAt(i)));
            }

            /*
            for (int i = 0; i < myStrList.size(); i++) {
                String startStr = "";
                for(String strItem : myStrList.get(i)){
                    myList.add(strItem);
                }
            }
            */
            //myList
        }

        public void getTargetStr(String[] numArr,String lastStr,ArrayList<String> myList){
            if(lastStr.length()>0){
                myList.add(lastStr);
            }
            
            for(int i=0;i<numArr.length;i++){
               // getTargetStr(lastStr + charArr);
            }
        }


    }
}
