class Solution {
    public int countBeautifulPairs(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int first = getFD(nums[i]);
            for(int j = i+1; j < nums.length; j++){
                int last = nums[j] % 10;
                if(bp(first,last)==1){
                    count++;
                }
               
            }
        }
        return count;
        
        }
        public int getFD(int k){
            while(k >= 10) k /= 10;
            return k; 
    }
    public int bp(int x,int y){
        while(y != 0){
            int rem = x % y;
            x = y;
            y = rem;
        }
        return x;
    }
}