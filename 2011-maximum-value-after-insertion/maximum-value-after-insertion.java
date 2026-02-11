class Solution {
    public String maxValue(String n, int x) {
        char digit = (char)(x + '0');
        StringBuilder sb = new StringBuilder();
        if (n.charAt(0) == '-') {
            sb.append('-');
            boolean inserted = false;
            for (int i = 1; i < n.length(); i++) {
                if (!inserted && n.charAt(i) - '0' > x) {
                    sb.append(digit);
                    inserted = true;
                }
                sb.append(n.charAt(i));
            }
            if (!inserted) {
                sb.append(digit);
            }
        } else {
            boolean inserted = false;
            for (int i = 0; i < n.length(); i++) {
                if (!inserted && n.charAt(i) - '0' < x) {
                    sb.append(digit);
                    inserted = true;
                }
                sb.append(n.charAt(i));
            }
            if (!inserted) {
                sb.append(digit);
            }
        }
        return sb.toString();
    }
}
