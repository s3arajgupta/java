package practice.neetCode150.part10Tries.medium;

import modules.TrieNode;

public class WordDictionary {

    public static void main(String[] args) {

        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));

    }

    TrieNode root;

    public WordDictionary() {

        this.root = new TrieNode('0');

    }

    public void addWord(String word) {

        TrieNode curr = root;

        for (char c : word.toCharArray()) {

            if (curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode(c);

            curr = curr.children[c - 'a'];

        }

        curr.endOfWord = true;

    }

    public boolean search(String word) {

        return dfs(word, root, 0);

    }

    public boolean dfs(String word, TrieNode node, int index) {

        for (int i = index; i < word.length(); i++) {

            char c = word.charAt(i);

            if (c == '.') {

                for (TrieNode child : node.children) {

                    if (child != null && dfs(word, child, i + 1))
                        return true;

                }

                return false;

            }

            if (node.children[c - 'a'] == null)
                return false;

            node = node.children[c - 'a'];

        }

        return node.endOfWord;

    }

}
