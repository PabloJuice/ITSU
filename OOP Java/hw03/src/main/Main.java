package main;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
//        1
//        int k = 3;
//        String pasteSample = "lol";
//        String text = "Sunt demolitionees reperire magnum, albus advenaes. ";
//        String result = "";
//        StringTokenizer stringTokenizer = new StringTokenizer(text);
//        while (stringTokenizer.hasMoreTokens()){
//            StringBuilder stringBuilder = new StringBuilder(stringTokenizer.nextToken());
//            stringBuilder.insert(k, pasteSample);
//            result+=stringBuilder;
//            result+= " ";
//        }
//
//
//        for (int i = 0; i < text.lastIndexOf(" "); i = text.indexOf(" ", i+1)) {
//            if (i>0){
//                result += text.substring(i,i+k+1);
//                result += pasteSample;
//                result += text.substring(i+k+1, text.indexOf(" ", i+1));
//            }else {
//                result += text.substring(i,i+k);
//                result += pasteSample;
//                result += text.substring(i+k, text.indexOf(" ", i+1));
//            }
//        }
//
//        System.out.println(result);


        //5
//        String text = "Sunt demolitionees reperire magnum, albus advenaes. ";
//        String result = "";
//
//        for (int i = 0; i < text.lastIndexOf(" "); i = text.indexOf(" ", i+1)) {
//            String currentWord = "";
//           if (i>0){
//               currentWord = text.substring(i+1, text.indexOf(" ", i+1));
//           }else {
//               currentWord = text.substring(i, text.indexOf(" ", i+1));
//           }
//            for (int j = 0; j < text.lastIndexOf(" "); j = text.indexOf(" ", j+1)) {
//                if (j>0){
//                    if (currentWord.equals(text.substring(j+1, text.indexOf(" ", j+1)))){
//                        break;
//                    }
//                    else {
//                        if (currentWord.charAt(0) == text.substring(j+1, text.indexOf(" ", j+1)).charAt(j)){
//                            if (){
//
//                            }
//                        }
//                    }
//
//                }else {
//                    currentWord = text.substring(i, text.indexOf(" ", i+1));
//                }
//            }
//            System.out.println(result);



// 3
//        int[] firstArray = {6, 8, 22, 2, 11, 19, 23};
//        ArrayList<Integer> firstArrayList = new ArrayList<Integer>();
//        int sum = 0;
//        for (int i:firstArray) {
//          sum+=i;
//        }
//        for (int i: firstArray) {
//            if (i>sum/firstArray.length) firstArrayList.add(i);
//        }
//        System.out.println(sum/firstArray.length);
//        System.out.println(firstArrayList);

//  4
//        int[] firstArray = {0, 8, 22, 2, 11, 19, 23};
//        int[] secondArray = {8, 5, 3, 10, 17, 14, 52, 13};
//        int[] thirdArray = new int[firstArray.length + secondArray.length];
//        System.arraycopy(firstArray, 0, thirdArray, 0, firstArray.length);
//        System.arraycopy(secondArray, 0, thirdArray, firstArray.length, secondArray.length);
//        ArrayList<Integer> secondArrayList = new ArrayList<>();
//        int firstSum = 0;
//        int secondSum = 0;
//        for (int i:firstArray) {
//            firstSum+=i;
//        }
//        for (int i:secondArray) {
//            secondSum+=i;
//        }
//        for (int i: thirdArray){
//            if (firstSum < secondSum){
//                if (i > firstSum/firstArray.length && i < secondSum/secondArray.length){
//                    secondArrayList.add(i);
//                }
//            }
//            else {
//                if (i > secondSum/secondArray.length && i < firstSum/firstArray.length){
//                    secondArrayList.add(i);
//                }
//            }
//        }
//        System.out.println(secondArrayList);

        int[ ] arr = {1,2,3,4};
        for ( int i : arr )
        {
            arr[i] = 0;
            System.out.println(Arrays.toString(arr));
        }
        for ( int i : arr )
        {
            System.out.println(i);
        }


    }
}
