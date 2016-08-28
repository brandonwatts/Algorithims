/**Brandon Watts**/

import java.util.ArrayList;
import java.util.Scanner;

public class cmsc401 {

    static Scanner scanner;
    static ArrayList<String> possibleLines;
    static ArrayList<Integer> sums;
    static int sum, firstNumber, secondNumber;
    static String[] arrayofint;


    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        possibleLines = new ArrayList<>();
        sums = new ArrayList<>();
        acceptInputs();
        calculate();
        printSums();

    }

    private static void printSums() {
        sums.forEach(System.out::println); //print
    }

    private static void calculate() {
        for (int i = 0; i < possibleLines.size(); i++) {

            String unformattedString = possibleLines.get(i); //grab the first input
            String[] addedIndexes = unformattedString.substring(unformattedString.length() - 3).split(" ");//format it
            firstNumber = Integer.parseInt(addedIndexes[0]); //what is the first position
            secondNumber = Integer.parseInt(addedIndexes[1]); //what is the second position

            arrayofint = unformattedString.substring(1, unformattedString.length() - 2).split(" "); //what is the array we need

            sum += (Integer.parseInt(arrayofint[firstNumber]) + Integer.parseInt(arrayofint[secondNumber])); //compute
            sums.add(sum);//add the sum to the arrayList
            sum = 0; //set sum to 0 for next iteration
        }
    }

    private static void acceptInputs() {

        int inputTimes = Integer.parseInt(scanner.nextLine()); //how many lines?

        for (int i = 0; i < inputTimes; i++) {  //grab the lines and stick them in an arraylist
            possibleLines.add(scanner.nextLine().trim());
        }

    }

}
