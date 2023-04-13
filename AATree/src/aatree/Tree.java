/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aatree;

public class Tree {

    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Tree() {
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node skew(Node node) {
        if (node == null) {
            return node;
        } else {
            if (node.getLeft() != null) {
                if (node.getLevel() == node.getLeft().getLevel()) {
                    Node nodeLeft = node.getLeft();
                    node.setLeft(nodeLeft.getRight());
                    nodeLeft.setRight(node);
                    return nodeLeft;
                } else {
                    return node;
                }

            } else {
                return node;
            }
        }
    }

    public Node split(Node node) {
        if (node == null) {
            return node;
        } else {
            if (node.getRight() != null) {
                if (node.getRight().getRight() != null) {
                    if (node.getLevel() == node.getRight().getRight().getLevel()) {
                        Node nodeRight = node.getRight();
                        node.setRight(nodeRight.getLeft());
                        nodeRight.setLeft(node);
                        nodeRight.setLevel(nodeRight.getLevel() + 1);
                        return nodeRight;
                    }
                    return node;
                }
                return node;
            }
            return node;
        }
    }

    public Node insertNode(Node root, Node node) {
        if (root == null) {
            root = node;
        } else {
            int value = node.compareTo(root);
            if (value == -1) {
                root.setLeft(insertNode(root.getLeft(), node));
            }
            if (value == 1) {
                root.setRight(insertNode(root.getRight(), node));
            }
        }
        root = skew(root);
        root = split(root);

        return root;
    }

    public Node deleteNode(Node root, Node node) {

        int value = node.compareTo(root);

        if (value == -1) {
            root.setLeft(deleteNode(root.getLeft(), node));
        }
        if (value == 1) {
            root.setRight(deleteNode(root.getRight(), node));
        }
        if (value == 0) {
            if (isLeaf(root)) {
                root = null;
            } else {
                if (root.getLeft() == null) {
                    Node nodeSuccessor = successorNode(root.getRight());
                    root.setRight(deleteNode(nodeSuccessor, root.getRight()));
                    root.setStudent(nodeSuccessor.getStudent());
                }
                if (root.getRight() == null) {
                    Node nodePredecessor = predecessorNode(root.getLeft());
                    root.setLeft(deleteNode(nodePredecessor, root.getLeft()));
                    root.setStudent(nodePredecessor.getStudent());
                }
            }
        }
        root = decreaseLevel(root);
        root = skew(root);
        root.setRight(skew(root.getRight()));
        root.getRight().setRight(skew(root.getRight().getRight()));
        root = split(root);
        root.setRight(split(root.getRight()));
         return root;
    }

    //check if a node is a leaf
    public boolean isLeaf(Node node) {
        return (node.getLeft() == null && node.getRight() == null) ? true : false;
    }

    public Node successorNode(Node node) {
        if (node.getLeft() == null) {
            return node;
        } else {
            return successorNode(node.getLeft());
        }
    }

    public Node predecessorNode(Node node) {
        if (node.getRight() == null) {
            return node;
        } else {
            return predecessorNode(node.getRight());
        }
    }

    public Node decreaseLevel(Node node) {
        int newLevel = 0;
        if (node != null) {
            if (node.getLeft() != null && node.getRight() != null) {
                newLevel = min(node.getLeft().getLevel(), node.getRight().getLevel()) + 1;
            }
            if (node.getLeft() != null || node.getRight() != null) {
                newLevel = node.getLeft() != null ? node.getLeft().getLevel() + 1 : node.getRight().getLevel() + 1;
            }

            if (newLevel < node.getLevel()) {
                node.setLevel(newLevel);
                if (newLevel < node.getRight().getLevel()) {
                    node.getRight().setLevel(newLevel);
                }
            }
            return node;
        }
        return node;
    }

    public int min(int firstValue, int secondValue) {
        return firstValue > secondValue ? secondValue : firstValue;
    }

    public Node findNode(Node root, Node node) {

        int value = node.compareTo(root);

        return (value == -1) ? findNode(root.getLeft(), node) : ((value == 1) ? findNode(root.getRight(), node) : root);
    }
}
