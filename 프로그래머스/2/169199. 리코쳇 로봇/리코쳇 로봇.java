import java.util.*;

class Solution {
    static int min = Integer.MAX_VALUE;
    public int solution(String[] board) {
        Queue<int[]> queue = new LinkedList<>();
        Queue<Integer> count = new LinkedList<>();
        int counter = 0;
        int[][] visited = new int[board.length][board[0].length()];
        int[][] map = new int[board.length][board[0].length()];
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        int startY = 0;
        int startX = 0;
        int endY = 0;
        int endX = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length();j++){
                if(board[i].charAt(j) == 'D'){
                    map[i][j] = 1;
                }
                if(board[i].charAt(j) == 'R'){
                    startY = i;
                    startX = j;
                }
                if(board[i].charAt(j) == 'G'){
                    endY = i;
                    endX = j;
                }
            }
        }
        // 큐 첫번째 넣기
        queue.add(new int[]{startY, startX});
        count.add(counter);

        bfs(count, queue, map, visited, endY, endX, x, y);
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }

    private void bfs(Queue<Integer> count, Queue<int[]> queue, int[][] map, int[][] visited, int endY, int endX, int[] x, int[] y){

        while(!queue.isEmpty()){
            // 큐 팝, 현재 좌표 얻기
            int[] now = queue.poll();
            int counter = count.poll();
            counter++;
            int nowY =  now[0];
            int nowX =  now[1];
            // 정답 확인
            if(nowY == endY && nowX == endX){
                if(min>counter - 1) {
                    min = counter - 1;
                }
            }
            // 방문 확인
            if(visited[nowY][nowX] == 1) continue;
            visited[nowY][nowX] = 1;
            for(int i=0;i<4;i++){
                int tempY = nowY;
                int tempX = nowX;
                while(true){
                    if(tempY + y[i] == -1
                            || tempX + x[i] == -1
                            || tempY + y[i] == visited.length
                            || tempX + x[i] == visited[0].length
                            || (map[tempY+y[i]][tempX+x[i]] == 1)){
                        break;
                    }
                    tempY += y[i];
                    tempX += x[i];
                }
                if(visited[tempY][tempX] == 1) continue;
                queue.add(new int[]{tempY, tempX});
                count.add(counter);
            }
        }
    }
}