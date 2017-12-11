package counting.sort;

import java.util.Scanner;

class CountingSort {
	public static int[] sort(int[] arr) {
		int[] array = new int[arr.length];
		
		int max;
		int min = max = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] < min) min = arr[i];
			else if(arr[i] > max) max = arr[i];
		}
		
		int[] counts = new int[max - min + 1];
		
		for (int i = 0; i < arr.length; i++)  
			counts[arr[i] - min]++;
			
		counts[0]--;
		for (int i = 1; i < counts.length; i++) 
			counts[i] += counts[i - 1];
		
		for (int i = 0; i < arr.length; i++) 
			array[counts[arr[i] - min]--] = arr[i];
				
		return array;	
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] unsorted = new int[n]; 
		for (int i = 0; i < unsorted.length; i++) 
			unsorted[i] = in.nextInt();
		in.close();
	    int [] sorted = sort(unsorted);
	    for (int i = 0; i < sorted.length; i++) 
	    	System.out.println(sorted[i]);
	}

}
