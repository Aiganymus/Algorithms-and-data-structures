package merge.sort;

import java.util.Scanner;

class Test {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		in.close();
		
		MergeSort.mergeSort(arr, 0, n - 1);
				
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
        }
	}
}
