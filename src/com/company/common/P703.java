package com.company.common;

public class P703 {

    class KthLargest {

        int[] heap;
        int n;
        int k;

        public KthLargest(int k, int[] nums) {
            this.heap = new int[k];
            this.n = 0;
            this.k = k;

            for (int i = 0; i < nums.length; i++) {
                this.heap[i] = nums[i];
                n++;
                if (n == k) {
                    break;
                }
            }

            if (n == k) {
                buildHeap(this.heap);
                for (int i = k; i < nums.length; i++) {
                    if (nums[i] > this.heap[0]) {
                        this.heap[0] = nums[i];
                        heapify(this.heap, 0);
                    }
                }
            }
        }

        public int add(int val) {
            if (n == k) {
                if (val > this.heap[0]) {
                    this.heap[0] = val;
                    heapify(this.heap, 0);
                }
            }
            if (n + 1 == k) {
                this.heap[n] = val;
                n++;
                buildHeap(this.heap);
            }
            System.out.println(this.heap[0]);
            return this.heap[0];
        }

        public void buildHeap(int[] n) {
            for (int i = n.length / 2 - 1; i >= 0; i--) {
                heapify(n, i);
            }
        }

        public void heapify(int[] n, int i) {
            int min = i;
            while (true) {
                if (i * 2 + 1 < n.length && n[i * 2 + 1] < n[i]) {
                    min = i * 2 + 1;
                }
                if (i * 2 + 2 < n.length && n[i * 2 + 2] < n[min]) {
                    min = i * 2 + 2;
                }
                if (min == i) {
                    break;
                }
                swap(n, i, min);
                i = min;
            }
        }

        public void swap(int[] n, int i, int j) {
            int tmp = n[i];
            n[i] = n[j];
            n[j] = tmp;
        }
    }

   /* public static void main(String[] args) {
        KthLargest test = new KthLargest(3, new int[]{4, 5, 8, 2});
        test.add(3);
        test.add(5);
        test.add(10);
        test.add(9);
        test.add(4);

    }*/

}
