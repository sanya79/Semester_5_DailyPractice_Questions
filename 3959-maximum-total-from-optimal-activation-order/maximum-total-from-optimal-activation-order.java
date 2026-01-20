class Solution {

    public long maxTotal(int[] value, int[] limit) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < value.length; i++) {
            if (map.containsKey(limit[i]) == false) {
                map.put(limit[i], new ArrayList<>());
            }
            map.get(limit[i]).add(value[i]);
        }
        long ans = 0;

        for (int currLimit : map.keySet()) {

            ArrayList<Integer> elements = map.get(currLimit);

            Collections.sort(elements, (a, b)-> b-a);
            // Collections.reverse(elements);

            for (int i = 0; i < Math.min(currLimit, elements.size()); i++) {
                ans += elements.get(i);
            }
        }

        return ans;
    }
}