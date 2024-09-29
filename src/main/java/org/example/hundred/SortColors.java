package org.example.hundred;

public class SortColors {
    public void sortColors(int[] nums) {
        int i = 0, j = nums.length-1;
        int k = 0;

        while(i <= j) {
            if(nums[i] == 0) {
                swap(nums,i,k);
                i++;
                k++;
            } else if(nums[i] == 2) {
                swap(nums,i,j);
                j--;
            } else {
                i++;
            }

        }

    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
