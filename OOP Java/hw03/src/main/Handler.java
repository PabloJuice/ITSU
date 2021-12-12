package main;

import java.util.*;
public class Handler {
    public static void main(String[] args) {
//        ControllerAndView.drawTriangle(new Triangle("lol",".",10));
//        System.out.println();
        long lol = 1000_______________00_____________________________00;
        System.out.println(lol);
        ArrayList<Triangle> triangles = new ArrayList<>();
        triangles.add(new Triangle("", ".", 5));
        ControllerAndView.Tree(triangles, 5);
        ControllerAndView.TreeTriangle(new Triangle("lol",".",10), 2);
    }
}
class Triangle {
    String type;
    String symbol;
    int size;
    Triangle(String type, String symbol, int size) {
        this.type = type;
        this.size = size;
        this.symbol = symbol;
    }
}
class ControllerAndView {
    public static void drawTriangle(Triangle triangle){
        int i, j = 0;
        M:for (i = 0; i < triangle.size; i++) {
        switch (triangle.type){
            case "RightTop":
                    baseBottom(i-1, " ");
                    baseTop(i, triangle.size, triangle.symbol);
                break;
            case "RightBottom":
                    baseTop(i, triangle.size-1, " ");
                    baseBottom(i, triangle.symbol);
                break;
            case "LeftBottom":
                    baseBottom(i, triangle.symbol);
                    baseTop(i, j, " ");
            case "LeftTop":
                    baseTop(i, triangle.size, triangle.symbol);
            default:
                System.out.println("invalid");
                break M;
        }
            System.out.println();
        }
        }
    static void Tree(List<Triangle> triangles, int shift) {
        shift *= 2;
        int arraySize = triangles.size(), i = triangles.get(arraySize-1).size;
        for (Triangle triangle : triangles) {
            TreeTriangle(triangle, (shift + i - triangle.size)/2);
        }
    }
    static void TreeTriangle(Triangle triangle, int shift) {
        int i;
        int size = triangle.size;
        String symbol = triangle.symbol;
        for (i = 0; i < size; i+=2) {
            displayBasicShift(shift);
            baseTop((i/2), (size-1)/2,  " ");
            baseBottom(i, symbol);
            System.out.println();
        }
    }

    static void baseTop(int row, int rowCount, String symbol) {
        for (int column = row; column < rowCount; column++) {
            System.out.print(symbol);
        }
    }
    static void baseBottom(int row, String symbol) {
        for (int column = -row; column < 1; column++) {
            System.out.print(symbol);
        }
    }
    static void displayBasicShift(int shift) {
        for(int j = 0; j < shift; j++) {
            System.out.print(" ");
        }
    }
}
