import java.util.*;
class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }

        int base = pos.getOrDefault(k, new ArrayList<>()).size();
        int answer = base;

        List<Integer> kPos = pos.getOrDefault(k, new ArrayList<>());

        for (int v : pos.keySet()) {
            if (v == k) continue;

            List<Integer> vPos = pos.get(v);

            int i = 0, j = 0;
            int curr = 0, best = 0;
            while (i < vPos.size() || j < kPos.size()) {
                int idx;
                int val;

                if (j == kPos.size() || (i < vPos.size() && vPos.get(i) < kPos.get(j))) {
                    idx = vPos.get(i++);
                    val = +1;   
                } else {
                    idx = kPos.get(j++);
                    val = -1;   
                }

                curr = Math.max(val, curr + val);
                best = Math.max(best, curr);
            }

            answer = Math.max(answer, base + best);
        }

        return answer;
    }
}
