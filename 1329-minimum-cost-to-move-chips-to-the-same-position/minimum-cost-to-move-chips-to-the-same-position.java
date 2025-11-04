import java.util.*;

public class Solution {
    public static int minCostToMoveChips(int[] position) {
        int even = 0, odd = 0;
        
        for (int p : position) {
            if (p % 2 == 0) even++;
            else odd++;
        }
        
        return Math.min(even, odd);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] position = new int[n];
        
        for (int i = 0; i < n; i++) {
            position[i] = sc.nextInt();
        }
        
        System.out.println(minCostToMoveChips(position));
        sc.close();
    }
}
