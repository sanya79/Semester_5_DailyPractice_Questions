class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n=nums.length;
        int m=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            if(nums[i]==target){
                int d=Math.abs(i-start);
                m=Math.min(m,d);
            }

        }
        return m;
        
    }
}