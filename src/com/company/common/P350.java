package com.company.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P350 {

    public int searchBorder(int[] nums, int start, int end, int target, boolean left) {
        int i = start;
        int j = end;
        if (left) {
            while (i <= j) {
                int m = i + (j - i) / 2;
                if (nums[m] >= target) {
                    j = m - 1;
                } else {
                    i = m + 1;
                }
            }
            return i;
        } else {
            while (i <= j) {
                int m = i + (j - i) / 2;
                if (nums[m] <= target) {
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            }
            return j;
        }
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int leftIndex = searchBorder(nums, 0, nums.length - 1, target, true);

        if (leftIndex < 0 || leftIndex > nums.length - 1 || nums[leftIndex] != target) {
            return new int[]{-1, -1};
        }

        int rightIndex = searchBorder(nums, leftIndex, nums.length - 1, target, false);

        return new int[]{leftIndex, rightIndex};
    }

    // 二分查找排序数组中某个数值出现的次数
    public int search(int[] arr, int k) {
        int[] range = searchRange(arr, k);
        if (range[0] == -1) {
            return 0;
        } else {
            return range[1] - range[0] + 1;
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }

        int[] longArray = null;
        int[] shortArray = null;
        if (nums1.length >= nums2.length) {
            longArray = nums1;
            shortArray = nums2;
        } else {
            longArray = nums2;
            shortArray = nums1;
        }
        Arrays.sort(longArray);

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < shortArray.length; i++) {
            if (map.containsKey(shortArray[i])) {
                if (map.get(shortArray[i]) > 0) {
                    list.add(shortArray[i]);
                    map.put(shortArray[i], map.get(shortArray[i]) - 1);
                }
            } else {
                int count = search(longArray, shortArray[i]);
                map.put(shortArray[i], count);
                if (count > 0) {
                    list.add(shortArray[i]);
                    map.put(shortArray[i], count - 1);
                }
            }
        }

        int[] result = new int[list.size()];
        int offset = 0;
        for (Integer integer : list) {
            result[offset++] = integer;
        }

        return result;
    }

}
