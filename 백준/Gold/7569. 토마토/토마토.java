
import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer input = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(input.nextToken());
        int column = Integer.parseInt(input.nextToken());
        int stair = Integer.parseInt(input.nextToken());
        int[][][] tomato = new int[stair][column][row];
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        int[] z = {1, -1};
        // 익지 않은 토마토
        int howManyTomato = 0;
        int howManyWall = 0;
        for(int i=0;i<stair;i++){
            for(int j=0;j<column;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0;k<row;k++){
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if(tomato[i][j][k] == 1) howManyTomato++;
                    else if(tomato[i][j][k] == -1) howManyWall++;
                }
            }
        }
        int requreTomato = (row*column*stair) - howManyWall - howManyTomato;
        // 정리들어간다
        // 1. 초기값에서 익은 토마토를 큐에 넣는다
        // 2. 반복문으로 전염 가능한 토마토를 확인한다 (틱 카운트 + 1)
        // -> 이때 전염 가능한 토마토가 없다면? (다 찼거나 벽에 막혔거나)
        //  (1) 초기 토마토 개수와 같을 경우 (다 찼을 경우)
        //  (2) 초기 토마토 개수와 다를 경우 (벽에 막혔을 때
        Queue<Node> queue = new LinkedList<>();
        for(int i=0;i<stair;i++) {
            for (int j = 0; j < column; j++) {
                for (int k = 0; k < row; k++) {
                    if(tomato[i][j][k] == 1){
                        queue.add(new Node(i,j,k,0));
                    }
                }
            }
        }

        int newTomatoCount = 0;
        int max = -1;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.count > max) max = node.count;
            for (int i = 0; i < 4; i++) {
                int newX = node.x + x[i];
                int newY = node.y + y[i];
                if (0 <= newY && 0 <= newX
                        && newY < column && newX < row
                        && tomato[node.z][newY][newX] == 0) {
                    newTomatoCount++;
                    tomato[node.z][newY][newX] = 1;
                    queue.add(new Node(node.z, newY, newX, node.count + 1));
                }
            }
            for(int i=0;i<2;i++){
                int newZ = node.z + z[i];
                if(0<=newZ && newZ < stair
                && tomato[newZ][node.y][node.x] == 0){
                    newTomatoCount++;
                    tomato[newZ][node.y][node.x] = 1;
                    queue.add(new Node(newZ, node.y, node.x, node.count + 1));
                }
            }
        }
        // 다 익지 못했을 떄
        if(newTomatoCount != requreTomato){
            System.out.println("-1");
        }
        else {
            System.out.println(max);
        }
    }

    public static class Node{
        int y;
        int x;
        int z;
        int count;

        Node(int z, int y, int x, int count){
            this.y = y;
            this.x = x;
            this.z = z;
            this.count = count;
        }
    }
}