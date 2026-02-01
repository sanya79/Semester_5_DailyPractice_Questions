import java.util.*;

class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) return new int[0];

        Arrays.sort(changed);

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : changed) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int[] original = new int[n / 2];
        int index = 0;
        if (freq.containsKey(0)) {
            int zeroCount = freq.get(0);
            if (zeroCount % 2 != 0) return new int[0];

            for (int i = 0; i < zeroCount / 2; i++) {
                original[index++] = 0;
            }
            freq.put(0, 0);
        }
        for (int num : changed) {
            if (num == 0) continue;
            if (freq.get(num) == 0) continue;

            int twice = num * 2;
            if (!freq.containsKey(twice) || freq.get(twice) == 0) {
                return new int[0];
            }

            original[index++] = num;
            freq.put(num, freq.get(num) - 1);
            freq.put(twice, freq.get(twice) - 1);
        }

        return original;
    }
}
