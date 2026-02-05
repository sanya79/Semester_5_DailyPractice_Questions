class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie t = new Trie();
        for (String s : dictionary) {
            t.insert(s);
        }

        String[] arr = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String s : arr) {
            String prefix = t.search(s);
            if (prefix != null) {
                sb.append(prefix);
            } else {
                sb.append(s);
            }
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    static class Trie {
        class Node {
            char ch;
            String isTerminal; // stores root word
            HashMap<Character, Node> child = new HashMap<>();

            Node(char ch) {
                this.ch = ch;
            }
        }

        private Node root = new Node('*');

        public void insert(String word) {
            Node curr = root;
            for (char ch : word.toCharArray()) {
                curr.child.putIfAbsent(ch, new Node(ch));
                curr = curr.child.get(ch);
            }
            curr.isTerminal = word;
        }

        public String search(String word) {
            Node curr = root;
            for (char ch : word.toCharArray()) {
                if (!curr.child.containsKey(ch)) {
                    return null;
                }
                curr = curr.child.get(ch);
                if (curr.isTerminal != null) {
                    return curr.isTerminal; 
                }
            }
            return null;
        }
    }
}
