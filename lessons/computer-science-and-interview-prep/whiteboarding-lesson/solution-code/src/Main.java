import java.util.Arrays;

/**
 * Created by drewmahrt on 4/28/16.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Most appearances(racecar): "+findFirstNonRepeated("racecar"));
        System.out.println("Most appearances(a): "+findFirstNonRepeated("a"));

        System.out.println("Missing100(10): "+missing100(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println("Missing100(1): "+missing100(new int[]{2,3,4,5,6,7,8,9,10}));
        System.out.println("Missing100(5): "+missing100(new int[]{1,4,3,2,6,7,8,10,9}));

        System.out.println("SecondHighest(4): "+secondHighest(new int[]{-5,-4,0,2,4,5}));
        System.out.println("SecondHighest(0): "+secondHighest(new int[]{-5,-4,-3,-2,-1,0}));

        System.out.println("everyNth(Mrce): "+everyNth("Miracle", 2));
        System.out.println("everyNth(aceg): "+everyNth("abcdefg", 2));
        System.out.println("everyNth(adg): "+everyNth("abcdefg", 3));

        System.out.println("EvenOrOdd(neither): "+evenOrOdd(new int[]{1,2,3,4}));
        System.out.println("EvenOrOdd(even): "+evenOrOdd(new int[]{1,2,4}));
        System.out.println("EvenOrOdd(odd): "+evenOrOdd(new int[]{1,2,3}));
    }

    //1. Find the character that appears the most time in a given string (ie "tomorrow" should return 'o')
    public static char findFirstNonRepeated(String str){

        char mostAppearances = str.charAt(0);
        int numAppearances = 1;

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            int currentCount = 0;
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == currentChar){
                    currentCount++;
                }
            }

            if(currentCount > numAppearances){
                numAppearances = currentCount;
                mostAppearances = currentChar;
            }else if(currentCount == numAppearances && currentChar > mostAppearances){
                mostAppearances = currentChar;
            }
        }

        return mostAppearances;
    }

    //2. An array is supposed to contain the numbers 1-100, but one number is missing. Find and return that number.
    public static int missing100(int[] arr){
        Arrays.sort(arr);

        int current = 1;

        for(int i=0; i<arr.length; i++){
            if(current != arr[i]){
                return current;
            }
            current++;
        }

        return 10;
    }

    //3. Write a method that finds the second highest number in an array of integers WITHOUT using a sort method.
    public static int secondHighest(int[] nums){
        int highest = Integer.MIN_VALUE+1;
        int second = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > highest){
                second = highest;
                highest = nums[i];
            }else if(nums[i] > second){
                second = nums[i];
            }
        }
        return second;
    }

    //4. Given a non-empty string and an int N, return the string made starting with char 0, and then every Nth char of the string. So if N is 3, use char 0, 3, 6, ... and so on. N is 1 or more.
    public static String everyNth(String str, int n) {
        String result = "";

        // Look at every nth char
        for (int i=0; i<str.length(); i = i + n) {
            result = result + str.charAt(i);
        }
        return result;
    }

    //5. Given an array of ints, return the string "even" if there are more even elements in the array, or "odd" if there are more odd elements in the array.
    public static String evenOrOdd(int[] nums){
        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0){
                evenCount++;
            }else{
                oddCount++;
            }
        }

        if(evenCount > oddCount)
            return "even";
        else if(oddCount > evenCount)
            return "odd";
        else
            return "neither";
    }

}
