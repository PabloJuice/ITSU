package com.itstep;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // оголошуємо сканер (сканує ввід)
        int n,r; // оголошуємо змінні
        System.out.println("Введіть n: ");// просимо ввести перше число
        n = scanner.nextInt();// скануємо шо там ввів користувач і записуємо це число в змінну
        System.out.println("Введіть r: ");// просимо ввести друге число
        r = scanner.nextInt();// скануємо шо там ввів користувач і записуємо це число в іншу змінну
        if((n >= 1) & (r >= 1)){//якщо числа більші рівні 1
            List<String[]> numbers = new ArrayList<>();
            String[] currentNumber = new String[r];// оголошуємо наше початкове число в перестановці як масив стрічок розмірності яку ввів користувач
            String[] lastNumber = new String[r];// оголошуємо наше останнє число в перестановці
            for(int i = 0; i < r; i++){// поки довжина нашого першого числа не буде як наше число яке ми задали
                currentNumber[i] = "1" ;// додаємо до першого числа 1(не число, а стрічку) тобто якщо було 1 стало 11 потім 111 ітд
                lastNumber[i] = String.valueOf(n);// додаємо до нашого останнього числа наше останнє число яке ввів користувач, тобто було допустимо 59 стало 5959 потім 595959 ітд
            }
            int i = 1, j = r-1, counter = 0;//оголошуємо змінні (і - наше крайнє число, j - індекс числа)
            while (!Arrays.equals(currentNumber, lastNumber)){// робимо це все що нижче поки в нас наче поточне число не буде дорівнювати останньому
                for (int k = 0; k < currentNumber.length; k++) {// проходимося по цифрах нашого числа, щоб зробити здвиги тобто якщо в нас було 1115 (максимальне число 5) то має стати 1121
                    if (currentNumber[k].equals(String.valueOf(n)) && k != 0 && Integer.parseInt(currentNumber[k-1]) < n){//якщо це крайнє число то
                        currentNumber[k] = "1";//ми його знінюємо на 1
                        currentNumber[k-1] = String.valueOf(Integer.parseInt(currentNumber[k-1])+1);//то шо лівіше додаємо 1
                    }
                }
                currentNumber[j] = String.valueOf(i);// зберігаємо
                i++;// додаємо 1 до числа
                if (i == n+1){// якщо число крайнє
                    i = 1;// робимо його 1
                }
                String[] temporaryNumber = currentNumber.clone();
                Arrays.sort(temporaryNumber);
                if (!numbers.stream().anyMatch(a -> Arrays.equals(a, temporaryNumber))){
                    numbers.add(temporaryNumber);
                    counter++;
                    System.out.println(Arrays.toString(currentNumber));// виводимо його в консоль
                }
            }
            System.out.println(counter);// виводимо скільки в нас було чисел
        }
















//        if((n >= 1) & (r >= 1)){
//            Set<List<String>> numbers = new HashSet<>();
//            List<String> currentNumber = new ArrayList<>();// оголошуємо наше початкове число в перестановці
//            currentNumber.add("1");
//            List<String> lastNumber = new ArrayList<>();// оголошуємо наше останнє число в перестановці (парсимо з числа строку)
//            lastNumber.add(String.valueOf(n));
//            while (currentNumber.size() < r){// поки довжина нашого першого числа не буде як наше число яке ми задали
//                currentNumber.add("1") ;// додаємо до першого числа 1(не число, а стрічку) тобто якщо було 1 стало 11 потім 111 ітд
//                lastNumber.add(String.valueOf(n));// додаємо до нашого останнього числа наше останнє число яке ввів користувач, тобто було допустимо 59 стало 5959 потім 595959 ітд
//            }
//            int i = 1, j = r-1;
//            while (!currentNumber.equals(lastNumber)){
//                System.out.println(currentNumber);
//                List<String> numbersClone = new ArrayList<>();
//                numbersClone.addAll(currentNumber);
//                numbersClone.sort(String::compareTo);
//                numbers.add(numbersClone);
//                currentNumber.remove(j);
//                currentNumber.add(j, String.valueOf(i));
//                if (i == n){
//                    i = 1;
//                    int k = Integer.parseInt(currentNumber.get(j))+1;
//                    currentNumber.remove(j);
//                    currentNumber.add(j, String.valueOf(k));
//                    if (j == 0){
//                        j = r-1;
//                    }else {
//                        j--;
//                    }
//
//                }else i++;
//
//            }
//            System.out.println(numbers.size());
//        }
    }
}
