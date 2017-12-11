package insertion.sort;

import java.util.Arrays;

class InsertionSort {
	public static void sort(int[] arr) {
		int n = arr.length;
		int value, index;
		for (int i = 1; i < n; i++) {
			value = arr[i];
			index = i;
			
			while (index > 0 && arr[index - 1] > value) {
				arr[index] = arr[index - 1];
				index--;
			}
			arr[index] = value;
		}
	}

	public static void main(String[] args) {
		int[] arr = {3, 5, 1, 7, 5, 6};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
