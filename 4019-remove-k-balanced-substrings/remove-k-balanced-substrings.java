class Solution {
    public String removeSubstring(String s, int k) {
        Deque<int[]> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek()[0] == c) {
                stack.peek()[1]++;
            } else {
                stack.push(new int[]{c, 1});
            }

            while (stack.size() >= 2) {
                int[] top = stack.pop();    
                int[] prev = stack.pop();   

                if (prev[0] == '(' && top[0] == ')' &&
                    prev[1] >= k && top[1] >= k) {

                    prev[1] -= k;
                    top[1] -= k;

                    if (prev[1] > 0) stack.push(prev);
                    if (top[1] > 0) stack.push(top);
                } else {
                    stack.push(prev);
                    stack.push(top);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        List<int[]> list = new ArrayList<>(stack);
        Collections.reverse(list);

        for (int[] p : list) {
            sb.append(String.valueOf((char) p[0]).repeat(p[1]));
        }

        return sb.toString();
    }
}
