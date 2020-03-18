package com.company.common;

public class P1046 {

    public void buildHeap(int[] n) {
        for (int i = n.length / 2 - 1; i >= 0; i--) {
            heapify(n, i);
        }
    }

    public void heapify(int[] n, int i) {
        int max = i;
        while (true) {
            if (i * 2 + 1 < n.length && n[i * 2 + 1] > n[i]) {
                max = i * 2 + 1;
            }
            if (i * 2 + 2 < n.length && n[i * 2 + 2] > n[max]) {
                max = i * 2 + 2;
            }
            if (max == i) {
                break;
            }
            swap(n, i, max);
            i = max;
        }
    }

    public void swap(int[] n, int i, int j) {
        int tmp = n[i];
        n[i] = n[j];
        n[j] = tmp;
    }

    public int lastStoneWeight(int[] stones) {
        if (stones.length > 1) {
            buildHeap(stones);
            while (true) {
                int value = 0;

                int first = stones[0];
                stones[0] = 0;
                heapify(stones, 0);

                int second = stones[0];
                if (first > second) {
                    value = first - second;
                }
                if (first < second) {
                    value = second - first;
                }
                stones[0] = value;
                heapify(stones, 0);

                if (first == 0 || second == 0) {
                    break;
                }
            }
        }
        return stones[0];
    }

}
