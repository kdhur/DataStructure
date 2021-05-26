package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Node2 {
    int value;
    Node leftChild;
    Node rightChild;

    public Node2(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }
}

class BinaryTree2 {
    Node root = null;

    public void insertNode(int element) {
        if (root == null) {
            root = new Node(element);
        }
        else {
            Node head = root;
            Node current;

            while(true) {
                current = head;

                if (head.value > element) {
                    if (head.leftChild == null) {
                        current.leftChild = new Node(element);
                        break;
                    }
                    head = head.leftChild;
                }
                else {
                    if (head.rightChild == null) {
                        current.rightChild = new Node(element);
                        break;
                    }
                    head = head.rightChild;
                }
            }
        }
    }

    public void inorderTree(Node root, int depth) {
        if (root != null) {
            inorderTree(root.leftChild, depth + 1);
            System.out.print(root.value + " ");
            inorderTree(root.rightChild, depth + 1);
        }
    }

    public void postorderTree(Node root, int depth) {
        if (root != null) {
            postorderTree(root.leftChild, depth + 1);
            postorderTree(root.rightChild, depth + 1);
            System.out.print(root.value + " ");
        }
    }

    public void preorderTree(Node root, int depth) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorderTree(root.leftChild, depth + 1);
            preorderTree(root.rightChild, depth + 1);
        }
    }

    public void levelorderTree(Node root) {
        Queue<Node> q = new ArrayDeque();
        q.add(root);
        Node n;

        while(!q.isEmpty()) {
            n = q.remove();

            if(n != null) {
                System.out.print(n.value + " ");
                if (n.leftChild != null) {
                    q.add(n.leftChild);
                }
                if (n.rightChild != null) {
                    q.add(n.rightChild);
                }
            }
        }
    }
}

public class Problem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());
        BinaryTree2 tree = new BinaryTree2();

        String line = br.readLine();
        String[] linesplit = line.split(" ");
        int[] element = new int[nodeCount];

        for (int i = 0; i < nodeCount; i++) {
            element[i] = Integer.parseInt(linesplit[i]);
            tree.insertNode(element[i]);
        }

        tree.preorderTree(tree.root, 0);
        System.out.println();
        tree.inorderTree(tree.root, 0);
        System.out.println();
        tree.postorderTree(tree.root, 0);
        System.out.println();
        tree.levelorderTree(tree.root);
    }
}

