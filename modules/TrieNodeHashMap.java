package modules;

import java.util.HashMap;

public class TrieNodeHashMap {

    public boolean endOfWord;
    public HashMap<Character, TrieNodeHashMap> children;

    public TrieNodeHashMap() {
        this.endOfWord = false;
        this.children = new HashMap<>();
    }

    public void buildTrie(String word) {
        TrieNodeHashMap curr = this; // Start from the current node (usually root)
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNodeHashMap());
            curr = curr.children.get(c);
        }
        curr.endOfWord = true;
    }

    public boolean removeTrie(String word) {
        return removeTrie(this, word, 0);
    }

    private boolean removeTrie(TrieNodeHashMap current, String word, int index) {
        if (index == word.length()) {
            // If we've reached the end of the word
            if (!current.endOfWord) {
                return false; // Word not found
            }
            current.endOfWord = false; // Resetting the end of the word
            // If the current node has no other children, it can be deleted
            return current.children.isEmpty();
        }

        char c = word.charAt(index);
        TrieNodeHashMap node = current.children.get(c);
        if (node == null) {
            return false; // Word not found
        }

        boolean shouldDeleteCurrentNode = removeTrie(node, word, index + 1);

        // If true, delete the mapping of character and TrieNode reference
        if (shouldDeleteCurrentNode) {
            current.children.remove(c);
            // Return true if no other children are present and it's not the end of another
            // word
            return current.children.isEmpty() && !current.endOfWord;
        }

        return false;
    }

}
