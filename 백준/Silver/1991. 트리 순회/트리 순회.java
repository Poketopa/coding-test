

import java.io.*;
import java.util.*;
import java.math.*;

class Node{
    char name;
    Node left, right;

    public Node(char name){
        this.name = name;
        left = null;
        right = null;
    }
}

class binaryTree{
    Node root;

    public void insert(char parent, char left, char right){
        if(root == null){
            root = new Node(parent);
        }
        searchAndInsert(root, parent, left, right);
    }

    public void searchAndInsert(Node node, char parent, char left, char right){
        if(node == null) return;

        if(node.name == parent){
            if(left != '.') node.left = new Node(left);
            if(right != '.') node.right = new Node(right);
        }
        else{
            searchAndInsert(node.left, parent, left, right);
            searchAndInsert(node.right, parent, left, right);
        }
    }

    void preOrder(Node node, BufferedWriter bw) throws IOException {
        if(node == null) return;
        bw.write(node.name);
        preOrder(node.left, bw);
        preOrder(node.right, bw);
    }

    void inOrder(Node node, BufferedWriter bw) throws IOException {
        if(node == null) return;
        inOrder(node.left, bw);
        bw.write(node.name);
        inOrder(node.right, bw);
    }

    void postOrder(Node node, BufferedWriter bw) throws IOException {
        if(node == null) return;
        postOrder(node.left, bw);
        postOrder(node.right, bw);
        bw.write(node.name);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());

        binaryTree tree = new binaryTree();

        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.insert(parent, left, right);
        }

        tree.preOrder(tree.root, bw);
        bw.newLine();
        tree.inOrder(tree.root, bw);
        bw.newLine();
        tree.postOrder(tree.root, bw);
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }


}