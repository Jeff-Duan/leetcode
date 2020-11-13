package com.company.common;

public class P424 {

    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();

        int[] nums = new int[26];

        int max = 0;

        int r = 0;

        int i = 0;

        for (int j = 0; j < chars.length; j++) {
            nums[chars[j] - 'A']++;
            max = Math.max(max, nums[chars[j] - 'A']);
            while (j - i + 1 - max > k) {
                nums[chars[i] - 'A']--;
                i++;
            }
            r = Math.max(r, j - i + 1);
        }

        return r;
    }

}
