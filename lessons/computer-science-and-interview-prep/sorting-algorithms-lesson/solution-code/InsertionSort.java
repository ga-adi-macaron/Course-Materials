package InsertionSort;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {7, 3, 2, 4, 9, 1, 14, 12};
		doInsertionSort(arr);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}

	private static void doInsertionSort(int[] input) {
		int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--) {
                if(input[j] < input[j-1]) {
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                    System.out.println("Swapped " + j + " with " + temp);
                }
            }
        }
        
	}
}
