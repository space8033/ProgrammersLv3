import java.util.Arrays;
import java.util.Comparator;

public class RouteFindingGame {
    int[][] result;
    int index;
    public class Node {
        int x, y, val;
        Node left, right;

        public Node(int x, int y, int val, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int[][] solution(int[][] nodeinfo) {
        Node[] node = new Node[nodeinfo.length];
        for(int i = 0; i < nodeinfo.length; i++) {
            node[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null, null);
        }

        Arrays.sort(node, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.y == o2.y) {
                    return o1.x - o2.x;
                }else {
                    return o2.y - o1.y;
                }
            }
        });

        Node root = node[0];
        for(int i = 1; i < node.length; i++) {
            insertNode(root, node[i]);
        }

        result = new int[2][nodeinfo.length];
        index = 0;
        preOrder(root);
        index = 0;
        postOrder(root);

        return result;
    }

    public void insertNode(Node parent, Node child) {
        if(parent.x > child.x) {
            if(parent.left == null) {
                parent.left = child;
            }else {
                insertNode(parent.left, child);
            }
        }else {
            if(parent.right == null) {
                parent.right = child;
            }else {
                insertNode(parent.right, child);
            }
        }
    }

    public void preOrder(Node root) {
        if(root != null) {
            result[0][index++] = root.val;
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            result[1][index++] = root.val;
        }
    }
}
