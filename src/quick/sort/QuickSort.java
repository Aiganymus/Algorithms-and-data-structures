package quick.sort;

import java.util.Scanner;

class QuickSort {
	
	public static void sort(int[] arr, int start, int end) {
		if(start < end) {
			int pivot = partition(arr, start, end);
				
			sort(arr, start, pivot - 1);
			sort(arr, pivot + 1, end);
		}
	}

	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int pIndex = start;
		int temp;
		for (int i = start; i < end; i++) {
			if(arr[i] <= pivot) {
				temp = arr[i]; 
				arr[i] = arr[pIndex];
				arr[pIndex] = temp;
				pIndex++;
			}
		}
		
		temp = arr[pIndex]; 
		arr[pIndex] = arr[end];
		arr[end] = temp;
		
		return pIndex;
	
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) 
			arr[i] = in.nextInt();
		in.close();
		sort(arr, 0, n - 1);
		for (int i = 0; i < n; i++) 
			System.out.print(arr[i] + " ");
	}

}
