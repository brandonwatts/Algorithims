import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Brandon Watts on 9/11/2016.
 */
public class Assingment1 {
    
    public static Stack<Integer> inputStack,outputStack;
    public static int[] stateArray;
    public static Scanner scanner;
    
    public static void main(String[] args)
    {

        scanner = new Scanner(System.in);
        inputStack = new Stack<>();
        outputStack = new Stack<>();
        inputtoStack();
        initializeStateArray(stateArray = new int[inputStack.size()]);
        calculate();
        printStack(outputStack);
        
        
        
    }

    private static void printStack(Stack<Integer> outputStack) {
        while(outputStack.size()>0)
            System.out.println(outputStack.pop());
    }

    private static void calculate() {

        while(inputStack.size()>0)
        {
            int target=-1;
            int targetPosition=stateArray.length;
            int positionAway = inputStack.pop();
            for (int i = stateArray.length-1;i>=0;i--)
            {
                target+=stateArray[i];
                targetPosition--;
                if(target==positionAway)
                {
                    break;
                }

            }
            outputStack.push(targetPosition+1);
            stateArray[targetPosition]=0;
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
