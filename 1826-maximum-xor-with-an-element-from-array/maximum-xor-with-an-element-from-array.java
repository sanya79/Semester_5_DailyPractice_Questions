// class Solution {
//     public int[] maximizeXor(int[] nums, int[][] queries) {
        
//         int[] ans=new int[q.length];
//         Trie t=new Trie();
//         int j=0;
//         for(int [] a:q){
//             while(j<arr.length && arr[i] <= a[1]){
//                 t.add(arr[j]);
//                 j++;
//             }
//             if(j==0){
//                 ans[a[2]]=-1;
//             }
//             else{
//                 ans[a[2]]=t.getMaxXor(a[0]);
//             }
//         }
//         for(int x:ans){
//             System.out.print(x+" ");
//         }
//     }
//     static class Trie{
//         class Node{
//             Node zero;
//             Node one;
//         }
//         private Node root=new Node();
//         public void add(int val){
//             Node curr=root;
//             for(int i=31;i>=0;i--){
//                 int bit=val & (1<<i);
//                 if(bit==0){
//                     if(curr.zero!=null){
//                         curr=curr.zero;
//                     }
//                     else{
//                         Node nn=new Node();
//                         curr.zero=nn;
//                         curr=nn;
//                     }
//                 }
//                 else{
//                     if(curr.one !=null){
//                         curr=curr.one;
//                     }
//                     else{
//                         Node nn=new Node();
//                         curr.one=nn;
//                         curr=nn;
//                     }
//                 }
//             }
//         }

//     }
// }
import java.util.*;

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        
        Arrays.sort(nums);
        
        int n = queries.length;
        int[][] q = new int[n][3];
        for(int i = 0; i < n; i++){
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = i;
        }
        
        Arrays.sort(q, (a, b) -> a[1] - b[1]);
        
        int[] ans = new int[n];
        Trie t = new Trie();
        
        int j = 0;
        
        for(int[] query : q){
            int xi = query[0];
            int mi = query[1];
            int idx = query[2];
            
            while(j < nums.length && nums[j] <= mi){
                t.add(nums[j]);
                j++;
            }
            
            if(j == 0){
                ans[idx] = -1;
            } else {
                ans[idx] = t.getMaxXor(xi);
            }
        }
        
        return ans;
    }
    
    static class Trie{
        class Node{
            Node zero;
            Node one;
        }
        
        private Node root = new Node();
        
        public void add(int val){
            Node curr = root;
            
            for(int i = 31; i >= 0; i--){
                int bit = (val >> i) & 1;
                
                if(bit == 0){
                    if(curr.zero == null)
                        curr.zero = new Node();
                    curr = curr.zero;
                } else {
                    if(curr.one == null)
                        curr.one = new Node();
                    curr = curr.one;
                }
            }
        }
        
        public int getMaxXor(int val){
            Node curr = root;
            int maxXor = 0;
            
            for(int i = 31; i >= 0; i--){
                int bit = (val >> i) & 1;
                
                if(bit == 0){
                    if(curr.one != null){
                        maxXor |= (1 << i);
                        curr = curr.one;
                    } else {
                        curr = curr.zero;
                    }
                } else {
                    if(curr.zero != null){
                        maxXor |= (1 << i);
                        curr = curr.zero;
                    } else {
                        curr = curr.one;
                    }
                }
            }
            
            return maxXor;
        }
    }
}
