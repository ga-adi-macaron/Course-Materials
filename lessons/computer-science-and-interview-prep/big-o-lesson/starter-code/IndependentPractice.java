// function 1

public static void main(String[] args) {
    int[] myNumArray = {3, 9, 12, 1, 7, 17, 5, 4, 12, 2, 13};
    int total = firstFunction(myNumArray);
    int otherTotal = secondFunction(myNumArray);

    //ignore the sort
    Arrays.sort(myNumArray);
    boolean myBool = thirdFunction(myNumArray, 5);
}

private static int firstFunction(int[] numArray) {
	int total = 0;

	for(int i = 0; i < numArray.length; i++) {
		total += numArray[i];
	}

	for(int i = 0; i < numArray.length; i++) {
		if(numArray[i] /2 < i) {
			total -= numArray[i] / 2;
		}
	}
	return total;
}


// function 2

private static int secondFunction(int[] numArray) {
	int total = 0;

	for(int i = 0; i < numArray.length; i++) {
		total += numArray[i] / (i+1);
	}
	for(int i = 0; i < numArray.length; i++) {
		for(int j = 0; j < i; j++) {
			total += i-j;
		}
	}
	return total;
}

// function 3

private static boolean thirdFunction(int[] numArray, int key) {
	int start = 0;
    int end = numArray.length - 1;
    while (start <= end) {
        int mid = (start + end) / 2;
        if (key == numArray[mid]) {
            return true;
        }
        if (key < numArray[mid]) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    return false;
}
