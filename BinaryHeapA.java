public class BinaryHeapA<T extends Comparable<T>> implements BinaryHeap<T> {

	// array to hold the heap private Comparable[] internalArray;
	// keep track of the heap size (different from the capacity) private int
	// heapSize;

	public Comparable<T>[] heapArray;
	private int heapSize;
	public final int DEFAULT_CAPACITY = 10;
	private int[] index;

	/**
	 * construct the binary heap from the length
	 **/
	public BinaryHeapA(int arrayLength) {
		heapArray = new Comparable[arrayLength];
		heapSize = arrayLength;

	}

	/**
	 * construct the binary heap given an array
	 **/
	public BinaryHeapA(Comparable<T>[] items) {
		// create the internal array the heap array
		heapArray = new Comparable[items.length];
		// set the length to be that of the passed in array
		heapSize = items.length;

		heapArray = items;
		/*
		 * //transfer each element from the input array to the internal array
		 * for( int i = 0; i < items.length; i++ ) heapArray[ i + 1 ] = items[ i
		 * ];
		 */

		// not used but in case , keep it
		// storage for index
		index = new int[items.length];
		for (int i = 0; i < items.length; i++) {
			index[i] = i + 1;
		}

	}

	/*
	 * public int getIndex(Comparable<T> m) { int i = 0; while
	 * (!heapArray[i].equals(m)) { i++; } if (i > heapSize) { return -1; }
	 * return index[i]; }
	 * 
	 * public void setIndex(Comparable<T> m, int newIndex) { int i = 0; while
	 * (!heapArray[i].equals(m)) { i++; } if (i > heapSize) {
	 * System.out.println("ERROR"); } index[i] = newIndex;
	 * 
	 * }
	 */

	/**
	 * instead of getting directly the element from the array, use a getter
	 * method
	 **/
	public Comparable<T> getElement(int index) {
		// find the element according to the heap index
		return heapArray[index - 1];
	}

	/** sort the input array into heap order and update the heapArray **/
	public Comparable<T>[] buildMaxHeap(Comparable<T>[] newArray) {

		// heapArray = newArray;

		// maxHeapify from the right most node with a leaf
		heapSize = newArray.length - 1;
		for (int i = newArray.length / 2; i > 0; i--) {
			maxHeapify(newArray, i);
		}

		// update the heap Array
		heapArray = newArray;
		return newArray;
	}

	/** make the heap in order **/
	public void maxHeapify(Comparable<T>[] thisArray, int a) {
		// get the index of the left child
		int l = 2 * a;
		// get the index of the right child
		int r = 2 * a + 1;
		// set it to the index of the root( default largest )
		int largest = 0;

		// if it is within the heap and find the larger one in the node and its left child
		if (l <= heapSize && (thisArray[l].compareTo((T) thisArray[a]) > 0)) {
			largest = l;
		}

		else {
			largest = a;

		}

		//find the larger one in the node and right child
		if (r <= heapSize) {
			if (thisArray[r].compareTo((T) thisArray[largest]) > 0) {
				largest = r;

			}
		}

		// it is the case where the largest is not the parent node and we have to switch it 
		if (!(largest == a)) {
			//store the  value
			Comparable<T> temp = thisArray[largest];
			////make the largest the parent node
			thisArray[largest] = thisArray[a];
			//still the switch
			thisArray[a] = temp;
			//go to the direction where the change has been made to see if the order is disrupted
			maxHeapify(thisArray, largest);
		}
	}

	/** put the heap into sorted order **/
	public void sort() {

		// go through loops finding the root value and decrease the heap size 
		for (int i = heapArray.length - 1; i > 0; i--) {

			//store the value
			Comparable<T> temp = getElement(2);
			//move the last value to the first 
			heapArray[0] = heapArray[i];
			//move the first to the last from what we have stored before
			heapArray[i] = temp;
			//decrease the heap size
			heapSize--;
			//make the heap sorted again
			maxHeapify(heapArray, 0);
		}

	}

}
