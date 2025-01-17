import java.util.*;

class Solution {
    public int solution(int [][]board) {
        // length 설정
        int length = 0;
        if(board.length>board[0].length) length = board[0].length;
        else length = board.length;

        for(int i=1;i<board.length;i++)board[i][0] += board[i-1][0];
        for(int i=1;i<board[0].length;i++)board[0][i] += board[0][i-1];
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                board[i][j] += board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1];
            }
        }

        if(board[board.length-1][board[0].length-1] == 0) return 0;

        // length 마다 돌면서 확인한다
        while(length != 0){
            x:
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    // 크기 괜찮으면
                    if(i+length <= board.length && j+length <= board[0].length){
                        if(board[i+length-1][j+length-1] < length * length) continue;
                        // 외곽선 존재하면
                        if(i==0 && j==0){
                            if(board[i+length-1][j+length-1] == length*length){
                                return length * length;
                            }
                        }
                        else if(i==0){
                            if(board[i+length-1][j+length-1] - board[i+length-1][j-1] == length*length){
                                return length * length;
                            }
                        }
                        else if(j==0){
                            if(board[i+length-1][j+length-1] - board[i-1][j+length-1] == length*length){
                                return length * length;
                            }
                        }
                        else{
                            if(board[i+length-1][j+length-1] - board[i-1][j+length-1] - board[i+length-1][j-1] + board[i-1][j-1] == length*length){
                                return length * length;
                            }
                        }

                    }
                    else continue x;
                }
            }
            length--;
            if(length == 1)return 1;
        }
        return 0;
    }
}