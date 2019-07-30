package com.demo.user.testing;

/**
 * This class contains methods created for demo.
 * @author Ameya Mhatre
 */
public class Demo {
	
	/**
	 * Removes the duplicates from a sorted array.
	 * @param nums A sorted array.
	 * @return New length of the array.
	 */
	public static int removeDuplicates(int[] nums) {
		if(nums == null || nums.length < 1)
			throw new IllegalArgumentException("Array cannot be null or empty");
		
        int currentPlace = 1;
        
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i] != nums[i+1])
            {
                nums[currentPlace] = nums[i+1];
                currentPlace++;
            }
        }
        
        return currentPlace;
    }
}
