package Main;

public class Main {
    public static void main(String[] args) {
        int a = 10; String name = null;
        try {
            a = name.length();
            a++;
        }
        catch (RuntimeException e){
            ++a;
        }
        System.out.println(a);
    }
}
