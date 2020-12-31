package com.company.common;

import java.util.ArrayList;
import java.util.List;

public class P448 {

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] != 0) {
                if (nums[i] == nums[nums[i] - 1]) {
                    nums[i] = 0;
                } else {
                    swap(nums, i, nums[i] - 1);
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

}
