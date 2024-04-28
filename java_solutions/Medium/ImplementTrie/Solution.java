class Trie {
    private TrieNode head;

    public Trie() {
        head = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = this.head;
        for(int i = 0; i < word.length(); i++) {
            int charPos = (int) word.charAt(i) - 97;
            if (node.getLetters()[charPos] == null) {
                node.getLetters()[charPos] = new TrieNode();
            } 
            node = node.getLetters()[charPos];
        }
        node.setIsWord(true);
    }
    
    public boolean search(String word) {
        TrieNode node = this.head;
        for(int i = 0; i < word.length(); i++) {
            int charPos = (int) word.charAt(i) - 97;
            if (node.getLetters()[charPos] == null) {
                return false;
            }
            node = node.getLetters()[charPos];
        }
        return node.getIsWord();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = this.head;
        for(int i = 0; i < prefix.length(); i++) {
            int charPos = (int) prefix.charAt(i) - 97;
            if (node.getLetters()[charPos] == null) {
                return false;
            }
            node = node.getLetters()[charPos];
        }
        return true; 
    }
}

class TrieNode {
    private boolean isWord;
    private TrieNode[] letters;

    public TrieNode() {
        this.isWord = false;
        this.letters = new TrieNode[26];
    }

    public boolean getIsWord() {
        return this.isWord;
    }

    public void setIsWord(boolean newVal) {
        this.isWord = newVal;
    }

    public TrieNode[] getLetters() {
        return this.letters;
    }
}
