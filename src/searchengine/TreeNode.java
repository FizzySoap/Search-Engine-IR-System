
package searchengine;


class TreeNode<K, V> {
    K key;
    V value;
    TreeNode<K, V> left, right;

    public TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
        left = right = null;
    }
}

class BinarySearchTree<K extends Comparable<K>, V> {
    private TreeNode<K, V> root;

    public void put(K key, V value) {
        root = putRec(root, key, value);
    }

    private TreeNode<K, V> putRec(TreeNode<K, V> node, K key, V value) {
        if (node == null) return new TreeNode<>(key, value);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = putRec(node.left, key, value);
        else if (cmp > 0) node.right = putRec(node.right, key, value);
        else node.value = value; // Replace if key already exists
        return node;
    }

    public V get(K key) {
        TreeNode<K, V> node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) node = node.left;
            else if (cmp > 0) node = node.right;
            else return node.value;
        }
        return null;
    }
}

