// SortSelecotrApplication.java

// Andrew Wilkinson 9/21/15

import javax.swing.JFrame;

import javax.swing.JPanel;

/**
 * 
 * SortSelectorApplication wraps a SortSelectionPanel for the Sorting app.
 **/

public class SortSelectorApplication

{

	public static void main(String[] args)

	{

		JFrame sortSelectorFrame = new JFrame("SortSelector");

		sortSelectorFrame.add(new SortSelectorPanel());

		sortSelectorFrame.setSize(800, 400);

		sortSelectorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		sortSelectorFrame.setVisible(true);

	}

}