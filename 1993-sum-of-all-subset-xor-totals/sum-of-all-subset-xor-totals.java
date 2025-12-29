class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }
    private int dfs(int[] nums, int index, int currentXor) {
        if (index == nums.length) {
            return currentXor;
        }
        int withElement = dfs(nums, index + 1, currentXor ^ nums[index]);
        int withoutElement = dfs(nums, index + 1, currentXor);
        return withElement + withoutElement;
    }
}
