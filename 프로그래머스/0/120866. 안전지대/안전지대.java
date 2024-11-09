import java.util.*;
class Solution {
    public int solution(int[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]==1){
                    for(int x=-1;x<2;x++){
                        for(int y=-1;y<2;y++){
                            if(i+x==-1||i+x==board.length||j+y==-1||j+y==board.length){
                                continue;
                            }
                            else{
                                if(board[i+x][j+y] == 0){
                                    board[i+x][j+y]=2;
                                }

                            }

                        }
                    }
                }
            }
        }
        int count=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
}