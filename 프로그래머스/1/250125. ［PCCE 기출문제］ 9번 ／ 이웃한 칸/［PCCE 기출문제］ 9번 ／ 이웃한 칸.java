import java.util.*;

class Solution {
    public int solution(String[][] board, int h, int w) {
        // h, w의 값 확인하고 나머지 방향 확인한다
        int count = 0;
        String color = board[h][w];
        // 윗칸 확인
        if(h>0){
            if(board[h-1][w].equals(color)) count++;
        }
        if(h<board.length-1){
            if(board[h+1][w].equals(color)) count++;
        }

        if(w>0){
            if(board[h][w-1].equals(color)) count++;
        }
        if(w<board.length-1){
            if(board[h][w+1].equals(color)) count++;
        }
        return count;
    }
}