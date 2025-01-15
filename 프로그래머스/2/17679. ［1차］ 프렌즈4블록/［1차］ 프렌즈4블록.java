import java.util.*;

class Solution {
    static int answer = 0;
    static int flag = 0;
    public int solution(int m, int n, String[] board) {
        // 맵 만들기
        char[][] map = new char[board.length][board[0].length()];
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                map[i][j] = board[i].charAt(j);
            }
        }
        Queue<int[]> queue = new LinkedList<>();

        while(flag == 0){
            flag = 1;
            // 2x2 확인
            check(map, queue);
            // 없어질 블록 갯수 세기
            countFriends(map, queue);
            // 아래로 끌어내리기
            down(map);
        }
        return answer;
    }

    private void check(char[][] map, Queue<int[]> queue){
        for(int i=0;i<map.length-1;i++){
            for(int j=0;j<map[0].length-1;j++){
                if(map[i][j] == '-') continue;
                if(map[i][j] == map[i][j+1]
                &&map[i][j] == map[i+1][j]
                &&map[i][j] == map[i+1][j+1]){
                    queue.add(new int[]{i, j});
                    flag = 0;
                }
            }
        }
    }

    private void countFriends(char[][] map, Queue<int[]> queue){
        while(!queue.isEmpty()){
            int[] index = queue.poll();
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    // 이미 셌으면
                    if(map[i+index[0]][j+index[1]] == '-'){
                        continue;
                    }
                    else{
                        map[i+index[0]][j+index[1]] = '-';
                        answer++;
                    }
                }
            }
        }

    }

    private void down(char[][] map){
        for(int i=map.length-2;i>=0;i--){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j] != '-' && map[i+1][j] == '-'){
                   int y = i + 1;
                   int x = j;
                   while(y != map.length && map[y][x] == '-'){
                       y++;
                   }
                   map[y - 1][x] = map[i][j];
                   map[i][j] = '-';
                }
            }
        }
    }
}