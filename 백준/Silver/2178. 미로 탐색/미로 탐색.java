

import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int yLen = Integer.parseInt(st.nextToken());
        int xLen = Integer.parseInt(st.nextToken());

        int[][] maze = new int[yLen][xLen];
        int[][] visited = new int[yLen][xLen];
        for(int i=0;i<yLen;i++){
            String input = br.readLine();
            for(int j=0;j<xLen;j++){
                maze[i][j] = Integer.valueOf(input.charAt(j)) - 48;
            }
        }
        int[] y = {1, -1, 0, 0};
        int[] x = {0, 0, 1, -1};
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.y == maze.length-1 && node.x == maze[0].length-1){
                System.out.println(node.count);
                return;
            }
            for(int i=0;i<4;i++){
                int newY = node.y + y[i];
                int newX = node.x + x[i];
                if(0<=newY && newY <maze.length
                && 0<=newX && newX <maze[0].length && maze[newY][newX] == 1 && visited[newY][newX] == 0){
                    visited[newY][newX] = 1;
                    queue.add(new Node(newY, newX, node.count + 1));
                }
            }
        }

    }

    public static class Node{
        int y;
        int x;
        int count;

        public Node(int y, int x, int count){
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}