// Created by Brandon Watts.

import java.util.Scanner;
import java.util.Stack;

public class cmsc401Assignment1 {

    /**Member Variables**/
    public static Stack<Integer> inputStack,outputStack;
    public static int[] stateArray;
    public static Scanner scanner;
    
    public static void main(String[] args)
    {
        scanner = new Scanner(System.in);
        inputStack = new Stack<>(); //to read input
        outputStack = new Stack<>(); //to push output
        inputtoStack(); //turn given input into stack
        initializeStateArray(stateArray = new int[inputStack.size()]);
        calculate();
        printStack(outputStack);
    }

    private static void printStack(Stack<Integer> outputStack) {
        while(outputStack.size()>0)
            System.out.println(outputStack.pop());
    }

    private static void calculate() {
        while(inputStack.size()>0) //while there are still input to read
        {
            int target=-1; //what is the next element
            int targetPosition=stateArray.length;//where is it at
            int positionAway = inputStack.pop(); //how far is input away
            for (int i = stateArray.length-1;i>=0;i--) //look for an input that is desired position away
            {
                target+=stateArray[i];
                targetPosition--;
                if(target==positionAway)
                    break;
            }
            outputStack.push(targetPosition+1); //add that to output
            stateArray[targetPosition]=0; //set that position to taken
        }
    }

    private static void initializeStateArray(int[] emptyArray) {
        for(int i=0;i<emptyArray.length;i++)
        {
            emptyArray[i] = 1;
        }
    }

    private static void inputtoStack() {
        int inputTimes = Integer.parseInt(scanner.nextLine()); //how many lines?

        for (int i = 0; i < inputTimes; i++) {  //grab the lines and stick them in an stack
            inputStack.push(Integer.parseInt(scanner.nextLine()));
        }

    }
}
