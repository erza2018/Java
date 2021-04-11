public class L208_M_ImplementTrie {
    public static class TrieNode{
        public boolean isEndofWord;
        public TrieNode[] next;

        public TrieNode(){
            next = new TrieNode[26];
        }
    }

    public static TrieNode root;

    public L208_M_ImplementTrie(){
        root = new TrieNode();
    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        word = word.toLowerCase();
        TrieNode currNode = root;
        int index;
        for(int i = 0; i < word.length(); i++){
            // get the index in next of the next letter
            index = word.charAt(i) - 'a';

            // check if that node exists
            // if not, make a new node
            if(currNode.next[index] == null){
                currNode.next[index] = new TrieNode();
            }

            // move to that node to keep inserting
            currNode = currNode.next[index];
        }
        currNode.isEndofWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        word = word.toLowerCase();
        TrieNode currNode = root;
        int index;
        for(int i = 0; i < word.length(); i++){
            // get the index of the next letter and check if it exists in tree
            index = word.charAt(i) - 'a';

            if(currNode.next[index] == null) return false;
            currNode = currNode.next[index];
        }

        return currNode.isEndofWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        prefix = prefix.toLowerCase();
        TrieNode currNode = root;
        int index;
        for(int i = 0; i < prefix.length(); i++){
            // get the index of the next letter and check if it exists in tree
            index = prefix.charAt(i) - 'a';

            if(currNode.next[index] == null) return false;
            currNode = currNode.next[index];
        }

        return true;
    }
}
