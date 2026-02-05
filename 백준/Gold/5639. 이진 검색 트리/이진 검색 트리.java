import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int number;
    Node left, right;

    Node(int number) {
        this.number = number;
    }

    void insert(int n){
        if(n < number){
            if(this.left == null) this.left = new Node(n);
            else this.left.insert(n);
        } else {
            if(this.right == null) this.right = new Node(n);
            else this.right.insert(n);
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int rootNum = Integer.parseInt(br.readLine());
        Node root = new Node(rootNum);

        while (true) {
            String input = br.readLine();
            if(input == null || input.isEmpty()) break;
            int inputNum = Integer.parseInt(input);

            root.insert(inputNum);
        }

        printPostOrder(root);
    }

    public static void printPostOrder(Node node){
        if(node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node.number);
    }
}
