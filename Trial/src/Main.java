import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner;
    static ArrayList<String> possibleLines;
    static ArrayList<Integer> sums;
    static int sum = 0;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        possibleLines = new ArrayList<>();
        sums = new ArrayList<>();
        acceptInputs();
        calculate();
        printSums();

    }

    private static void printSums() {

        for (int syum :
                sums) {
            System.out.println(sum);
        }

    }

    private static void calculate() {
        for (int i = 0; i < possibleLines.size(); i++) {
            String unformattedString = possibleLines.get(i);

            String[] addedIndexes = unformattedString.substring(unformattedString.length() - 3).split(" ");


            int firstNumber = Integer.parseInt(addedIndexes[0]);
            int secondNumber = Integer.parseInt(addedIndexes[1]);

            String[] arrayofint = unformattedString.substring(1, unformattedString.length() - 2).split(" ");


            sum += (Integer.parseInt(arrayofint[firstNumber]) + Integer.parseInt(arrayofint[secondNumber]));
            sums.add(sum);
            sum = 0;
        }
    }

    private static void acceptInputs() {

        int inputTimes = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < inputTimes; i++) {
            possibleLines.add(scanner.nextLine().trim());
        }

    }


}
