import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int mapLength = Integer.parseInt(br.readLine());
        int appleCount = Integer.parseInt(br.readLine());
        int[][] map = new int[mapLength][mapLength];
        for(int i=0;i<appleCount;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());
            map[row-1][column-1] = 2;
            // 사과는 2, 벌레는 1
        }
        int input = Integer.parseInt(br.readLine());
        int[] moveInt = new int[input];
        String[] moveString = new String[input];
        for(int i=0;i<input;i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            moveInt[i] = Integer.parseInt(st2.nextToken());
            moveString[i] = st2.nextToken();
        }
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        int[] head = {0, 0};
        map[0][0] = 1;
        int direction = 1;
        // 위0 오른쪽1 아래2 왼쪽3
        int index = 0;
        int count = 0;
        queue.add(new int[]{0, 0});

        while(true){
            if(direction == 1){
                head[1]++;
                if(head[0] < 0 || mapLength <= head[0]
                        || head[1] < 0 || mapLength <= head[1]
                        || map[head[0]][head[1]] == 1){
                    break;
                }
                if(map[head[0]][head[1]] == 2){
                    map[head[0]][head[1]] = 1;
                    queue.add(new int[]{head[0], head[1]});
                }
                else{
                    map[head[0]][head[1]] = 1;
                    queue.add(new int[]{head[0], head[1]});
                    int[] remove = queue.poll();
                    map[remove[0]][remove[1]] = 0;
                }
            }
            else if(direction == 2){
                head[0]++;
                if(head[0] < 0 || mapLength <= head[0]
                        || head[1] < 0 || mapLength <= head[1]
                        || map[head[0]][head[1]] == 1){
                    break;
                }
                if(map[head[0]][head[1]] == 2){
                    map[head[0]][head[1]] = 1;
                    queue.add(new int[]{head[0], head[1]});
                }
                else{
                    map[head[0]][head[1]] = 1;
                    queue.add(new int[]{head[0], head[1]});
                    int[] remove = queue.poll();
                    map[remove[0]][remove[1]] = 0;

                }
            }
            else if(direction == 3){
                head[1]--;
                if(head[0] < 0 || mapLength <= head[0]
                        || head[1] < 0 || mapLength <= head[1]
                        || map[head[0]][head[1]] == 1){
                    break;
                }
                if(map[head[0]][head[1]] == 2){
                    map[head[0]][head[1]] = 1;
                    queue.add(new int[]{head[0], head[1]});
                }
                else{
                    map[head[0]][head[1]] = 1;
                    queue.add(new int[]{head[0], head[1]});
                    int[] remove = queue.poll();
                    map[remove[0]][remove[1]] = 0;
                }
            }
            else{
                head[0]--;
                if(head[0] < 0 || mapLength <= head[0]
                        || head[1] < 0 || mapLength <= head[1]
                        || map[head[0]][head[1]] == 1){
                    break;
                }
                if(map[head[0]][head[1]] == 2){
                    map[head[0]][head[1]] = 1;
                    queue.add(new int[]{head[0], head[1]});
                }
                else{
                    map[head[0]][head[1]] = 1;
                    queue.add(new int[]{head[0], head[1]});
                    int[] remove = queue.poll();
                    map[remove[0]][remove[1]] = 0;
                }
            }


            count++;
            if(index < moveInt.length && count == moveInt[index]){
                if(moveString[index].equals("L")){
                    direction--;
                    if(direction == -1) direction = 3;
                }
                else{
                    direction++;
                    direction %= 4;
                }
                index++;
            }
        }
        System.out.println(count + 1);
    }
}
