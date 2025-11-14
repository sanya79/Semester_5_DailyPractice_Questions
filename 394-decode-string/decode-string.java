import java.util.*;
public class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } 
            else if (c == '[') {
                countStack.push(k);
                strStack.push(curr);
                curr = new StringBuilder();
                k = 0;
            } 
            else if (c == ']') {
                StringBuilder decoded = strStack.pop();
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decoded.append(curr);
                }
                curr = decoded; 
            } 
            else {
                curr.append(c);
            }
        }

        return curr.toString();
    }
}
