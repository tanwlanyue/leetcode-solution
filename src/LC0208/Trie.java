package LC0208;

/**
 * 208. 实现 Trie (前缀树) </br>
 * 执行用时： 32 ms , 在所有 Java 提交中击败了 83.70% 的用户 </br>
 * 内存消耗： 48.5 MB , 在所有 Java 提交中击败了 34.92% 的用户
 * 
 * @author zhanglei211 on 2021/9/23.
 */
class Trie {

    Trie[] child;
    boolean isLeaf = false;

    public Trie() {
        this.child = new Trie[26];
    }

    public void insert(String word) {
        Trie root = this;
        for (char c : word.toCharArray()) {
            if (root.child[c - 'a'] == null) {
                root.child[c - 'a'] = new Trie();
            }
            root = root.child[c - 'a'];
        }
        root.isLeaf = true;
    }

    public boolean search(String word) {
        Trie root = this;
        for (char c : word.toCharArray()) {
            if (root.child[c - 'a'] == null) {
                return false;
            }
            root = root.child[c - 'a'];
        }
        return root.isLeaf;
    }

    public boolean startsWith(String prefix) {
        Trie root = this;
        for (char c : prefix.toCharArray()) {
            if (root.child[c - 'a'] == null) {
                return false;
            }
            root = root.child[c - 'a'];
        }
        return true;
    }
}