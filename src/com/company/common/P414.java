package com.company.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class P414 {

    public int thirdMax(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        Set<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(Long.valueOf(nums[i]));
        }

        List<Long> list = new ArrayList<>(set);

        return list.size() > 2 ? list.get(list.size() - 3).intValue() : list.get(list.size() - 1).intValue();
    }

}
