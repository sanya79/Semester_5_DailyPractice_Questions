class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long l = 1, r = (long) time[0] * totalTrips;
        while (l < r) {
            long m = (l + r) / 2;
            long t = 0;

            for (int x : time) {
                t += m / x;
            }

            if (t >= totalTrips) r = m;
            else l = m + 1;
        }

        return l;
    }
}
