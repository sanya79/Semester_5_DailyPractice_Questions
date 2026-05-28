import java.util.*;
class Solution {
    static class TrieNode {
        TrieNode[] ch = new TrieNode[26];
        int b = -1;
        int be = Integer.MAX_VALUE;
    }
    TrieNode root = new TrieNode();
    public int[] stringIndices(String[] wC, String[] w) {
        for (int i = 0; i < wC.length; i++) {
            insert(wC[i], i);
        }
        int[] ans = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            ans[i] = search(w[i]);
        }
        return ans;
    }
    private void insert(String word, int idx) {
        TrieNode node = root;
        updateBest(node, word.length(), idx);
        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (node.ch[c] == null) {
                node.ch[c] = new TrieNode();
            }
            node = node.ch[c];
            updateBest(node, word.length(), idx);
        }
    }
    private void updateBest(TrieNode node, int len, int idx) {
        if (len < node.be ||
            (len == node.be && idx < node.b)) {
            node.be = len;
            node.b = idx;
        }
    }
    private int search(String q) {
        TrieNode node = root;
        for (int i = q.length() - 1; i >= 0; i--) {
            int c = q.charAt(i) - 'a';
            if (node.ch[c] == null) {
                break;
            }
            node = node.ch[c];
        }
        return node.b;
    }
}