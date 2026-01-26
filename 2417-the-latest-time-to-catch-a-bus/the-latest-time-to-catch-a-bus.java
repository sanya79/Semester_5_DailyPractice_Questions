import java.util.*;

class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        Set<Integer> passengerSet = new HashSet<>();
        for (int p : passengers) {
            passengerSet.add(p);
        }
        int pIndex = 0;
        int lastBoardedTime = -1;
        int seatsUsed = 0;
        for (int i = 0; i < buses.length; i++) {
            seatsUsed = 0;
            while (pIndex < passengers.length &&
                   passengers[pIndex] <= buses[i] &&
                   seatsUsed < capacity) {
                lastBoardedTime = passengers[pIndex];
                pIndex++;
                seatsUsed++;
            }
        }
        int lastBusTime = buses[buses.length - 1];
        int candidate;

        if (seatsUsed < capacity) {
            candidate = lastBusTime;
        } else {
            candidate = lastBoardedTime - 1;
        }
        while (passengerSet.contains(candidate)) {
            candidate--;
        }

        return candidate;
    }
}
