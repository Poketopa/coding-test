import java.util.*;


class Solution {
    public int solution(int[][] maps) {
        int xLength = maps.length;
        int yLength = maps[0].length;
        int nowX = 0;
        int nowY = 0;
        
        int move[][] = new int[xLength][yLength];
        boolean visited[][] = new boolean[xLength][yLength];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        move[0][0] = 1;
        visited[0][0] = true;
        
        
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];

            if (x == xLength - 1 && y == yLength - 1) {
                return move[x][y];
            }

            if (x + 1 < xLength && maps[x + 1][y] == 1) {
                if (!visited[x + 1][y]) {
                    queue.offer(new int[]{x + 1, y});
                    move[x + 1][y] = move[x][y] + 1;
                    visited[x+1][y] = true;
                }

            }
            if (x > 0 && maps[x - 1][y] == 1) {
                if (!visited[x - 1][y]) {
                    queue.offer(new int[]{x - 1, y});
                    move[x - 1][y] = move[x][y] + 1;
                    visited[x-1][y] = true;
                }

            }
            if (y + 1 < yLength && maps[x][y + 1] == 1) {
                if (!visited[x][y + 1]) {
                    queue.offer(new int[]{x, y + 1});
                    move[x][y + 1] = move[x][y] + 1;
                    visited[x][y+1] = true;
                }

            }
            
            if (y > 0 && maps[x][y - 1] == 1) {
                if (!visited[x][y - 1]) {
                    queue.offer(new int[]{x, y - 1});
                    move[x][y - 1] = move[x][y] + 1;
                    visited[x][y-1] = true;

                }

            }
        }
        return -1;
    }

}
