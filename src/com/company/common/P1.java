package com.company.common;

import java.util.HashMap;
import java.util.Map;

public class P1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] r = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                r[0] = map.get(target - nums[i]);
                r[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return r;
    }

}
