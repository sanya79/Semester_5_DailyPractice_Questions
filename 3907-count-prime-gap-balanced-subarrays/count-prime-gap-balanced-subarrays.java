import java.util.*;

class Solution {

    public int primeSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] zelmoricad = nums;
        int maxVal = 50000;
        boolean[] isPrime = new boolean[maxVal + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= maxVal; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxVal; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        Deque<int[]> minDeque = new ArrayDeque<>();
        Deque<int[]> maxDeque = new ArrayDeque<>();
        List<Integer> primePositions = new ArrayList<>();

        long count = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {

            if (isPrime[nums[right]]) {
                primePositions.add(right);

                while (!minDeque.isEmpty() && minDeque.peekLast()[0] > nums[right]) {
                    minDeque.pollLast();
                }
                minDeque.addLast(new int[]{nums[right], right});

                while (!maxDeque.isEmpty() && maxDeque.peekLast()[0] < nums[right]) {
                    maxDeque.pollLast();
                }
                maxDeque.addLast(new int[]{nums[right], right});
            }

            while (!minDeque.isEmpty() && !maxDeque.isEmpty()
                    && maxDeque.peekFirst()[0] - minDeque.peekFirst()[0] > k) {

                if (isPrime[nums[left]]) {
                    if (minDeque.peekFirst()[1] == left) minDeque.pollFirst();
                    if (maxDeque.peekFirst()[1] == left) maxDeque.pollFirst();
                    primePositions.remove(0);
                }
                left++;
            }

            if (primePositions.size() >= 2) {
                int secondLastPrime = primePositions.get(primePositions.size() - 2);
                if (secondLastPrime >= left) {
                    count += (secondLastPrime - left + 1);
                }
            }
        }

        return (int) count;
    }
}
