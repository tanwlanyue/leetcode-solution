package LC0208;

/**
 * @author zhanglei211 on 2021/9/23.
 */
class Trie {

    Trie[] child;
    boolean isLeaf;

    public Trie() {
        this.child = new Trie[26];
        this.isLeaf = false;
    }

    public void insert(String word) {
        Trie root=this;
        char[] chars = word.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            int pos=chars[i]-'a';
            if (root.child[pos]==null) {
                root.child[pos]=new Trie();
            }
            root=root.child[pos];
        }
        root.isLeaf=true;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        int n = chars.length;
        Trie root=this;
        for (int i = 0; i < n; i++) {
            int pos=chars[i]-'a';
            if (root.child[pos]==null) {
                return false;
            }
            root=root.child[pos];
        }
        return root.isLeaf;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        int n = chars.length;
        Trie root=this;
        for (int i = 0; i < n; i++) {
            int pos=chars[i]-'a';
            if(root.child[pos]==null){
                return false;
            }
            root=root.child[pos];
        }
        return true;
    }
}