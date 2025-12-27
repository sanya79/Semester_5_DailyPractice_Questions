class Solution {
    public String resultingString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                char top = stack.peek();
                if (isConsecutive(top, c)) {
                    stack.pop(); 
                    continue;    
                }
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) sb.append(ch);
        return sb.toString();
    }
    
    private boolean isConsecutive(char a, char b) {
        int diff = Math.abs(a - b);
        return diff == 1 || diff == 25; 
        
    }
}