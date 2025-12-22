class Solution {
    public String generateTag(String caption) {
        String[] words = caption.trim().split("\\s+");
        StringBuilder tag = new StringBuilder("#");

        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();

            if (word.isEmpty()) continue;

            if (i == 0) {
                tag.append(word);
            } else {
                tag.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    tag.append(word.substring(1));
                }
            }
            if (tag.length() >= 100) {
                break;
            }
        }
        StringBuilder clean = new StringBuilder();
        for (int i = 0; i < tag.length(); i++) {
            char c = tag.charAt(i);
            if (c == '#' || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                clean.append(c);
            }
        }
        return clean.length() > 100 ? clean.substring(0, 100) : clean.toString();
    }
}
