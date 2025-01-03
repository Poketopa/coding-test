import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        List<Integer> list = new ArrayList<>();
        int answer = 0;
        int flag = 0;
        for(int i=0;i<moves.length;i++){
            flag = 0;
            int index = 0;
            while(board[index][moves[i]-1] == 0){
                index++;
                if(index == board.length) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 1) continue;

            list.add(board[index][moves[i]-1]);
            board[index][moves[i]-1] = 0;

            while(list.size()>1&&list.get(list.size()-1)==list.get(list.size()-2)) {
                answer += 2;
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
            }
        }
        return answer;
    }
}