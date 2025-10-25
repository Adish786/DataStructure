package com.datastructure.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieAutocomplete {
    public static void main(String[] args) {
        Trie trie = null;
        String str = "Adish";
        trie.insert(str);
    }
   public class TrieNode{
        Map<Character,TrieNode> children = new HashMap<>();
        boolean isEndOfWord;
    }
   public class Trie{
        TrieNode root= new TrieNode();
        public void insert(String word){
            TrieNode node =root;
            for (char c: word.toCharArray()){
                node = node.children.computeIfAbsent(c,k->new TrieNode());
                node.isEndOfWord=true;
            }
        }
        public boolean search(String word){
            TrieNode node = root;
            for (char c:word.toCharArray()){
                node=node.children.get(c);
                if(node ==null ) return false;
            }
            return node.isEndOfWord;
        }
        public boolean startWith(String prefix){
            TrieNode node =root;
            for (char c:prefix.toCharArray()){
                node =node.children.get(c);
                if(node==null) return false;
            }
            return true;
        }
   }


}
