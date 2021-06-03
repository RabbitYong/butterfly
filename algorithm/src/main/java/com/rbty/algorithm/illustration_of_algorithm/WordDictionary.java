package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: 211. 添加与搜索单词 - 数据结构设计
 * @date 2021/4/14 14:11
 */
public class WordDictionary {
    WordDictionary[] wordDictionaries;
    Boolean isEnd;

    /** Initialize your data structure here. */
    public WordDictionary() {
        wordDictionaries = new WordDictionary[26];
        isEnd = false;
    }

    public void addWord(String word) {
        WordDictionary root = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (root.wordDictionaries[index] == null){
                root.wordDictionaries[index] = new WordDictionary();
            }
            root = root.wordDictionaries[index];
        }
        root.isEnd = true;
    }

    public boolean search(String word) {
        return searchHelper(word, this);
    }

    private boolean searchHelper(String word, WordDictionary root){
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (ch == '.'){
                for (int j = 0; j < 26; j++) {
                    if (root.wordDictionaries[j] != null){
                        if (searchHelper(word.substring(i+1),root.wordDictionaries[j])){
                            return true;
                        }
                    }
                }
                return false;
            }else{
                if (root.wordDictionaries[index] == null){
                    return false;
                }
                root = root.wordDictionaries[index];
            }
        }
        return root.isEnd;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("mad");
        wordDictionary.addWord("dad");
        System.out.println(wordDictionary.search("dad."));
    }
}
