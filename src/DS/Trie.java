package DS;

public class Trie {
    class TrieNode{
        public TrieNode[] child;
        public boolean isWord;
        public TrieNode(){
            child = new TrieNode[26];
            isWord=false;
        }
    }

    public TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p=root;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(p.child[index]==null)
                p.child[index]=new TrieNode();
            p=p.child[index];
        }
        p.isWord=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p=root;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(p.child[index]==null)
                return false;
            p=p.child[index];
        }
        return p.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p=root;
        for(int i=0;i<prefix.length();i++){
            int index = prefix.charAt(i)-'a';
            if(p.child[index]==null)
                return false;
            p=p.child[index];
        }
        return true;
    }
}
