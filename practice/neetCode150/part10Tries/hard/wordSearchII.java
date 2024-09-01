package practice.neetCode150.part10Tries.hard;

import java.util.*;

import modules.TrieNodeHashMap;

public class wordSearchII {

    public static void main(String[] args) {

        wordSearchII sol = new wordSearchII();

        char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' } };
        String[] words = { "oath", "pea", "eat", "rain" };

        System.out.println(sol.findWords(board, words));

    }

    int ROWS;
    int COLS;
    boolean[][] visted;
    char[][] board;
    HashSet<String> result;

    public List<String> findWords(char[][] board, String[] words) {

        ROWS = board.length;
        COLS = board[0].length;
        visted = new boolean[ROWS][COLS];
        this.board = board;
        this.result = new HashSet<>();

        TrieNodeHashMap root = new TrieNodeHashMap();
        for (String word : words)
            root.buildTrie(word);

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs(r, c, root, new StringBuilder(), root);
            }
        }

        return new ArrayList<>(result);

    }

    public void dfs(int r, int c, TrieNodeHashMap node, StringBuilder word, TrieNodeHashMap root) {

        if (r < 0 ||
                c < 0 ||
                r == ROWS ||
                c == COLS ||
                visted[r][c] ||
                !node.children.containsKey(board[r][c]))
            return;

        visted[r][c] = true;
        word.append(board[r][c]);

        node = node.children.get(board[r][c]);
        if (node.endOfWord) {

            result.add(word.toString());
            root.removeTrie(word.toString());

        }

        dfs(r + 1, c, node, word, root);
        dfs(r - 1, c, node, word, root);
        dfs(r, c + 1, node, word, root);
        dfs(r, c - 1, node, word, root);

        visted[r][c] = false;
        word.deleteCharAt(word.length() - 1);

    }

    // int ROWS;
    // int COLS;
    // boolean[][] visted;
    // char[][] board;
    // String[] words;
    // List<String> result;

    // public List<String> findWords(char[][] board, String[] words) {

    //     ROWS = board.length;
    //     COLS = board[0].length;
    //     this.visted = new boolean[ROWS][COLS];
    //     this.board = board;

    //     this.words = words;
    //     this.result = new ArrayList<>();

    //     for (int w = 0; w < words.length; w++) {

    //         boolean wordFound = false;

    //         for (int r = 0; r < ROWS && !wordFound; r++) {

    //             for (int c = 0; c < COLS && !wordFound; c++) {

    //                 if (dfs(r, c, w, 0)) {
    //                     wordFound = true;
    //                     break;
    //                 }

    //             }

    //         }

    //     }

    //     return result;

    // }

    // public boolean dfs(int r, int c, int w, int index) {

    //     if (index == words[w].length()) {

    //         result.add(words[w]);
    //         return true;

    //     }

    //     if (r < 0 ||
    //             c < 0 ||
    //             r == ROWS ||
    //             c == COLS ||
    //             visted[r][c] ||
    //             board[r][c] != words[w].charAt(index))
    //         return false;

    //     visted[r][c] = true;
    //     boolean res = dfs(r + 1, c, w, index + 1) ||
    //             dfs(r - 1, c, w, index + 1) ||
    //             dfs(r, c + 1, w, index + 1) ||
    //             dfs(r, c - 1, w, index + 1);
    //     visted[r][c] = false;

    //     return res;

    // }

}
