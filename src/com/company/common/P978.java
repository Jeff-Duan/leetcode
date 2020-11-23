package com.company.common;

public class P978 {

    public int maxTurbulenceSize(int[] arr) {
        // 数组长度为 1 直接返回
        if (arr.length == 1) {
            return 1;
        }

        int start = -1;

        // 找到湍流子数组的起点
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                start = i;
                break;
            }
        }

        // start 无变化说明数组元素相同
        if (start == -1) {
            return 1;
        }

        int result = 2;

        boolean flag = arr[start] < arr[start + 1];

        // 滑动窗口判断湍流的条件
        for (int i = start + 2; i < arr.length; i++) {
            if ((flag && arr[i - 1] > arr[i]) || (!flag && arr[i - 1] < arr[i])) {
                // 条件成立
                flag = !flag;
                result = Math.max(result, i - start + 1);
            } else {
                // 条件不成立
                start = arr[i - 1] == arr[i] ? i : i - 1;
            }
        }

        return result;
    }

}
