import java.util.Arrays;

class Solution {
    static class Node {
        int id;
        int x;
        int y;
        Node left;
        Node right;

        Node(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }

        void insert(Node childNode) {
            if (childNode.x < this.x) {
                if (this.left == null) {
                    this.left = childNode;
                } else {
                    this.left.insert(childNode);
                }
            } else {
                if (this.right == null) {
                    this.right = childNode;
                } else {
                    this.right.insert(childNode);
                }
            }
        }
    }

    public int[][] solution(int[][] nodeInfo) {
        int[][] nodes = sortNodes(nodeInfo);
        Node rootNode = new Node(nodes[0][0], nodes[0][1], nodes[0][2]);

        for (int i = 1; i < nodes.length; i++) {
            rootNode.insert(new Node(nodes[i][0], nodes[i][1], nodes[i][2]));
        }

        int n = nodeInfo.length;
        int[] prefixRoute = new int[n];
        int[] postfixRoute = new int[n];

        int[] index = new int[1];
        preorder(rootNode, prefixRoute, index);

        index[0] = 0;
        postorder(rootNode, postfixRoute, index);

        return new int[][]{ prefixRoute, postfixRoute };
    }

    private void preorder(Node currentNode, int[] out, int[] index) {
        if (currentNode == null) return;
        out[index[0]++] = currentNode.id;
        preorder(currentNode.left, out, index);
        preorder(currentNode.right, out, index);
    }

    private void postorder(Node currentNode, int[] out, int[] index) {
        if (currentNode == null) return;
        postorder(currentNode.left, out, index);
        postorder(currentNode.right, out, index);
        out[index[0]++] = currentNode.id;
    }

    private int[][] sortNodes(int[][] nodeInfo) {
        int n = nodeInfo.length;
        int[][] nodes = new int[n][3]; 

        for (int i = 0; i < n; i++) {
            nodes[i][0] = i + 1;
            nodes[i][1] = nodeInfo[i][0];
            nodes[i][2] = nodeInfo[i][1];
        }

        Arrays.sort(nodes, (a, b) -> {
            if (a[2] != b[2]) return Integer.compare(b[2], a[2]);
            return Integer.compare(a[1], b[1]);
        });

        return nodes;
    }
}