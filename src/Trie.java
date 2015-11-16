import java.util.HashMap;

/**
 * Created by donhan on 11/15/15.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            TrieNode cur;
            if(children.containsKey(c)){
                cur = children.get(c);
            }else{
                cur = new TrieNode(c);
                children.put(c,cur);
                // HashMap<Character,TrieNode> curChildren = new HashMap<Character,TrieNode>();
                // cur.children = curChildren;
            }
            children = cur.children;

            if(i == word.length() - 1){
                cur.isLeaf = true;
            }

        }

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(null == word || word.length() == 0){
            return true;
        }
        TrieNode result = searchNode(word);
        if(null != result && result.isLeaf){
            return true;
        }else{
            return false;
        }



    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode result = searchNode(prefix);
        if(null != result){
            return true;
        }else{
            return false;
        }

    }

    public TrieNode searchNode(String str){
        TrieNode cur = null;
        HashMap<Character, TrieNode> children = root.children;
        for(int i = 0; i < str.length(); i ++){

            char c = str.charAt(i);
            if(children.containsKey(c)){
                cur = children.get(c);
                children = cur.children;
            }else{
                return null;
            }
        }
        return cur;


    }
}

class TrieNode {
    char c;
    HashMap<Character,TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;
    public TrieNode() {}
    public TrieNode(char c){
        this.c = c;
    }
}


// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
