package com.company.common;

import java.util.HashMap;
import java.util.Map;

public class P219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= 3) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

}
