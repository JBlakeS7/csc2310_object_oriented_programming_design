package csc2310;

import org.junit.*;
import static org.junit.Assert.*;

public class MeasuredRectangleTest
{
	@Test
	public void testNumWidthChanges()
	{
		ChangeMeasuredRectangle r = new ChangeMeasuredRectangle(20, 50);
		r.setSize(21, 50);
		assertEquals(r.getNumWidthChanges(), 1);
	}
}