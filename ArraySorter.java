/**
 * 
 * ArraySorter provides sorting methods for arrays of ints.
 **/

public class ArraySorter

{

	/**
	 * 
	 * Uses selection sort algorithm to sort the array.
	 * 
	 * Modifies the passed array so that its elements are in ascending,
	 * 
	 * sorted order.
	 * 
	 * @param <T>
	 **/

	public static <T> void selectionSort(Comparable<T>[] array)

	{

		Comparable<T> small;

		Comparable<T> temp;

		Comparable<T> temp2;

		for (int i = 0; i < array.length; i++) {

			small = array[i];// suppose the first one is the smallest one

			for (int j = i + 1; j < array.length; j++) {

				if (array[j].compareTo((T) small) < 0) {

					small = array[j];// check if any following number is smaller
										// than the first one and update the
										// smallest number until we go to the
										// end of the array

					array[j] = array[i];

				}

			}

			temp = array[i];

			array[i] = small;

			// change the first to the smallest

		}

	}

	/**
	 * 
	 * Uses insertion sort algorithm to sort the array.
	 * 
	 * Modifies the passed array so that its elements are in ascending,
	 * 
	 * sorted order.
	 * @param <T>
	 * 
	 * @param <T>
	 **/

	public static <T> Comparable<T>[] insertionSort(Comparable<T>[] array)

	{

		Comparable<T> temp;

		for (int i = 1; i < array.length; i++) {

			//

			temp = array[i];

			for (int j = i - 1; j >= 0; j--)

				if (array[j].compareTo((T) temp) > 0) {

					array[j + 1] = array[j];

					array[j] = temp;// if the one is smaller than the one in the
									// front,change the second to the first one,

					array[j] = temp;// and assign the recorded value of the
									// second one to the first one

				}

		}

		return array;
	}

	/**
	 * 
	 * Uses bubble sort algorithm to sort the array.
	 * 
	 * Modifies the passed array so that its elements are in ascending,
	 * 
	 * sorted order.
	 * 
	 * @param <T>
	 **/

	public static <T> void bubbleSort(Comparable<T>[] array)

	{

		Comparable<T> temp;// used to hold values

		// boolean flag;

		// flag=true;

		// while(flag==true){

		// flag= false;

		for (int j = 1; j < array.length; j++) {

			for (int i = 1; i < array.length - 1; i++) {

				if (array[i].compareTo((T) array[i - 1]) < 0) {

					temp = array[i];// record the larger number in the front

					array[i] = array[i - 1];// assign the front place the
											// smaller number

					array[i - 1] = temp;// assign the second place the recorded
										// larger number

					// flag= true;//to show that we have reached the end and
					// finished once

					// do it (n-1) times to complete

				}

			}

		}
		if (!checkSorted(array)) {
			insertionSort(array);
		}

	}

	/**
	 * 
	 * A terrible sorting algorithm that shuffles the array until the array is
	 * sorted
	 * 
	 * Uses a "Fisher–Yates shuffle" WARNING: do not use on arrays bigger than
	 * 10!
	 * 
	 * @param <T>
	 **/

	public static <T> void bogoSort(Comparable<T>[] array)

	{

		// While the array is unsorted

		while (!checkSorted(array))

		{

			// Shuffle each element in the list

			for (int i = array.length - 1; i > 0; i--)

			{

				// Random Index between 0 and i

				int j = (int) (Math.random() * i);

				// Swap

				Comparable temp = array[i];

				array[i] = array[j];

				array[j] = temp;

			}

		}

	}

	/** the heap sort method 
	 * @param <T>**/
	public static <T> Comparable<T>[] heapSort(Comparable<T>[] array) {
		//create a new heap object and pass in the array
		BinaryHeapA b = new BinaryHeapA(array);
		//make the array confirm to the heap requirements
		b.buildMaxHeap(array);
		//sort the internal array heapArray
		b.sort();
		//update the array to be the sorted array
		array = b.heapArray;
		return array;
	}

	public static Boolean checkSorted(Comparable[] array)

	{// check if the array is sorted

		for (int i = 1; i < array.length; i++)

		{

			if (array[i].compareTo(array[i - 1]) < 0)

			{

				return false;

			}

		}

		return true;

	}

}