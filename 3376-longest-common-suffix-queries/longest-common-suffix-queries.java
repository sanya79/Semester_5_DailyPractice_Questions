import java.util.*;
class Solution {
    static class TrieNode {
        TrieNode[] ch = new TrieNode[26];
        int b = -1;
        int bestLength = Integer.MAX_VALUE;
    }
    TrieNode root = new TrieNode();
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }
        return ans;
    }
    private void insert(String word, int index) {
        TrieNode node = root;
        updateBest(node, word.length(), index);
        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (node.ch[c] == null) {
                node.ch[c] = new TrieNode();
            }
            node = node.ch[c];
            updateBest(node, word.length(), index);
        }
    }
    private void updateBest(TrieNode node, int length, int index) {
        if (length < node.bestLength ||
            (length == node.bestLength && index < node.b)) {
            node.bestLength = length;
            node.b = index;
        }
    }
    private int search(String query) {
        TrieNode node = root;
        for (int i = query.length() - 1; i >= 0; i--) {
            int c = query.charAt(i) - 'a';
            if (node.ch[c] == null) {
                break;
            }
            node = node.ch[c];
        }
        return node.b;
    }
}