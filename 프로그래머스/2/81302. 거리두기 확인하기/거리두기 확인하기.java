import java.util.*;

class Solution {
    static int[] y = new int[]{1, -1, 0, 0};
    static int[] x = new int[]{0, 0, 1, -1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        x: for(int ts = 0;ts < places.length; ts++){
            char[][] map = new char[5][5];
            for(int i=0;i<5;i++){
                String temp = places[ts][i];
                for(int j=0;j<5;j++){
                    map[i][j] = temp.charAt(j);
                }
            }
            Queue<int[]> queue = new LinkedList<>();
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    if(map[i][j] == 'P'){
                        int[][] visited = new int[5][5];
                        queue.add(new int[]{i, j, 0});
                        visited[i][j] = 1;
                        while(!queue.isEmpty()){
                            int[] temp = queue.poll();
                            if(temp[2] == 2){
                                continue;
                            }
                            for(int k=0;k<4;k++){
                                int newY = temp[0] + y[k];
                                int newX = temp[1] + x[k];
                                if(0 <= newY && newY < 5
                                && 0 <= newX && newX < 5
                                && visited[newY][newX] == 0
                                && map[newY][newX] != 'X'){
                                    if(map[newY][newX] == 'P'){
                                        answer[ts] = 0;
                                        continue x;
                                    }
                                    queue.add(new int[]{newY, newX, temp[2] + 1});
                                }
                            }
                        }
                        
                    }
                }
            }
            answer[ts] = 1;
        }
        return answer;
    }
}