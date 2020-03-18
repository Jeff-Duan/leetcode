package com.company.lcof;

import java.util.Arrays;

public class LCOF40 {

    public void buildHeap(int[] arr, int k) {
        for (int i = k / 2 - 1; i >= 0; i--) {
            heapify(arr, k, i);
        }
    }

    public void heapify(int[] arr, int k, int r) {
        int max = r;
        while (true) {
            if (r * 2 + 1 < k && arr[r * 2 + 1] > arr[r]) {
                max = r * 2 + 1;
            }
            if (r * 2 + 2 < k && arr[r * 2 + 2] > arr[max]) {
                max = r * 2 + 2;
            }
            if (max == r) {
                break;
            }
            swap(arr, r, max);
            r = max;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        buildHeap(arr, k);
        for (int i = k; i <= arr.length; i++) {
            if (arr[i] < arr[0]) {
                arr[0] = arr[i];
                heapify(arr, k, 0);
            }
        }
        return Arrays.copyOfRange(arr, 0, k);
    }

}
