import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть дані: ");
        String input = scanner.nextLine();
        Converter converter = new Converter();
        converter.convert(input);
        System.out.println(converter.getResult());
    }
}
class Converter{

    String result = "";
    String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    String[] marks = {"Unsatisfactory", "Unsatisfactory", "Unsatisfactory", "Satisfactory", "Good", "Excellent"};
    String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Friday", "Jupiter", "Saturn", "Uran", "Neptune"};

    public void convert(String input){
        for (char i:input.toCharArray()) {
            if (Character.isDigit(i)){
                if (input.toUpperCase().startsWith("WEEK_DAYS")){
                    result+=weekDays[Character.getNumericValue(i) - 1];
                }else if (input.toUpperCase().startsWith("MARKS")){
                    result+=marks[Character.getNumericValue(i)];
                }else if (input.toUpperCase().startsWith("PLANETS")) {
                    result += planets[Character.getNumericValue(i) - 1];
                }
                result+=" ";
            }

        }
    }

    public String getResult() {
        return result;
    }
}
