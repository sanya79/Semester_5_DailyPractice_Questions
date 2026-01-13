class Solution {
    public int minSessions(int[] t, int S) {
        int n=t.length, N=1<<n;
        int[] sum=new int[N], dp=new int[N];
        Arrays.fill(dp,20);

        for(int m=1;m<N;m++){
            int b=Integer.numberOfTrailingZeros(m);
            sum[m]=sum[m^(1<<b)]+t[b];
            if(sum[m]<=S) dp[m]=1;
        }

        for(int m=1;m<N;m++)
            for(int s=m;s>0;s=(s-1)&m)
                dp[m]=Math.min(dp[m],dp[s]+dp[m^s]);

        return dp[N-1];
    }
}
