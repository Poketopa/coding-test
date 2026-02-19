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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        x: for(int i=0; i<input; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int beforeY = changeEngToNum(st.nextToken());
            int beforeX = Integer.parseInt(st.nextToken());
            int afterY = changeEngToNum(st.nextToken());
            int afterX = Integer.parseInt(st.nextToken());

            if((beforeX + beforeY) % 2 != (afterX + afterY) % 2){
                System.out.println("Impossible");
                continue;
            }

            int[][] visited = new int[9][9];

            Queue<Object[]> queue = new LinkedList<>();
            queue.add(new Object[]{beforeY, beforeX, changeNumToEng(beforeY) + " " + beforeX, 0});
            visited[beforeY][beforeX] = 1;

            while(!queue.isEmpty()){
                Object[] temp = queue.poll();
                int y = (int) temp[0];
                int x = (int) temp[1];
                int count = (int) temp[3];
                if(y == afterY && x == afterX){
                    System.out.println(count +" "+ temp[2]);
                    continue x;
                }

                String path = (String) temp[2];

                int tempNum1 = 1;
                while (y - tempNum1 >= 1 && x - tempNum1 >= 1) {
                    int ny = y - tempNum1;
                    int nx = x - tempNum1;
                    if (visited[ny][nx] != 1) {
                        queue.add(new Object[]{ny, nx, path + " " + changeNumToEng(ny) + " " + nx, count + 1});
                        visited[ny][nx] = 1;
                    }
                    tempNum1++;
                }

                int tempNum2 = 1;
                while (y - tempNum2 >= 1 && x + tempNum2 <= 8) {
                    int ny = y - tempNum2;
                    int nx = x + tempNum2;
                    if (visited[ny][nx] != 1) {
                        queue.add(new Object[]{ny, nx, path + " " + changeNumToEng(ny) + " " + nx, count + 1});
                        visited[ny][nx] = 1;
                    }
                    tempNum2++;
                }

                int tempNum3 = 1;
                while (y + tempNum3 <= 8 && x - tempNum3 >= 1) {
                    int ny = y + tempNum3;
                    int nx = x - tempNum3;
                    if (visited[ny][nx] != 1) {
                        queue.add(new Object[]{ny, nx, path + " " + changeNumToEng(ny) + " " + nx, count + 1});
                        visited[ny][nx] = 1;
                    }
                    tempNum3++;
                }

                int tempNum4 = 1;
                while (y + tempNum4 <= 8 && x + tempNum4 <= 8) {
                    int ny = y + tempNum4;
                    int nx = x + tempNum4;
                    if (visited[ny][nx] != 1) {
                        queue.add(new Object[]{ny, nx, path + " " + changeNumToEng(ny) + " " + nx, count + 1});
                        visited[ny][nx] = 1;
                    }
                    tempNum4++;
                }
            }
        }
    }

    public static int changeEngToNum(String input){
        if(input.equals("H")) return 1;
        if(input.equals("G")) return 2;
        if(input.equals("F")) return 3;
        if(input.equals("E")) return 4;
        if(input.equals("D")) return 5;
        if(input.equals("C")) return 6;
        if(input.equals("B")) return 7;
        if(input.equals("A")) return 8;
        return 0;
    }

    public static String changeNumToEng(int input){
        if(input == 1) return "H";
        if(input == 2) return "G";
        if(input == 3) return "F";
        if(input == 4) return "E";
        if(input == 5) return "D";
        if(input == 6) return "C";
        if(input == 7) return "B";
        if(input == 8) return "A";
        return "";
    }
}
