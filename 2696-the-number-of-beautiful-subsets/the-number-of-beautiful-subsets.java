class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
      
        findBeautiful(0,nums,new ArrayList<>(),k);
        return res.size();
    }
    public void findBeautiful(int ind,int[] nums,List<Integer> ll,int k){
        if(ind==nums.length){
            if(ll.size()>0){
                res.add(new ArrayList<>(ll));
            }
            return;
        }
        if(!(ll.contains(nums[ind]-k))){
            ll.add(nums[ind]);
            findBeautiful(ind+1,nums,ll,k);    
            ll.remove(ll.size()-1);
        }
        findBeautiful(ind+1,nums,ll,k);
    }
}