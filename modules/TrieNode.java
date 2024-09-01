package modules;

public class TrieNode {

    public char val;
    public boolean endOfWord;
    public TrieNode[] children;

    public TrieNode(char val) {
        this.val = val;
        this.endOfWord = false;
        this.children = new TrieNode[26];
    }

}
