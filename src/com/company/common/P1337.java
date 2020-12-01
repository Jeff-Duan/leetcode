package com.company.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class P1337 {

    // 对所有的 1 求和
    public int search(int[] arr) {
        int r = 0;
        int i = 0;
        int j = arr.length - 1;

        while (i <= j) {
            int m = i + (j - i) / 2;
            if ((arr[m] & 1) == 1) {
                i = m + 1;
                r = m;
            } else {
                j = m - 1;
            }
        }

        return (arr[r] & 1) == 1 ? ++r : 0;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < mat.length; i++) {
            map.put(i, search(mat[i]));
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        Comparator<Map.Entry<Integer, Integer>> comparator = (o1, o2) -> o1.getValue() - o2.getValue();

        Collections.sort(list, comparator);

        int[] result = new int[k];
        for (int i = 0; i <= k; i++) {
            result[i] = list.get(i).getKey();
        }
        return result;
    }

}
