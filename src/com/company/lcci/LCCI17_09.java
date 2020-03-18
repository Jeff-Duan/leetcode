package com.company.lcci;

import java.util.ArrayList;
import java.util.List;

public class LCCI17_09 {

    int[] array = new int[]{3, 5, 7};
    List<Integer> heap = new ArrayList<>();

    public void buildHeap() {
        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    public void heapify(int k) {
        while (k < heap.size() / 2) {
            int max = k;
            if (2 * k + 1 < heap.size() && heap.get(2 * k + 1) > heap.get(k)) {
                max = 2 * k + 1;
            }
            if (2 * k + 2 < heap.size() && heap.get(2 * k + 2) > heap.get(max)) {
                max = 2 * k + 2;
            }
            if (max == k) {
                break;
            }
            swap(max, k);
            k = max;
        }
    }

    public void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public int getKthMagicNumber(int k) {
        heap.add(1);
        heap.add(3);
        heap.add(5);
        heap.add(7);
        buildHeap();

        for (int i = 0; i < heap.size(); i++) {
            System.out.println(heap.get(i));
        }

        while (heap.size() < k) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; i < 4; j++) {
                    int r = array[i] * heap.get(j);
                    if (r > heap.get(0)) {
                        heap.add(r);
                        heapify(heap.size());
                    }
                }
            }
        }

        return heap.get(0);
    }

}
