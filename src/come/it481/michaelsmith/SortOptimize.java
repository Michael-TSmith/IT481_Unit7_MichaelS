package come.it481.michaelsmith;

import java.util.Arrays;
import java.util.Random;

public class SortOptimize {
	
	private static long mergeSortStart;
	private static long mergeSortEnd;
	private static long bubbleSortStart;
	private static long bubbleSortEnd;
	private static long quickSortStart;
	private static long quickSortEnd;
	
	public static void main(String[] args) {
		int[] smallArray = new int[1000];
		int[] mediumArray = new int[10000];
		int[] largeArray = new int[100000];
		populateArray(smallArray);
		populateArray(mediumArray);
		populateArray(largeArray);
		
	//Merge sort
		
			//Small array
				mergeSortStart = System.currentTimeMillis();
				mergeSort(smallArray);
				mergeSortEnd = System.currentTimeMillis();
				System.out.println("Small Array: " + Arrays.toString(smallArray));
				System.out.println("Merge Sort Time: " + (mergeSortEnd - mergeSortStart));
		
			//Medium array
				mergeSortStart = System.currentTimeMillis();
				mergeSort(mediumArray);
				mergeSortEnd = System.currentTimeMillis();
				System.out.println("Medium Array: " + Arrays.toString(mediumArray));
				System.out.println("Merge Sort Time: " + (mergeSortEnd - mergeSortStart));
		
			//Large array
				mergeSortStart = System.currentTimeMillis();
				mergeSort(largeArray);
				mergeSortEnd = System.currentTimeMillis();
				System.out.println("Large Array: " + Arrays.toString(largeArray));
				System.out.println("Merge Sort Time: " + (mergeSortEnd - mergeSortStart));
		
	//Quick Sort

				populateArray(smallArray);
				populateArray(mediumArray);
				populateArray(largeArray);
		   //Small array
				quickSortStart = System.currentTimeMillis();
				quickSort(smallArray, 0, smallArray.length - 1);
				quickSortEnd = System.currentTimeMillis();
				System.out.println("Small Array: " + Arrays.toString(smallArray));
				System.out.println("Quick Sort Time: " + (quickSortEnd - quickSortStart));

			//Medium array
				quickSortStart = System.currentTimeMillis();
				quickSort(mediumArray, 0, mediumArray.length - 1);
				quickSortEnd = System.currentTimeMillis();
				System.out.println("Small Array: " + Arrays.toString(mediumArray));
				System.out.println("Quick Sort Time: " + (quickSortEnd - quickSortStart));

			//Large array
				quickSortStart = System.currentTimeMillis();
				quickSort(largeArray, 0, largeArray.length - 1);
				quickSortEnd = System.currentTimeMillis();
				System.out.println("Small Array: " + Arrays.toString(largeArray));
				System.out.println("Quick Sort Time: " + (quickSortEnd - quickSortStart));
		
	//Bubble Sort

				populateArray(smallArray);
				populateArray(mediumArray);
				populateArray(largeArray);
			//Small array
				bubbleSortStart = System.currentTimeMillis();
				bubbleSort(smallArray);
				bubbleSortEnd = System.currentTimeMillis();
				System.out.println("Small Array: " + Arrays.toString(smallArray));
				System.out.println("Bubble Sort Time: " + (bubbleSortEnd - bubbleSortStart));

			//Medium array
				bubbleSortStart = System.currentTimeMillis();
				bubbleSort(mediumArray);
				bubbleSortEnd = System.currentTimeMillis();
				System.out.println("Small Array: " + Arrays.toString(mediumArray));
				System.out.println("Bubble Sort Time: " + (bubbleSortEnd - bubbleSortStart));

			//Large array
				bubbleSortStart = System.currentTimeMillis();
				bubbleSort(largeArray);
				bubbleSortEnd = System.currentTimeMillis();
				System.out.println("Small Array: " + Arrays.toString(largeArray));
				System.out.println("Bubble Sort Time: " + (bubbleSortEnd - bubbleSortStart));
		
	}
	
	
	//Populate array positions with random values between 1 and 99
	static int[] populateArray(int[] arr){
		for(int i = 0; i < arr.length; i++) {
			Random r = new Random();
			arr[i] = r.nextInt(99) + 1;
		}
		return arr;
	}
	
	
	//
	//
	//
	//  /$$      /$$                                          /$$$$$$                        /$$    
	// | $$$    /$$$                                         /$$__  $$                      | $$    
	// | $$$$  /$$$$  /$$$$$$   /$$$$$$   /$$$$$$   /$$$$$$ | $$  \__/  /$$$$$$   /$$$$$$  /$$$$$$  
	// | $$ $$/$$ $$ /$$__  $$ /$$__  $$ /$$__  $$ /$$__  $$|  $$$$$$  /$$__  $$ /$$__  $$|_  $$_/  
	// | $$  $$$| $$| $$$$$$$$| $$  \__/| $$  \ $$| $$$$$$$$ \____  $$| $$  \ $$| $$  \__/  | $$    
	// | $$\  $ | $$| $$_____/| $$      | $$  | $$| $$_____/ /$$  \ $$| $$  | $$| $$        | $$ /$$
	// | $$ \/  | $$|  $$$$$$$| $$      |  $$$$$$$|  $$$$$$$|  $$$$$$/|  $$$$$$/| $$        |  $$$$/
	// |__/     |__/ \_______/|__/       \____  $$ \_______/ \______/  \______/ |__/         \___/  
	//                                   /$$  \ $$                                                  
	//                                  |  $$$$$$/                                                  
	//                                   \______/
	//
	//

