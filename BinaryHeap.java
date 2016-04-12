
public interface BinaryHeap<T extends Comparable<T>>{

	
	
	public void maxHeapify(Comparable<T>[] thisArray, int a);
	 
	 
	 
	 public Comparable<T>[] buildMaxHeap(Comparable<T>[] newArray);
	
	 public Comparable<T> getElement(int index);
	
}
