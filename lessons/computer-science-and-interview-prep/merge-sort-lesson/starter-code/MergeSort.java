/**
 * Created by drewmahrt on 3/15/16.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] numbers  = new int[]{5,12,2,32,-2,-10,-1,100,16,101};

        System.out.println("Unsorted numbers:");
        for (int i=0;i<numbers.length;i++) {
            System.out.println(String.valueOf(numbers[i]));
        }

        numbers = mergeSort(numbers);

        System.out.println("Sorted numbers:");
        for (int i=0;i<numbers.length;i++) {
            System.out.println(String.valueOf(numbers[i]));
        }
    }

    private static int[] mergeSort(int[] nums){
        //Complete this method first
    }

    private static void merge(int[] first, int[] second, int [] result){
        //Complete this method second
    }
}
