package BubbleSort;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {10, 15, 1, 3, 14, 2, 17, 9, 51, 6, 16, 22, 8};
		bubbleSort(arr);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	private static void bubbleSort(int[] input) {
		int temp;
		int swaps;
		for(int i = 1; i < input.length; i++) {
			swaps = 0;
			for(int j = 0; j < input.length - i; j++) {
				if(input[j] > input[j + 1]) {
					temp = input[j+1];
					input[j+1] = input[j];
					input[j] = temp;
					swaps++;
				}
			}
			if(swaps == 0) {
				System.out.println("Quit after pass #" + i + " of " + input.length);
				break;
			}
		}
		
	}

}
