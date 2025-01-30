import java.util.*;
import java.math.*;

class Solution {
    static int min = Integer.MAX_VALUE;
    class Node{
        int y;
        int x;
        int cost;
        int direction;

        Node(int y, int x, int cost, int direction){
            this.y = y;
            this.x = x;
            this.cost = cost;
            this.direction = direction;
        }
    }

    public int solution(int[][] board) {
        int length = board.length;
        int[][][] visited = new int[length][length][4];
        int[] xLotate = {1, -1, 0, 0};
        int[] yLotate = {0, 0, 1, -1};

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 0, 0, -1));

        bfs(queue, board, visited, length, xLotate, yLotate);

        return min;
    }

    private void bfs(Queue<Node> queue, int[][] board, int[][][] visited, int length, int[] xLotate, int[] yLotate){

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int y = node.y; int x = node.x; int cost = node.cost; int direction = node.direction;
            if(y == length-1 && x == length - 1)
                min = Math.min(min, cost);
            for(int i=0;i<4;i++){
                int nowY = y + yLotate[i];
                int nowX = x + xLotate[i];
                if(nowY < 0 || nowY >= length || nowX < 0 || nowX >= length || board[nowY][nowX] == 1){
                    continue;
                }
                if(direction == -1 || direction == i){
                    if(visited[nowY][nowX][i] == 0 || visited[nowY][nowX][i] > cost + 100){
                        queue.add(new Node(nowY, nowX, cost + 100, i));
                        visited[nowY][nowX][i] = cost + 100;
                    }
                }
                else{
                    if(visited[nowY][nowX][i] == 0 || visited[nowY][nowX][i] > cost + 600){
                        queue.add(new Node(nowY, nowX, cost +600, i));
                        visited[nowY][nowX][i] = cost + 600;
                    }
                }
            }
        }
    }
}


