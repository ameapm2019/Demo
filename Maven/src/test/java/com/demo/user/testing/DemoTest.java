package com.demo.user.testing;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.demo.user.testing.Demo;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for {@link Demo}
 * @author Ameya Mhatre
 */
public class DemoTest {
	
	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	/**
	 * Tests that an {@link IllegalArgumentException} is thrown with a message that states "Array cannot be null or empty"
	 * when the input array is empty.
	 */
	@Test
	public void test_removeDuplicates_emptyArray_throwsIllegalArgumentException()
	{
		thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Array cannot be null or empty");
		Demo.removeDuplicates(new int[0]);
	}
	
	/**
	 * Tests that an {@link IllegalArgumentException} is thrown with a message that states "Array cannot be null or empty"
	 * when the input array is null.
	 */
	@Test
	public void test_removeDuplicates_nullArray_throwsIllegalArgumentException()
	{
		thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Array cannot be null or empty");
		Demo.removeDuplicates(null);
	}
	
	/**
	 * Tests that we get an expected array when the input array contains only one duplicate number. 
	 */
	@Test
	public void test_removeDuplicates_containsSingleDupilcateNumber()
	{
		int [] inputArray = {0,1,1,2};
		int outPutArrayLength = Demo.removeDuplicates(inputArray);
		int [] expectedArray = {0,1,2};
		assertArrays(inputArray, outPutArrayLength, expectedArray);
	}
	
	/**
	 * Tests that we get an expected array when the input array contains multiple duplicate numbers. 
	 */
	@Test
	public void test_removeDuplicates_containsMultipleDupilcateNumbers()
	{
		int [] inputArray = {0,0,1,1,1,2,2,3,3,4};
		int outPutArrayLength = Demo.removeDuplicates(inputArray);
		int [] expectedArray = {0,1,2,3,4};
		assertArrays(inputArray, outPutArrayLength, expectedArray);
	}
	
	/**
	 * Tests that we get an expected array when the input array has a duplicate number at the beginning. 
	 */
	@Test
	public void test_removeDuplicates_duplicateNumberAtBeginning()
	{
		int [] inputArray = {0,0,1,2,3,4};
		int outPutArrayLength = Demo.removeDuplicates(inputArray);
		int [] expectedArray = {0,1,2,3,4};
		assertArrays(inputArray, outPutArrayLength, expectedArray);
	}
	
	/**
	 * Tests that we get an expected array when the input array has a duplicate number at the end.
	 */
	@Test
	public void test_removeDuplicates_duplicateNumberAtEnd()
	{
		int [] inputArray = {0,1,2,3,4,4};
		int outPutArrayLength = Demo.removeDuplicates(inputArray);
		int [] expectedArray = {0,1,2,3,4};
		assertArrays(inputArray, outPutArrayLength, expectedArray);
	}
	
	/**
	 * Asserts the actual and expected arrays.
	 * @param actualArray The actual array.
	 * @param actualArrayLength The length of the actual array.
	 * @param expectedArray The expected array.
	 */
	private void assertArrays(int [] actualArray, int actualArrayLength, int [] expectedArray)
	{
		assertThat(expectedArray.length).isEqualTo(actualArrayLength);
		for(int i=0;i<actualArrayLength;i++)
		{
			assertThat(actualArray[i]).isEqualTo(expectedArray[i]);
		}
	}
}
