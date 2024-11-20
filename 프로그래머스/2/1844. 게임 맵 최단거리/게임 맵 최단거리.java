import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[][] move = new int[maps.length][maps[0].length];
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        move[0][0]=1;

        int distance = 0;
        int nowX = 0;
        int nowY = 0;

        int[] x = {1,-1,0,0};
        int[] y = {0, 0,1,-1};

        while(queue.size()!=0){
            int[] now = queue.poll();
            maps[now[0]][now[1]]=0;

            for(int i=0;i<4;i++){
                int dx = now[0]+x[i];
                int dy = now[1]+y[i];
                if(dx>=0&&dx<maps.length&&dy>=0&&dy<maps[0].length&&maps[dx][dy]==1&&visited[dx][dy] == false){
                    queue.offer(new int[]{dx,dy});
                    move[dx][dy] = move[now[0]][now[1]]+1;
                    visited[dx][dy] = true;
                    if(dx==maps.length-1&&dy==maps[0].length-1){
                        return move[dx][dy];
                    }
                }
            }

        }
        return -1;
    }
}