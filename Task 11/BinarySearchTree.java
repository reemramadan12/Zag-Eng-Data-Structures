public class BinarySearchTree {
    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert(int value) {
        Node n = new Node(value);
        if (root == null)
            root = n; // if the tree is empty then the node I wanted to insert is the root
        else {
            Node parent = getParent(value);
            if (value >= parent.value)
                parent.right = n; // n is the node which contains the value I wanted to insert
            else
                parent.left = n;
        }
    }

    private Node getParent(int value) {
        Node current = root;
        Node parent = root;

        while (current != null) {
            parent = current;
            if (current.value >= value)
                current = current.left;
            else
                current = current.right;
        }
        return parent;
    }

    public boolean find(int value) {
        Node current = root;

        while (current != null) {
            if (current.value == value)
                return true;
            if (value > current.value)
                current = current.right;
            else
                current = current.left;
        }
        return false;
    }

    public void preOrder() {
        preOrder(root);
    }

    public void inOrder() {
        inOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void preOrder(Node root) {
        if (root == null)
            return;

        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    private void inOrder(Node root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    private void postOrder(Node root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }

    public void descending() {
        descending(root);
    }
    
    private void descending(Node root) {
        if (root == null)
            return;

        descending(root.right);
        System.out.println(root.value);
        descending(root.left);
    }

    public int max() {
        int max = root.value;
        Node current = root;

        while (current != null) {
            max = current.value;
            current = current.right;
        }
        return max;
    }

    public int min() {
        int min = root.value;
        Node current = root;

        while (current != null) {
            min = current.value;
            current = current.left;
        }
        return min;
    }
}
