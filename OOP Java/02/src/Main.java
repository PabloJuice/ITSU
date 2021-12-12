public class Main {
    public static void main(String[] args) {
        for(int row = 0; row < 10; row++){//lefttop
            for(int column = row; column < 10; column++){
                System.out.print(".");
            }
            System.out.println();
        }
        System.out.println();
        for(int row = 0; row < 10; row++){//leftbot
            for(int column = -row; column < 1; column++){
                System.out.print(".");
            }
            System.out.println();
        }
        System.out.println();

        for(int row = 0; row < 10; row++){//righttop
            for(int column = -row +1; column < 1; column++){
                System.out.print(" ");
            }
            for(int column = row; column < 10; column++){
                System.out.print(".");
            }
            System.out.println();
        }
        System.out.println();
        for(int row = 0; row < 10; row++){//rightbot
            for(int column = row+1; column < 10; column++){
                System.out.print(" ");
            }
            for(int column = -row; column < 1; column++){
                System.out.print(".");
            }
            System.out.println();
        }
        System.out.println();

        int shift = 5;
        for (int count = 0; count < 3; count++) {
            for (int row = 0; row < 5; row++) {

                for(int column = row-shift; column < 5; column++){
                    System.out.print(" ");
                }
                for(int column = -row; column < 1; column++){
                    System.out.print("..");
                }
                System.out.println();
            }
        }


    }
}
