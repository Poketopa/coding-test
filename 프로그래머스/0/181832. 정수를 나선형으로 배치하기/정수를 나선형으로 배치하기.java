import java.util.*;

class Solution {
    public int[][] solution(int n) {
        int[][] visited = new int[n][n];
        int[][] answer = new int[n][n];
        int indexY = 0;
        int indexX = 0;
        int count = 1;
        if(n == 1) return new int[][] {{1}};

        x:
        while(true){

            while(true){
                if(visited[indexY][indexX] == 1) break x;
                answer[indexY][indexX] = count;
                visited[indexY][indexX] = 1;
                count++;
                if(indexX + 1 == answer[0].length || visited[indexY][indexX+1] == 1){
                    indexY++;
                    break;
                }
                else indexX++;
            }
            while(true){
                if(visited[indexY][indexX] == 1) break x;
                answer[indexY][indexX] = count;
                visited[indexY][indexX] = 1;
                count++;
                if(indexY + 1 == answer.length || visited[indexY+1][indexX] == 1){
                    indexX--;
                    break;
                }
                else indexY++;
            }
            while(true){
                if(visited[indexY][indexX] == 1) break x;
                answer[indexY][indexX] = count;
                visited[indexY][indexX] = 1;
                count++;
                if(indexX == 0 || visited[indexY][indexX - 1] == 1){
                    indexY--;
                    break;
                }
                else indexX--;
            }
            while(true){
                if(visited[indexY][indexX] == 1) break x;
                answer[indexY][indexX] = count;
                visited[indexY][indexX] = 1;
                count++;
                if(indexY == 0 || visited[indexY- 1][indexX] == 1){
                    indexX++;
                    break;
                }
                else indexY--;
            }
        }
        return answer;
    }
}