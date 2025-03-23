import java.util.*;
class Solution {
    public int[][] solution(int[][] arr) {
        int column = arr.length;
        int row = arr[0].length;
        int big = Math.max(row, column);
        int[][] answer = new int[big][big];
        if(column >= row){
            for(int i=0;i<column;i++){
                for(int j=0;j<row;j++){
                    answer[i][j] = arr[i][j];
                }
                for(int j=row;j<big;j++){
                    answer[i][j] = 0;
                }
            }
        }
        else{
            for(int i=0;i<column;i++){
                for(int j=0;j<row;j++){
                    answer[i][j] = arr[i][j];
                }
            }
            for(int i=column;i<big;i++){
                Arrays.fill(answer[i], 0);
            }
        }
        return answer;
    }
}