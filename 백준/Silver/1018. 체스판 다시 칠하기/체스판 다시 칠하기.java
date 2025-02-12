import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int input1 = Integer.valueOf(st1.nextToken());
        int input2 = Integer.valueOf(st1.nextToken());
        int max = -1;
        int maxY = 0;
        int maxX = 0;

        String[] board = new String[input1];
        for(int i=0;i<board.length;i++){
            board[i] = br.readLine();
        }

        for(int i=0;i<board.length-7;i++){
            for(int j=0;j<input2-7;j++){
                int count1 = 0;
                int count2 = 0;
                if(board[i].charAt(j) == 'B'){
                    count1 = check("B", board, i, j);
                    count2 = check("W", board, i, j);
                }
                else{
                    count1 = check("W", board, i, j);
                    count2 = check("B", board, i, j);
                }

                if(Math.max(count1, count2)>max) {
                    max = Math.max(count1, count2);
                    maxY = i;
                    maxX = j;
                }
            }
        }
        System.out.println(64 - max);
    }

    private static int check(String first, String[] board, int column, int row){
        int count = 0;
        for(int i=column;i<column+8;i++){
            for(int j=row;j<row+8;j++){
                if(first.equals(String.valueOf(board[i].charAt(j)))) count++;
                if(first.equals("W")) first = "B";
                else first = "W";
            }
            if(first.equals("W")) first = "B";
            else first = "W";
        }
        return count;
    }
}