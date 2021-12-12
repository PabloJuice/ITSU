package com.pablojuice.math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<String[]> numbers = new HashSet<>();
        if (n >= 1){
            String[] number = new String[n];
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n+1; j++) {
                    int k = j+n;
                    if (k > n+1){
                        k -= n+1;
                    }
                    number[k] = String.valueOf(j);
                }
                System.out.println(Arrays.toString(number));
            }
        }
    }
}
