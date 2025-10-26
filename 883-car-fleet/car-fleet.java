import java.util.*;
public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double prevTime = 0.0;
        for (int i = 0; i < n; i++) {
            double time = (target - cars[i][0]) / cars[i][1];
            if (time > prevTime) {
                fleets++;
                prevTime = time;
            }
        }

        return fleets;
    }
}
