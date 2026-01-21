import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public boolean isSame(Node node){
            if(this.y == node.y && this.x == node.x){
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        char[][] map1 = new char[row][column];
        char[][] map2 = new char[row][column];
        int[][] visited1 = new int[row][column];
        int[][] visited2 = new int[row][column];
        List<Node> nodeList1 = new ArrayList<>();
        List<Node> nodeList2 = new ArrayList<>();
        int[] y = {1, -1, 0, 0};
        int[] x = {0, 0, 1, -1};

        for(int i=0;i<row;i++){
            String input = br.readLine();
            for(int j=0;j<column;j++){
                map1[i][j] = input.charAt(j);
            }
        }
        for(int i=0;i<row;i++){
            String input = br.readLine();
            for(int j=0;j<column;j++){
                map2[i][j] = input.charAt(j);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for(int k=0;k<row;k++){
            for(int l=0;l<column;l++){
                if(visited1[k][l] == 0){
                    char alpha = map2[k][l];
                    char correct = map1[k][l];
                    queue.add(new int[]{k,l});
                    visited1[k][l] = 1;
                    map1[k][l] = alpha;

                    while(!queue.isEmpty()){
                        int[] temp = queue.poll();
                        nodeList1.add(new Node(temp[0], temp[1]));
                        for(int i=0;i<4;i++){
                            int newY = temp[0] + y[i];
                            int newX = temp[1] + x[i];

                            if(0 <= newY && newY < row
                                    && 0 <= newX && newX < column
                                    && visited1[newY][newX] == 0
                                    && correct == map1[newY][newX]){
                                queue.add(new int[]{newY, newX});
                                visited1[newY][newX] = 1;
                                map1[newY][newX] = alpha;
                            }
                        }
                    }
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(map1[i][j] != map2[i][j]){
                    System.out.print("NO");
                    return;
                }
            }
        }
        System.out.print("YES");
    }
}