	public static void mergeSort(int arr[]) {
		int n = arr.length;
		if (n < 2)
			return;
		int mid = n / 2;
		int left[] = new int[mid];
		int right[] = new int[n - mid];
		for (int i = 0; i < mid; i++)
			left[i] = arr[i];
		for (int i = mid; i < n; i++)
			right[i - mid] = arr[i];
		mergeSort(left);
		mergeSort(right);
		merge(arr, left, right);
		
	}

	public static void merge(int arr[], int left[], int right[]) {
		int nL = left.length;
		int nR = right.length;
		int i = 0, j = 0, k = 0;
		while (i < nL && j < nR) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < nL) {
			arr[k] = left[i];
			i++;
			k++;
		}
		while (j < nR) {
			arr[k] = right[j];
			j++;
			k++;
		}
	}
	
	//
	//
	//  /$$$$$$$            /$$       /$$       /$$            /$$$$$$                        /$$    
	// | $$__  $$          | $$      | $$      | $$           /$$__  $$                      | $$    
	// | $$  \ $$ /$$   /$$| $$$$$$$ | $$$$$$$ | $$  /$$$$$$ | $$  \__/  /$$$$$$   /$$$$$$  /$$$$$$  
	// | $$$$$$$ | $$  | $$| $$__  $$| $$__  $$| $$ /$$__  $$|  $$$$$$  /$$__  $$ /$$__  $$|_  $$_/  
	// | $$__  $$| $$  | $$| $$  \ $$| $$  \ $$| $$| $$$$$$$$ \____  $$| $$  \ $$| $$  \__/  | $$    
	// | $$  \ $$| $$  | $$| $$  | $$| $$  | $$| $$| $$_____/ /$$  \ $$| $$  | $$| $$        | $$ /$$
	// | $$$$$$$/|  $$$$$$/| $$$$$$$/| $$$$$$$/| $$|  $$$$$$$|  $$$$$$/|  $$$$$$/| $$        |  $$$$/
	// |_______/  \______/ |_______/ |_______/ |__/ \_______/ \______/  \______/ |__/         \___/  
	//                                                                                              
	//
	//
	
	 static void bubbleSort(int [] arrA){
	      if(arrA==null || arrA.length==0)
	            return;
	      int size = arrA.length;
	      for (int i = 0; i <size-1 ; i++) {
	          for (int j = 0; j <size-i-1 ; j++) {
	              //check the adjacent elements
	              if(arrA[j]>arrA[j+1]){
	                  //swap the elements
	                  int temp = arrA[j];
	                  arrA[j] = arrA[j+1];
	                  arrA[j+1] = temp;
	              }
	          }
	      }
	  }
	 
	//
	//
	//
	//   /$$$$$$            /$$           /$$        /$$$$$$                        /$$    
	//  /$$__  $$          |__/          | $$       /$$__  $$                      | $$    
	// | $$  \ $$ /$$   /$$ /$$  /$$$$$$$| $$   /$$| $$  \__/  /$$$$$$   /$$$$$$  /$$$$$$  
	// | $$  | $$| $$  | $$| $$ /$$_____/| $$  /$$/|  $$$$$$  /$$__  $$ /$$__  $$|_  $$_/  
	// | $$  | $$| $$  | $$| $$| $$      | $$$$$$/  \____  $$| $$  \ $$| $$  \__/  | $$    
	// | $$/$$ $$| $$  | $$| $$| $$      | $$_  $$  /$$  \ $$| $$  | $$| $$        | $$ /$$
	// |  $$$$$$/|  $$$$$$/| $$|  $$$$$$$| $$ \  $$|  $$$$$$/|  $$$$$$/| $$        |  $$$$/
	//  \____ $$$ \______/ |__/ \_______/|__/  \__/ \______/  \______/ |__/         \___/  
	//       \__/                                                                          
	//
	//
	 
	 static void quickSort(int arr[], int start, int end) {
			if (start < end) {
				int pIndex = partition(arr, start, end);
				quickSort(arr, start, pIndex - 1);
				quickSort(arr, pIndex + 1, end);
			}
		}

		static int partition(int arr[], int start, int end) {
			int pivot = arr[end];
			int pIndex = start;
			for (int i = start; i < end; i++) {
				if (arr[i] <= pivot) {
					swap(arr, i, pIndex);
					pIndex++;
				}
			}
			swap(arr, pIndex, end);
			return pIndex;
		}

		static void swap(int arr[], int x, int y) {
			int temp = arr[x];
			arr[x] = arr[y];
			arr[y] = temp;
		}
}
