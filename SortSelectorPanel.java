// SortSelectorPanel.java

// Andrew Wilkinson 9/21/15 

// swing 

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

// awt



import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * SortSelectorPanel initializes and contains the GUI controls and the array
 * display
 **/

public class SortSelectorPanel extends JPanel

{

	private Comparable<Integer>[] intArray;
	

	// create JTextPanels for input text

	private JTextField arraySize = new JTextField(3);

	private JTextField arrayRangeMin = new JTextField(3);

	private JTextField arrayRangeMax = new JTextField(3);

	// create JComboBox for choosing which way to sort

	private static String[] sortingAlgs = { "Selection", "Insertion", "Bubble",
			"Bogo", "Heap" };

	private JComboBox algList = new JComboBox(sortingAlgs);

	private SortSelectorDisplay sortSelectorDisplay;

	// Constructor, calls initGUI

	public SortSelectorPanel()

	{

		super();

		initPanel();

	}

	// Create the GUI Components of this Panel

	public void initPanel()

	{

		setLayout(new BorderLayout());

		// Adds the main panel

		add(createArrayMakerPanel(), BorderLayout.NORTH);

		// Creates a new Sorting Display

		sortSelectorDisplay = new SortSelectorDisplay();

		add(sortSelectorDisplay, BorderLayout.CENTER);

		// Add the Sort Selector

		add(createSortPickerPanel(), BorderLayout.SOUTH);

	}

	// Create the top row of the GUI for generating an array

	private JPanel createArrayMakerPanel()

	{

		// Create a panel to hold GUI elements

		JPanel arrayMakerPanel = new JPanel();

		// Create and add a label and textInput for Array size

		arrayMakerPanel.add(new JLabel("Size: "));

		arrayMakerPanel.add(arraySize);

		// Create and add a label and textInput for array Range Min

		arrayMakerPanel.add(new JLabel("Range Min: "));

		arrayMakerPanel.add(arrayRangeMin);

		// Create and add a label and textInput for array Range Max

		arrayMakerPanel.add(new JLabel("Range Max: "));

		arrayMakerPanel.add(arrayRangeMax);

		// Create a randButton for generating an array

		JButton randButton = new JButton("New random array");

		randButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)

			{

				randomizeArray();

			}

		});

		// Add the randButton

		arrayMakerPanel.add(randButton);

		// Return Created Panel

		return arrayMakerPanel;

	}

	// Creates the Bottom row of the GUI for sorting the array

	private JPanel createSortPickerPanel()

	{

		// Create a panel to hold GUI elements

		JPanel sortPickerPanel = new JPanel();

		JButton sortButton = new JButton("Sort Array!");

		sortButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)

			{

				sort();

			}

		});

		sortPickerPanel.add(algList);

		sortPickerPanel.add(sortButton);

		return sortPickerPanel;

	}

	// Sorts the current intArray with the selected sorting algorithm

	private void sort()

	{

		if (intArray != null)

		{

			// We're going to use a switch statement based off of the index

			// of the current sortingAlg to use a certain method to sort the
			// array

			int selectedSortingAlg = algList.getSelectedIndex();

			switch (selectedSortingAlg)

			{

			// selection

			case 0:

				ArraySorter.selectionSort(intArray);

				break;

			// insertion

			case 1:

				ArraySorter.insertionSort(intArray);

				break;

			// bubble

			case 2:

				ArraySorter.bubbleSort(intArray);

				break;

			// bogo

			case 3:

				ArraySorter.bogoSort(intArray);

				break;

				
			// heap

			case 4:

				ArraySorter.heapSort(intArray);

				break;

			default:

				// do nothing

			}

			repaint();

		}

	}

	// Creates a random array on ButtonPress "New random array" and sets the
	// sortSelectorDisplay

	private void randomizeArray()

	{

		// Get the three values from the JTextFields

		int size = Integer.parseInt(arraySize.getText());

		int min = Integer.parseInt(arrayRangeMin.getText());

		int max = Integer.parseInt(arrayRangeMax.getText());

		// Create a new array of size characters ranged min-max

		intArray = randomIntegerArray(min, max, size);

		// Update the array for sortSelectorDisplay to draw

		sortSelectorDisplay.setArray(intArray, min, max);

		// Tell graphics to update

		repaint();

	}

	// Creates an array (of length number), of random Integers in the range
	// [lo,hi)

	public static Comparable<Integer>[] randomIntegerArray(int lo, int hi, int length)

	{

		// Create a new array of 'length' elements

		Comparable<Integer>[] a = new Comparable[length];

		// Assign a random number from lo to hi to each element of a

		for (int i = 0; i < length; i++)

		{

			a[i] = (int) Math.floor(Math.random() * (hi - lo + 1) + lo);

		}

		// Return our new array

		return a;

	}

}