package merge.sort;

public class MergeSort {
	public static void mergeSort(int[] arr, int start, int end) {
		if(start >= end) return;
		int mid = (start + end)/2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, end);
		merging(arr, start, mid, end);
	}
	
	private static void merging(int[] arr, int start, int mid, int end) {
		int n = end - start + 1;
		int[] b = new int[n];
		int left = start; 
		int right = mid + 1;
		for (int i = 0; i < n; i++) {
			if(left > mid) {
				b[i] = arr[right];
				right++;
			}
			else if (right > end) {
				b[i] = arr[left];
				left++;
			}
			else if (arr[left] <= arr[right]) {
				b[i] = arr[left];
				left++;
			}
			else {
				b[i] = arr[right];
				right++;
			}
		}	
		for (int i = 0; i < n; i++) {
			arr[i + start] = b[i];
		}
	}
}
