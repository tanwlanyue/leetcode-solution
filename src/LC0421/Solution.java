package LC0421;

/**
 * @author zhanglei211 on 2021/9/23.
 */
class Solution {

    class Trie {
        Trie left;
        Trie right;

        public Trie() {
            this.left = null;
            this.right = null;
        }

        public void add(String s) {
            Trie root = this;
            for (char c : s.toCharArray()) {
                if (c - '0' == 0) {
                    if (root.left == null) {
                        root.left = new Trie();
                    }
                    root = root.left;
                } else {
                    if (root.right == null) {
                        root.right = new Trie();
                    }
                    root = root.right;
                }
            }
        }

        public String xor(String s) {
            StringBuilder builder = new StringBuilder();
            Trie root = this;
            for (char c : s.toCharArray()) {
                if (c - '0' == 0) {
                    if (root.right != null) {
                        root = root.right;
                        builder.append(1);
                    } else {
                        root = root.left;
                        builder.append(0);
                    }
                } else {
                    if (root.left != null) {
                        root = root.left;
                        builder.append(1);
                    } else {
                        root = root.right;
                        builder.append(0);
                    }
                }
            }
            return builder.toString();
        }
    }

    public int findMaximumXOR(int[] nums) {
        int max = 0;
        Trie root = new Trie();
        int n = nums.length;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String s = Integer.toBinaryString(nums[i]);
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < 32 - s.length(); j++) {
                builder.append('0');
            }
            String str = builder.append(s).toString();
            root.add(str);
            arr[i] = str;
        }
        for (String s : arr) {
            int xor = Integer.parseInt(root.xor(s), 2);
            max = Math.max(xor, max);
        }
        return max;
    }
}