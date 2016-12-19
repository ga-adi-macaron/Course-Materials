package ly.generalassemb;

import java.util.HashMap;

public class Main {

    // 1. Write a method to reverse an array and calculate the Big O for your algorithm.
    //      You can't use the built in reverse method for Java!
    public static <T> void reverseArray(T[] array) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        while (leftIndex < rightIndex) {
            T temp = array[leftIndex];
            array[leftIndex] = array[rightIndex];
            array[rightIndex] = temp;

            leftIndex++;
            rightIndex--;
        }
    }
    // O(n) - loops through the array once - it moves from both ends to the middle, rather than from beginning to end,
    // but each element is still covered just once


    // 2. Find the first non-repeated character in an array of characters and calculate the Big O for your algorithm.
    public static char findFirstNonRepeatedChar(char[] chars) {
        HashMap<Character, Integer> charCounts = new HashMap<>();
        for (char c : chars) {
            charCounts.put(c, charCounts.containsKey(c) ? charCounts.get(c) + 1 : 1);
        }
        for (char c : chars) {
            if (charCounts.get(c) == 1) {
                return c;
            }
        }
        return Character.MIN_VALUE;
    }
    // O(n) - two consecutive, non-nested loops through the array would be O(2n), which reduces to O(n)


    // 3. An array is supposed to contain the numbers 1-100 in order, but one number is missing.
    //      Write a method to find the missing number and calculate its Big O.
    public static int findMissingNumber(int[] ints) {
        return findMissingNumber(ints, 0, ints.length - 1);
    }

    private static int findMissingNumber(int[] ints, int start, int end) {
        if (start >= end) {
            if (ints[end] > end + 1) {
                return end + 1;
            } else {
                return end + 2;
            }
        }

        // if no numbers were missing, then ints[i] would always equal i + 1
        int midpoint = (start + end) / 2;
        if (ints[midpoint] > midpoint + 1) {
            return findMissingNumber(ints, 0, midpoint);
        } else {
            return findMissingNumber(ints, midpoint + 1, end);
        }
    }
    // O(log(n)) - this is a binary search approach that cuts the input in half for each recursive call


    // 4. Given two arrays of integers which are identical except for a single element,
    //      write a method to find which number is different in the second array. Find your algorithm's Big O.
    public static int findDifferentNumber(int[] a, int[] b) {
        // a and b will have same length
        for (int i = 0; i < a.length; i++) {
            if (b[i] != a[i]) {
                return b[i];
            }
        }
        return Integer.MIN_VALUE;
    }
    // O(n) - single loop through both arrays - if the input arrays are not sorted the same way, then you would
    // also need to sort each before doing this loop. That sorting step would probably be O(n*log(n)), depending
    // on which algorithm you use, so the total running time then would be O(n*log(n))


    // 5. Write a method that finds the second highest number in an unsorted array of integers.
    //      Calculate the Big O of your algorithm.
    public static int findSecondHighestNumber(int[] ints) {
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int x : ints) {
            if (x > highest) {
                secondHighest = highest;
                highest = x;
            }
        }

        return secondHighest;
    }
    // O(n) - one loop through the array
}
