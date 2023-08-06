package q1;

/**
 *
 * @author 
 */
public class BSTNode {

    private int data;
    private int count; // for duplicate value
    private BSTNode leftChild;
    private BSTNode rightChild;
    private BSTNode parent;

    private int level;
    private int order;

    public enum NodeType {
        LEFT_CHILD,
        RIGHT_CHILD;
    }

    /*=== for drawing ===*/
    public static final int LEVEL_DY = 60;
    private int x;
    private int y;
    private int width;//from x canvas left to x node

    /*=== for drawing ===*/
    public BSTNode(int data) {
        this.data = data;
        this.count = 1;
        this.leftChild = this.rightChild = this.parent = null;
        this.level = 0;
        this.order = 0;

        //==== for drawing ====//
        this.x = 0;
        this.y = 0;
        this.width = 0;
    }

    public BSTNode(int data, int y, int screenwidth) {
        this.data = data;
        this.count = 1;
        this.leftChild = this.rightChild = this.parent = null;
        this.level = 0;
        this.order = 0;
        //==== for drawing
        this.x = this.width = screenwidth / 2;
        this.y = y;
    }

    //function//
    public boolean isLeaf() {
        return this.leftChild == null && this.rightChild == null;
    }

    public boolean hasChild() {
        return !isLeaf();
    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    public boolean isRoot() {
        return this.parent == null;
    }

    public boolean isInside() {
        return !isLeaf() && !isRoot();
    }

    //getter && setter
    public int getData() {
        return data;
    }

    public int getCount() {
        return count;
    }

    public BSTNode getLeftChild() {
        return leftChild;
    }

    public BSTNode getRightChild() {
        return rightChild;
    }

    public BSTNode getParent() {
        return parent;
    }

    public int getLevel() {
        return level;
    }

    public int getOrder() {
        return order;
    }

    public static int getLEVEL_DY() {
        return LEVEL_DY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setLeftChild(BSTNode leftChild) {
        this.leftChild = leftChild;
        if (leftChild != null) {
            this.leftChild.setParent(this, NodeType.LEFT_CHILD);
        }
    }

    public void setRightChild(BSTNode rightChild) {
        this.rightChild = rightChild;
        if (rightChild != null) {
            this.rightChild.setParent(this, NodeType.RIGHT_CHILD);
        }
    }

    public void setParent(BSTNode parent, NodeType type) {
        this.parent = parent;
        this.level = parent.getLevel() + 1;
        if (type == NodeType.LEFT_CHILD) {
            this.order = parent.getOrder() * 2 + 1;
        } else {
            this.order = parent.getOrder() * 2 + 2;
        }
        //==== for drawing
        this.width = parent.getWidth() / 2;
        if (type == NodeType.LEFT_CHILD) {
            //this.x = parent.getX() - (this.width + 5 - this.level);
            this.x = parent.getX() - this.width;
        } else {
            this.x = parent.getX() + this.width;
        }
        this.y = parent.getY() + LEVEL_DY;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public BSTNode findMaxNode() {
        BSTNode node = this;
        while (node.hasRightChild()) {
            node = node.getRightChild();
        }
        return node;
    }

    public BSTNode findMinNode() {
        BSTNode node = this;
        while (node.hasLeftChild()) {
            node = node.getLeftChild();
        }
        return node;
    }

    public boolean removeLeafChild(BSTNode node) {
        if (node == null) {
            return false;
        }
        if (node.isLeaf()) {
            if (this.hasLeftChild()) {
                if (this.getLeftChild().getData() == node.getData()) {
                    this.setLeftChild(null); // remove the left child
                    return true;
                }
            }
            if (this.hasRightChild()) {
                if (this.getRightChild().getData() == node.getData()) {
                    this.setRightChild(null); // remove the right child
                    return true;
                }
            }
        }
        return false;
    }
}
