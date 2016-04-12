import static org.junit.Assert.*;

import org.junit.Test;


public class ArraySorterTest {

	
	 
	
	@Test
	public void testheapsort() {
		
		Integer[] newArray = {3,43,56,34,2,6,346,346};
		
		//newArray = SortSelectorPanel.randomIntegerArray(3,23,56);
		//ArraySorter.heapSort(newArray);
		assertEquals("testheapsort",true,ArraySorter.insertionSort(newArray).equals(ArraySorter.heapSort(newArray)));
		
	}

}
