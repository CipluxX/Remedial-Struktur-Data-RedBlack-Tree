import java.util.ArrayList;

class RedBlackTree<T extends Comparable<T>> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        T data;
        Node left, right;
        boolean color;

        Node(T data) {
            this.data = data;
            this.color = RED;
        }
    }

    private Node root;

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void insert(T data) {
        root = insert(root, data);
        root.color = BLACK;
    }

    private Node insert(Node h, T data) {
        if (h == null) return new Node(data);

        int cmp = data.compareTo(h.data);

        if (cmp < 0) {
            h.left = insert(h.left, data);
        } else if (cmp > 0) {
            h.right = insert(h.right, data);
        } else {

            return h;
        }

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        return h;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    public ArrayList<T> inOrderTraversal() {
        ArrayList<T> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    private void inOrderTraversal(Node x, ArrayList<T> result) {
        if (x != null) {
            inOrderTraversal(x.left, result);
            result.add(x.data);
            inOrderTraversal(x.right, result);
        }
    }
}

