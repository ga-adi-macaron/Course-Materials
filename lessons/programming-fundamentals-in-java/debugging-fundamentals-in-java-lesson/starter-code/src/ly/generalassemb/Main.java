package ly.generalassemb;

import java.util.Scanner;

/**
 * Created by drewmahrt on 5/4/16.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== INTEGER CALCULATOR ===\n");

        String choice = getInput("Choose an operation: \n1. add\n2. subtract\n3. multiply\n4. divide\n");

        if(choice.equals("1") || choice.equals("add")){
            add();
        } else if(choice.equals("2") || choice.equals("subtract")){
            subtract();
        } else if(choice.equals("3") || choice.equals("multiply")){
            multiply();
        } else if(choice.equals("4") || choice.equals("divide")){
            divide();
        } else {
            System.out.println("Invalid input!");
        }
    }

    public static String getInput(String context){
        System.out.print(context+": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void add(){
        int firstNum = Integer.parseInt(getInput("First number"));
        int secondNum = Integer.parseInt(getInput("Second number"));
        int result = firstNum + secondNum;
        System.out.println("Result: "+result);
    }

    public static void subtract(){
        int firstNum = Integer.parseInt(getInput("First number"));
        int secondNum = Integer.parseInt(getInput("Second number"));
        int result = firstNum - secondNum;
        System.out.println("Result: "+result);
    }

    public static void multiply(){
        int firstNum = Integer.parseInt(getInput("First number"));
        int secondNum = Integer.parseInt(getInput("Second number"));
        int result = firstNum * secondNum;
        System.out.println("Result: "+result);
    }

    public static void divide(){
        int firstNum = Integer.parseInt(getInput("First number"));
        int secondNum = Integer.parseInt(getInput("Second number"));
        int result = firstNum / secondNum;
        System.out.println("Result: "+result);
    }

}
