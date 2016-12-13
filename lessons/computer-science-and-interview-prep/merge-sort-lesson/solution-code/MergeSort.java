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
        if (nums.length <= 1) {
            return nums;
        }

        // Split the array in half
        int[] first = new int[nums.length / 2];
        int[] second = new int[nums.length - first.length];
        System.arraycopy(nums, 0, first, 0, first.length);
        System.arraycopy(nums, first.length, second, 0, second.length);

        // Sort each half
        mergeSort(first);
        mergeSort(second);

        // Merge the halves together, overwriting the original array
        merge(first, second, nums);
        return nums;
    }

    private static void merge(int[] first, int[] second, int [] result){
        // Next element to consider in the first array
        int iFirst = 0;
        // Next element to consider in the second array
        int iSecond = 0;

        // Next open position in the result array
        int j = 0;
        // As long as neither iFirst nor iSecond is past the end, move the
        // smaller element into the result.
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst];
                iFirst++;
            } else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        // copy what's left One (or both) of these will do nothing, since at least one of the two arrays
        // being merged has been completed
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }
}
