package LC0429;

import java.util.List;

/**
 * @author zhanglei211 on 2021/11/19.
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};