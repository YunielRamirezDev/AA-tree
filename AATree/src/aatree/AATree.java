/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aatree;

import java.util.Scanner;

/**
 *
 * @author JC
 */
public class AATree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student Dean = new Student("Dean", 25, 5);
        Student Manuel = new Student("Manuel", 25, 5);
        Student Albert = new Student("Albert", 25, 5);
        Student Richard = new Student("Richard", 25, 5);
        Student Jose = new Student("Jose", 25, 5);
        Student Daniel = new Student("Daniel", 25, 5);
        Student Enrique = new Student("Enrique", 25, 5);
        Student Aaron = new Student("Aaron", 25, 5);
        Student Pedro = new Student("Pedro", 25, 5);
        Student Leo = new Student("Leo", 25, 5);

        Node nodeDean = new Node(10, 0, Dean, null, null);
        Node nodeManuel = new Node(22, 0, Manuel, null, null);
        Node nodeAlbert = new Node(63, 0, Albert, null, null);
        Node nodeRichard = new Node(42, 0, Richard, null, null);
        Node nodeJose = new Node(3, 0, Jose, null, null);
        Node nodeDaniel = new Node(16, 0, Daniel, null, null);
        Node nodeEnrique = new Node(37, 0, Enrique, null, null);
        Node nodeAaron = new Node(8, 0, Aaron, null, null);
        Node nodePedro = new Node(89, 0, Pedro, null, null);
        Node nodeLeo = new Node(11, 0, Leo, null, null);

        Node[] nodes = {
            //            nodeDean,
            nodeManuel,
            nodeAlbert,
            nodeRichard,
            nodeJose,
            nodeDaniel,
            nodeEnrique,
            nodeAaron,
            nodePedro,
            nodeLeo
        };

        Tree tree = new Tree(nodeDean);

        System.out.println("addedyng...");
        for (Node node : nodes) {
            tree.insertNode(tree.getRoot(), node);
            System.out.println(node.getStudent().getName() + " " + "has been added...");
        }

        //function that list all nodes
        System.out.println("|||||||||||||||||||||||");
        System.out.println("listing all nodes...");
        System.out.println("");
        show(tree.getRoot());
        System.out.println("|||||||||||||||||||||||");

        //function that find a specific node
        Node nodeFound = tree.findNode(tree.getRoot(), nodeRichard);
        System.out.println("|||||||||||||||||||||||");

        System.out.println("information of: " + nodeFound.getStudent().getName());
        System.out.println("\n"
                + "name: " + nodeFound.getStudent().getName() + "\n"
                + "age: " + nodeFound.getStudent().getAge() + "\n"
                + "average: " + nodeFound.getStudent().getAverage()
        );
        System.out.println("|||||||||||||||||||||||");

        //function that delete a specific node
        Node NodeDelete = tree.deleteNode(tree.getRoot(), nodeDaniel);
        System.out.println("|||||||||||||||||||||||");
        
        //function that list all nodes after of delete a specific node
        System.out.println("|||||||||||||||||||||||");
        System.out.println("listing all nodes...");
        System.out.println("");
        show(tree.getRoot());
        System.out.println("|||||||||||||||||||||||");

    }

    private static void show(Node root) {
        if (root.getLeft() == null && root.getRight() == null) {
            System.out.println(root.getStudent().getName() + " is a leaf");
        }
        if (root.getLeft() != null) {
            System.out.println(root.getLeft().getStudent().getName() + " is left son of " + root.getStudent().getName());
            show(root.getLeft());
        }
        if (root.getRight() != null) {
            System.out.println(root.getRight().getStudent().getName() + " is right son of " + root.getStudent().getName());
            show(root.getRight());
        }
    }
}
