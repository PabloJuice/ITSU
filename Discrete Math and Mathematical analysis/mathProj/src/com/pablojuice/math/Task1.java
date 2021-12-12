package com.pablojuice.math;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean p,q;
        while(true){
            System.out.println("Введіть p: ");
            p = scanner.nextBoolean();
            System.out.println("Введіть q: ");
            q = scanner.nextBoolean();
            boolean conjunction = p&q;
            boolean disjunction = p|q;
            boolean xor = p^q;
            boolean implication = (!p)|q;
            boolean equality = p == q;
            System.out.println("Кон'юнкція: " + conjunction);
            System.out.println("Диз'юнкція: " + disjunction);
            System.out.println("ХОР: " + xor);
            System.out.println("Імплікація: " + implication);
            System.out.println("Еквівалентність: " + equality);
        }
    }
}
