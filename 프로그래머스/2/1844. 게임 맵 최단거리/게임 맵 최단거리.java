import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int xLength = maps.length;
        int yLength = maps[0].length;

        // 방문 여부를 확인할 visited 배열
        boolean[][] visited = new boolean[xLength][yLength];
        int[][] move = new int[xLength][yLength];  // 이동 거리 저장
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});
        move[0][0] = 1;
        visited[0][0] = true;

        // 방향 배열 (상, 하, 좌, 우)
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];

            // 목표 지점 도달 시 이동 거리 반환
            if (x == xLength - 1 && y == yLength - 1) {
                return move[x][y];
            }

            // 상, 하, 좌, 우로 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 경계를 벗어나지 않고 방문하지 않은 곳만 이동
                if (nx >= 0 && ny >= 0 && nx < xLength && ny < yLength && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    move[nx][ny] = move[x][y] + 1;
                    visited[nx][ny] = true;  // 큐에 추가할 때 바로 방문 처리
                }
            }
        }

        // 목표 지점에 도달할 수 없는 경우 -1 반환
        return -1;
    }
}