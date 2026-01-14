class Solution {
    int[] p;

    int find(int x){
        return p[x]==x ? x : (p[x]=find(p[x]));
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        p = new int[n];
        for(int i=0;i<n;i++) p[i]=i;

        for(int i=0;i+1<n;i++)
            if(nums[i+1]-nums[i]<=maxDiff)
                p[find(i)] = find(i+1);

        boolean[] ans = new boolean[queries.length];
        for(int i=0;i<queries.length;i++)
            ans[i] = find(queries[i][0]) == find(queries[i][1]);

        return ans;
    }
}
