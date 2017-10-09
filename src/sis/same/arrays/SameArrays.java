package sis.same.arrays;

import java.util.Scanner;

class SameArrays {
	public static void sort(int[] arr, int start, int end) {
		if (start >= end) return;
		int mid = (start + end)/2;
		sort(arr, start, mid);
		sort(arr, mid + 1, end);
		merge(arr, start, mid, end);	
	}
	
	public static void merge(int[] arr, int start, int mid, int end) {
		int left = start;
		int right = mid + 1;
		int n = end - start + 1;
		int[] brr = new int[n];
		for (int i = 0; i < n; i++) {
			if(left > mid) {
				brr[i] = arr[right];
				right++;
			}
			else if(right > end) {
				brr[i] = arr[left];
				left++;
			}
			else if(arr[left] <= arr[right]) {
				brr[i] = arr[left];
				left++;
			}
			else {
				brr[i] = arr[right];
				right++;
			}
		}
		
		for(int i = 0; i < n; i++) {
			arr[i + start] = brr[i];
		}
	}
	
	public static boolean check(int[] arr, int[] brr) {
		int i = 0, j = 0;
		while(i < arr.length && j < brr.length) {
			if(brr[j] != arr[i]) return false;
			while(i + 1 != arr.length && arr[i] == arr[i + 1]) i++;
			while(j + 1!= brr.length && brr[j] == brr[j + 1]) j++;	
			j++;
			i++;
		}
		return arr.length == i && brr.length == j;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a, b;
		
		a = in.nextInt();		
		int[] arr = new int[a];		
		for (int i = 0; i < a; i++) {
			arr[i] = in.nextInt();
		}
		
		b = in.nextInt();
		int[] brr = new int[b];
		for (int i = 0; i < b; i++) {
			brr[i] = in.nextInt();
		}
		in.close();
		
		sort(arr, 0, a - 1);
		sort(brr, 0, b - 1);
		
		System.out.println(check(arr, brr) ? "YES" : "NO");		
	}
}
