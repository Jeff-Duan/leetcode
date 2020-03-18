package com.company.lcof;

public class LCOF11 {

    public int minArray(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }

        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int middle = (start + end) >>> 2;

            if (numbers[middle] > numbers[end]) {
                start = middle + 1;
            } else if (numbers[middle] < numbers[end]) {
                end = middle;
            } else {
                end = end - 1;
            }
        }
        return numbers[end];
    }

}
