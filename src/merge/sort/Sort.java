package merge.sort;

class Sort {	
	public void sort(int[] arr) {
		int n = arr.length;
		
		if (n < 2) return;
		
		int mid = n/2;
		
		int[] left = new int[mid];
		int[] right = new int[n - mid];
		
		for(int i = 0; i < mid; i++) {
			left[i] = arr[i];
		}
		
		for (int i = mid; i < n; i++) {
			right[i - mid] = arr[i];
		}
		
		sort(left);
		sort(right);
		merge(left, right, arr);
	}
	
	private void merge(int[] left, int[] right, int[] arr) {
		int leftLength = left.length;
		int rightLength = right.length;
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < leftLength && j < rightLength) {
			if(left[i] < right[j]) {
				arr[k] = left[i];				
				i++;
			} 
			else if (left[i] > right[j]) {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		
		while(i < leftLength) {
			arr[k] = left[i];
			i++;
			k++;
		}
		while(j < rightLength) {
			arr[k] = right[j];
			k++;
			j++;
		}
	}
}
