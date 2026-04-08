import java.util.*;
public class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = 0;
        for (int a : apple) {
            totalApples += a;
        }
        Arrays.sort(capacity);
        int boxes = 0;
        int currentCapacity = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            currentCapacity += capacity[i];
            boxes++;
            if (currentCapacity >= totalApples) {
                return boxes;
            }
        }
        return boxes; 
    }
}