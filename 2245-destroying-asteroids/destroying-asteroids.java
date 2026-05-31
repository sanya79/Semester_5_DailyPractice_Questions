import java.util.Arrays;
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long pM = mass; 
        for (int a : asteroids) {
            if (pM < a) {
                return false;
            }
            pM += a;
        }
        return true;
    }
}
