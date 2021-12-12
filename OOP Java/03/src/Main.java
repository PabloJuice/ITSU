import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 1
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

        //2
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

//        int[] arrayFirst = {8, 5, 3, 10, 17, 14, 52, 13};
//        System.out.println(Arrays.toString(arrayFirst));
//        int min = (int)Double.POSITIVE_INFINITY;
//        int minPos = 0;
//        int max = (int)Double.NEGATIVE_INFINITY;
//        int maxPos = 0;
//        for (int pos = 0; pos < arrayFirst.length; pos++) {
//            if(arrayFirst[pos] < min){
//                min = arrayFirst[pos];
//                minPos = pos;
//            }
//            if (arrayFirst[pos]>max){
//                max = arrayFirst[pos];
//                maxPos = pos;
//            }
//
//        }
//        arrayFirst[minPos] = max;
//        arrayFirst[maxPos] = min;
//        System.out.println(Arrays.toString(arrayFirst));

        int[] arrayFirst = {8, 5, 3, 10, 17, 14, 52, 13};
        System.out.println(Arrays.toString(arrayFirst));
        int min = (int)Double.POSITIVE_INFINITY;
        int minPos = 0;
        int max = (int)Double.NEGATIVE_INFINITY;
        int maxPos = 0;
        for (int pos = 0; pos < arrayFirst.length; pos++) {
            if(arrayFirst[pos] < min){
                min = arrayFirst[pos];
                minPos = pos;
            }
            if (arrayFirst[pos]>max){
                max = arrayFirst[pos];
                maxPos = pos;
            }
        }
        int[] arraySecond = new int[arrayFirst.length-2];


        System.out.println(Arrays.toString(arrayFirst));

    }
}
