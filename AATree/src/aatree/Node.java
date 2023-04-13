/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aatree;

/**
 *
 * @author JC
 */
public class Node {

    int id;
    int level;
    Student student;
    Node left, right;
    

    public Node(int id, int level, Student student, Node left, Node right) {
        this.id = id;
        this.level = level;
        this.student = student;
        this.left = left;
        this.right = right;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int compareTo(Node n) {
        return (this.getId() < n.getId()) ? -1 : (this.getId() > n.getId() ? 1 : 0);
    }
}
