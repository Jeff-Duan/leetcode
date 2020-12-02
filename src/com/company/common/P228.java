package com.company.common;

import java.util.ArrayList;
import java.util.List;

public class P228 {

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        List<String> list = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (j < nums.length) {
            while (j < nums.length - 1 && nums[j] == nums[j + 1] - 1) {
                j++;
            }

            if (i == j) {
                list.add(String.valueOf(nums[i]));
            } else {
                list.add(nums[i] + "->" + nums[j]);
            }

            i = j + 1;
            j = j + 1;
        }

        return list;
    }

}
