import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] sum = new int[board.length+1][board[0].length+1];
        // board : 시작체력 (2차원배열)
        // skill : [type, r1, c1, r2, c2, degree]
        // type - 1이면 공격 (-) 2이면 힐 (+)
        // r1, c1 - 왼쪽 위 좌표
        // r2, c2 - 오른쪽 아래 좌표
        for(int i=0;i<skill.length;i++){
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            // 공격
            if(type == 1){
                sum[r1][c1] -= degree;
                sum[r2+1][c1] += degree;
                sum[r1][c2+1] += degree;
                sum[r2+1][c2+1] -= degree;
            }
            // 회복
            else{
                sum[r1][c1] += degree;
                sum[r2+1][c1] -= degree;
                sum[r1][c2+1] -= degree;
                sum[r2+1][c2+1] += degree;
            }
        }

        // 누적합 만들기
        for(int i=0;i<sum.length;i++){
            for(int j=0;j<sum[0].length-1;j++){
                sum[i][j+1] += sum[i][j];
            }
        }
        for(int i=0;i<sum[0].length;i++){
            for(int j=0;j<sum.length-1;j++){
                sum[j+1][i] += sum[j][i];
            }
        }

        int count = 0;
        // 두 배열 더하기
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j] += sum[i][j];
                if(board[i][j] >0) count++;
            }
        }
        return count;
    }
}