package algorithms;

/**
 * @author Jin Shuai
 */
public class RedBlackTreeImpl<T> implements RedBlackTree<T> {
    private Node<T> root;

    @Override
    public void insert(int i, T val) {
        Node<T> addNode = new Node<>(i,val, Color.RED);
        if(root == null){
            root = addNode;
            root.color = Color.BLACK;
        } else {
            insertNode(addNode);
        }
    }

    private void insertNode(Node<T> addNode) {
        int key = addNode.key;
        Node<T> current = root;
        while(current != null){
            if(key > current.key){
                current = current.right;
            } else {
                current = current.left;
            }
        }
        if(current == leftOfNode(current.parent)){
//            addNode.parent = current.parent
        }
    }

    @Override
    public void delete(int i) {

    }

    public Node leftOfNode(Node node){
        if(node == null){
            return null;
        }
        return node.left;
    }

    public Node rightOfNode(Node node){
        if(node == null){
            return null;
        }
        return node.right;
    }

    private  enum  Color{
        BLACK,RED;
    }
    private static class Node<T>{
        private int key;
        private T value;
        private Color color;
        private Node<T> parent;
        private Node<T> left;
        private Node<T> right;

        public Node(int key, T value, Color color) {
            this.key = key;
            this.value = value;
            this.color = Color.RED;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
    }
}
