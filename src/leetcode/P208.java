package leetcode;

/**
 * 208. 实现 Trie (前缀树)
 *
 * @author Billy
 * @date 2020/6/1 10:14 下午
 */
public class P208 {
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    public void insert(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) {
                ws.children[c - 'a'] = new TrieNode(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    public boolean search(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) {
                return false;
            }
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (ws.children[c - 'a'] == null) {
                return false;
            }
            ws = ws.children[c - 'a'];
        }
        return true;
    }
}

class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];

    public TrieNode() {
    }

    public TrieNode(char val) {
        TrieNode trieNode = new TrieNode();
        trieNode.val = val;
    }
}