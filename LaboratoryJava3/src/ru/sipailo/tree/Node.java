
class Node {
    // Поля
    int value;
    Node parent;
    Node left;
    Node right;

    // Конструктор
    public Node() {
        this.value = Integer.MIN_VALUE;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    // Левосторонний обход
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrderTraversal(this, sb);
        return sb.toString();
    }


    private void inOrderTraversal(Node node, StringBuilder sb) {
        if (node != null) {
            inOrderTraversal(node.left, sb);
            if (node.value != Integer.MIN_VALUE) {
                sb.append(node.value).append(" ");
            }
            inOrderTraversal(node.right, sb);
        }
    }
}

// Работа с бинарным деревом
class BinaryTree {
    private Node root;

    // Конструктор
    public BinaryTree() {
        this.root = new Node();
    }

    // Метод
    public void addValue(int value) {
        addValueRecursive(root, value);
    }

    private void addValueRecursive(Node node, int value) {
        if (node.value == Integer.MIN_VALUE) {
            node.value = value;
        } else {
            if (value > node.value) {
                if (node.right == null) {
                    node.right = new Node();
                    node.right.parent = node;
                }
                addValueRecursive(node.right, value);
            } else {
                if (node.left == null) {
                    node.left = new Node();
                    node.left.parent = node;
                }
                addValueRecursive(node.left, value);
            }
        }
    }

    // Метод удаления
    public void removeValue(int value) {
        root = removeValueRecursive(root, value);
    }

    private Node removeValueRecursive(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.value) {
            node.left = removeValueRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = removeValueRecursive(node.right, value);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.value = findMin(node.right).value;
            node.right = removeValueRecursive(node.right, node.value);
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Метод проверки существования
    public boolean containsValue(int value) {
        return containsValueRecursive(root, value);
    }

    private boolean containsValueRecursive(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (value == node.value) {
            return true;
        }
        return value < node.value
                ? containsValueRecursive(node.left, value)
                : containsValueRecursive(node.right, value);
    }

    // Метод получения строки
    public String getTreeAsString() {
        if (root == null) {
            return "Дерево пусто";
        }
        return root.toString();
    }


}