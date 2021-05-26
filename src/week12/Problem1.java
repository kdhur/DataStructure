package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Node {
    int value;
    Node leftChild;
    Node rightChild;

    public Node(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }
}

class BinaryTree {
    Node root = null;

    public void insert(String data, String leftdata, String rightdata) {
        if(root == null) {
            if(!data.equals(".")) {
                root = new Node(Integer.parseInt(data));
            }
            if(!leftdata.equals(".")) {
                root.leftChild = new Node(Integer.parseInt(leftdata));
            }
            if(!rightdata.equals(".")) {
                root.rightChild = new Node(Integer.parseInt(rightdata));
            }
        }
        else {
            search(root, data, leftdata, rightdata);
        }
    }

    public void search(Node root, String data, String leftdata, String rightdata) {
        if (root == null) {
            return;
        }
        else if(root.value == Integer.parseInt(data)) {
            if (!leftdata.equals(".")) {
                root.leftChild = new Node(Integer.parseInt(leftdata));
            }
            if (!rightdata.equals(".")) {
                root.rightChild = new Node(Integer.parseInt(rightdata));
            }
        }
        else {
            search(root.leftChild, data, leftdata, rightdata);
            search(root.rightChild, data, leftdata, rightdata);
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

public class Problem1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(br.readLine());
        BinaryTree tree = new BinaryTree();


        for (int i = 0; i < lines; i++) {
            String line = br.readLine();
            String[] element = line.split(" ");
            tree.insert(element[0], element[1], element[2]);
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
