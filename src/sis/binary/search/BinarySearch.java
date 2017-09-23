package sis.binary.search;

import java.util.Scanner;

class BinarySearch {
	public static String binarySearch(int[] arr, int number) {
		int left = 0;
		int right = arr.length - 1;
		int mid;
		while(left < right) {
			mid = (left + right)/2;
			if(number <= arr[mid]) right = mid;
			else left = mid + 1;
		}
		return arr[right] == number ? "YES" : "NO";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] a = new int[n];
		int[] b = new int[k];
		for(int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		for(int i = 0; i < k; i++) {
			b[i] = in.nextInt();
		}
		for(int i = 0; i < k; i++) {
			System.out.println(binarySearch(a, b[i]));
		}
		in.close();
	}

}
