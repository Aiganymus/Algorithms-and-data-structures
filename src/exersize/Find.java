package exersize;

import java.util.Scanner;

class Find {
	public static int findTop(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		int mid;
		while(start < end) {
			mid = (start + end)/2;
			
			if (end == start + 1) {
				if(arr[mid] > arr[mid + 1]) return arr[mid];
				return arr[mid + 1];
			}
			
			if(arr[mid - 1] < arr[mid]) start = mid;
			else end = mid;
		}
		
		return arr[end];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a;		
		a = in.nextInt();	
		int[] arr = new int[a];		
		for (int i = 0; i < a; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println(findTop(arr));
		in.close();
	}
}
