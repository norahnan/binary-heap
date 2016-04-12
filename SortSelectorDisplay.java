// BarArrayDisplay.java

// modified: Andrew Wilkinson 9/14/15

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * 
 * Displays an array of integers by using their values to determine bar heights.
 * 
 * @author Audrey St. John
 **/

public class SortSelectorDisplay extends JComponent

{

	// The array to display

	private Comparable<Integer>[] intArray;

	private int maxValue;

	private int minValue;

	// Constructor

	public SortSelectorDisplay()

	{

		super();

	}

	// Paint a barGraph representation of the intArray

	public void paint(Graphics g)

	{

		if (intArray != null)

		{

			// barWidth = width of the window / the number of elements in array

			int barWidth = getWidth() / intArray.length;

			// barHeightMax = 20 pixels from the top of the window

			int barHeightMax = getHeight() - 20;

			// Draw a bar for each element in array

			for (int i = 0; i < intArray.length; i++)

			{

				// Height of bar is a percentage of barHeightMax with 10 being
				// max height

				float valueHeight = ((int)intArray[i] - minValue)
						/ (float) (maxValue - minValue) * (float) barHeightMax;

				// Draw a bar with a minimum height of 10 pixels

				drawBar(g, i, (int)intArray[i], (int) valueHeight + 10, barWidth, i
						* barWidth);

			}

		}

	}

	// Paint an individual bar

	private void drawBar(Graphics g, int index, int barValue, int height,
			int width, int xValue)

	{

		g.setColor(Color.cyan);

		// draw the bar ( Inside )

		g.fillRect(xValue, getHeight() - height, width, height);

		// set the color of the "brush" (for text and border)

		g.setColor(Color.BLACK);

		// draw the bar ( Border )

		g.drawRect(xValue, getHeight() - height, width, height);

		// print the value of the bar

		g.drawString("" + barValue, xValue, getHeight() - height + 10);

		// print the index of the bar as long as there's enough room

		if (g.getFont().getSize() * 2 <= width)

		{

			g.drawString("" + index, (int) (xValue + width / 2.0f), getHeight());

		}

	}

	// Sets the array to be used by the paint function

	public void setArray(Comparable<Integer>[] intArray2, int min, int max)

	{

		intArray = intArray2;

		minValue = min;

		maxValue = max;

	}

}