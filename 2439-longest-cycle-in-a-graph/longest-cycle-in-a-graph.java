class Solution{ 
    public static int longestCycle(int[] edges){
        int[] in = new int[edges.length];
        for(int i = 0; i < edges.length; i++){
            if(edges[i] != -1){
                in[edges[i]]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < in.length; i++){
            if(in[i] == 0){
                q.add(i);
            }
        }

        boolean[] visited = new boolean[edges.length];

        while(!q.isEmpty()){
            int e = q.poll();
            visited[e] = true;

            if(edges[e] != -1){
                in[edges[e]]--;
                if(in[edges[e]] == 0){
                    q.add(edges[e]);
                }
            }
        }

        int ans = -1;

        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                int count = 0;
                int nbrs = i;
                while(!visited[nbrs]){
                    visited[nbrs] = true;
                    nbrs = edges[nbrs];
                    count++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
