package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/4/14 10:19
 */
public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("butterfly");
        System.out.println(trie.search("butterfly"));
    }
}

class Trie {

    Trie[] children;
    Boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie root = this;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(root.children[index] == null){
                root.children[index] = new Trie();
            }
            root = root.children[index];
        }
        root.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie trie = searchPrefix(word);
        return trie !=null && trie.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    public Trie searchPrefix(String prefix){
        Trie root = this;
        for (int i = 0; i < prefix.length(); i++) {
            char cur = prefix.charAt(i);
            int index = cur - 'a';
            if (root.children[index] == null){
                return null;
            }
            root = root.children[index];
        }
        return root;
    }
}
