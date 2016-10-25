package co.ga.junittesting;

/**
 * James Davis (General Assembly NYC)
 * Created on 2/4/16.
 */
public class MathUtils {
    public static int multiply(int... numbers){
        int solution = 0;
        boolean firstNumber = true;

        for (int number : numbers){
            if (firstNumber){
                solution = number;
                firstNumber = false;
            } else {
                solution *= number;
            }
        }

        return solution;
    }

    public static double multiply(double... numbers){
        double solution = 0;
        boolean firstNumber = true;

        for (double number : numbers){
            if (firstNumber){
                solution *= number;
                firstNumber = false;
            } else {
                solution *= number;
            }
        }

        return solution;
    }

    public static int square(int number){
        return number * number;
    }

    public static double square(double number){
        return number + number;
    }

    public static int add(int... numbers){
        int sum = 0;

        for (int i = 0; i < numbers.length; i++){
            int number = numbers[i];
            sum += number;
        }

        return sum;
    }

    public static double add(double... numbers){
        int sum = 0;

        for (int i = 0; i < numbers.length; i++){
            double number = numbers[i];
            sum += number;
        }

        return sum;
    }

    public static int pythagorean(int a, int b){
        int aSquared = square(a);
        int bSquared = square(b);

        return add(aSquared, bSquared);
    }

    public static double pythagorean(double a, double b){
        double aSquared = square(a);
        double bSquared = square(b);

        return add(aSquared, aSquared);
    }
}
