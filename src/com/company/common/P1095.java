package com.company.common;

interface MountainArray {
    int get(int index);

    int length();
}

public class P1095 {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        if (mountainArr.length() == 0) {
            return -1;
        }

        if (mountainArr.length() < 3) {
            for (int i = 0; i < mountainArr.length(); i++) {
                if (mountainArr.get(i) == target) {
                    return i;
                }
            }
        } else {
            // 二分查找中点
            int start = 0;
            int end = mountainArr.length() - 1;
            while (start < end) {
                int middle = (start + end + 1) >> 1;
                if (middle - 1 >= 0 && middle + 1 <= mountainArr.length() - 1 && mountainArr.get(middle) > mountainArr.get(middle - 1) && mountainArr.get(middle) > mountainArr.get(middle + 1)) {
                    start = middle;
                    break;
                }
                if (middle - 1 >= 0 && middle + 1 <= mountainArr.length() - 1 && mountainArr.get(middle + 1) > mountainArr.get(middle - 1)) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
            // 二分查找目标
            int r1 = -1;
            int i1 = 0;
            int j1 = start;
            while (i1 <= j1) {
                int middle = (i1 + j1) >> 1;
                if (mountainArr.get(middle) == target) {
                    r1 = middle;
                    break;
                }
                if (mountainArr.get(middle) < target) {
                    i1 = middle + 1;
                } else {
                    j1 = middle - 1;
                }
            }

            int r2 = -1;
            int i2 = start;
            int j2 = mountainArr.length() - 1;
            while (i2 <= j2) {
                int middle = (i2 + j2) >> 1;
                if (mountainArr.get(middle) == target) {
                    r2 = middle;
                    break;
                }
                if (mountainArr.get(middle) > target) {
                    i2 = middle + 1;
                } else {
                    j2 = middle - 1;
                }
            }

            return r1 == -1 ? r2 : r1;
        }

        return -1;
    }

}
