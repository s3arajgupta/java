package practice.neetCode150.part10Tries.medium;

import modules.TrieNode;

public class implementPrefixTree {

    public static void main(String[] args) {

        implementPrefixTree obj = new implementPrefixTree();

        obj.insert("apple");
        System.out.println(obj.search("apple"));
        System.out.println(obj.search("app"));
        System.out.println(obj.startsWith("app"));
        obj.insert("app");
        System.out.println(obj.search("app"));

    }

    TrieNode root;

    public implementPrefixTree() {

        this.root = new TrieNode('0'); // dummy

    }

    public void insert(String word) {

        TrieNode curr = root;

        for (char c : word.toCharArray()) {

            if (curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode(c);

            curr = curr.children[c - 'a'];

        }

        curr.endOfWord = true;

    }

    public boolean search(String word) {

        TrieNode curr = root;

        for (char c : word.toCharArray()) {

            if (curr.children[c - 'a'] == null)
                return false;

            curr = curr.children[c - 'a'];

        }

        return (curr.endOfWord == true) ? true : false;

    }

    public boolean startsWith(String prefix) {

        TrieNode curr = root;

        for (char c : prefix.toCharArray()) {

            if (curr.children[c - 'a'] == null)
                return false;

            curr = curr.children[c - 'a'];

        }

        return true;

    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
