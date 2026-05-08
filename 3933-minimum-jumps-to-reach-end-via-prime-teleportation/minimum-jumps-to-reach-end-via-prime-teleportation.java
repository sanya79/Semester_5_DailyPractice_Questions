import java.util.*;
class Solution {
    public int minJumps(int[] a) {
        int n = a.length;
        boolean[] v = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0); v[0] = true;
        Map<Integer,List<Integer>> m = new HashMap<>();
        for (int i=0;i<n;i++) for (int p:pf(a[i])) m.computeIfAbsent(p,k->new ArrayList<>()).add(i);
        Set<Integer> u = new HashSet<>();
        int s=0;
        while(!q.isEmpty()){
            for(int k=q.size();k>0;k--){
                int i=q.poll();
                if(i==n-1) return s;
                if(i>0&&!v[i-1]){v[i-1]=true;q.offer(i-1);}
                if(i<n-1&&!v[i+1]){v[i+1]=true;q.offer(i+1);}
                if(pr(a[i])&&!u.contains(a[i])){
                    u.add(a[i]);
                    for(int j:m.getOrDefault(a[i],Collections.emptyList()))
                        if(!v[j]){v[j]=true;q.offer(j);}
                }
            }
            s++;
        }
        return -1;
    }
    private boolean pr(int x){
        if(x<2) return false;
        if(x%2==0) return x==2;
        for(int i=3;i*i<=x;i+=2) if(x%i==0) return false;
        return true;
    }
    private List<Integer> pf(int x){
        List<Integer> f=new ArrayList<>();
        if(x%2==0){f.add(2);while(x%2==0)x/=2;}
        for(int i=3;i*i<=x;i+=2) if(x%i==0){f.add(i);while(x%i==0)x/=i;}
        if(x>1) f.add(x);
        return f;
    }
}
