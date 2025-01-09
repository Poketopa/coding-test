import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        // 맵 생성
        int[][] map = new int[maps.length][maps[0].length()];
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(maps[i].charAt(j) == 'X') map[i][j] = -1;
                else map[i][j] = (int)(maps[i].charAt(j)) - 48;
            }
        }
        // 큐
        Queue<int[]> queue = new LinkedList<>();
        int[] rotateY = new int[] {1, -1, 0, 0};
        int[] rotateX = new int[] {0, 0, 1, -1};
        int y = 0;
        int x = 0;
        // 답 리스트
        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j] == -1) continue;
                else{
                    queue.offer(new int[] {i, j});
                    answer.add(bfs(map, queue, rotateY, rotateX));
                }
            }
        }
        if(answer.isEmpty()) return new int[] {-1};
        Collections.sort(answer);
        int[] result = new int[answer.size()];
        for(int i=0;i<result.length;i++) result[i] = answer.get(i);
        return result;
    }

    private int bfs(int[][] map, Queue<int[]> queue, int[] rotateY, int[] rotateX){
        int answer = 0;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];
            if(map[nowY][nowX]!= -1) answer += map[nowY][nowX];
            else continue;
            // visited 확인
            map[nowY][nowX] = -1;
            // 값 더하기

            for(int i=0;i<4;i++){
                if(nowX + rotateX[i]== -1 || nowX + rotateX[i]==map[0].length ||nowY + rotateY[i]== -1 || nowY + rotateY[i]==map.length) continue;
                if(map[nowY + rotateY[i]][nowX + rotateX[i]] != -1){
                    queue.offer(new int[]{nowY + rotateY[i], nowX + rotateX[i]});
                }
            }
        }
        return answer;
    }
}