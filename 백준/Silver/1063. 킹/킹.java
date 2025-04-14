
import java.io.*;
import java.util.*;

public class Main {
    static int kingY, stoneY, kingX, stoneX;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String startKing = st.nextToken();
        String startStone = st.nextToken();
        // A1이 들어왔을 때 1이 y, A가 x
        kingY = (int)startKing.charAt(1) - '0';
        stoneY = (int)startStone.charAt(1) - '0';
        kingX = CharToNum(startKing.charAt(0));
        stoneX = CharToNum(startStone.charAt(0));
        int N = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            String temp = br.readLine();
            move(temp);
        }
        System.out.print(NumToChar(kingX));
        System.out.println(kingY);
        System.out.print(NumToChar(stoneX));
        System.out.print(stoneY);
    }
    private static void move(String input){
        // 각 케이스마다 돌이 겹친 경우 확인
        // 오른쪽
        if(input.equals("R")){
            if(kingX + 1 == stoneX && kingY == stoneY){
                // 돌 범위 확인
                if(stoneX < 8){
                    kingX++;
                    stoneX++;
                }
            }
            else{
                if(kingX < 8){
                    kingX++;
                }
            }
        }
        // 왼쪽
        else if(input.equals("L")){
            if(kingX == stoneX + 1 && kingY == stoneY){
                // 돌 범위 확인
                if(stoneX > 1){
                    kingX--;
                    stoneX--;
                }
            }
            else{
                if(kingX > 1){
                    kingX--;
                }
            }
        }
        // 한칸 아래
        else if(input.equals("B")){
            if(kingX == stoneX && kingY== stoneY + 1){
                // 돌 범위 확인
                if(stoneY > 1){
                    kingY--;
                    stoneY--;
                }
            }
            else{
                if(kingY > 1){
                    kingY--;
                }
            }
        }
        // 한칸 위
        else if(input.equals("T")){
            if(kingX == stoneX && kingY + 1 == stoneY){
                // 돌 범위 확인
                if(stoneY < 8){
                    kingY++;
                    stoneY++;
                }
            }
            else{
                if(kingY < 8){
                    kingY++;
                }
            }
        }
        // 오른쪽 위 대각선
        else if(input.equals("RT")){
            if(kingX + 1 == stoneX && kingY + 1 == stoneY){
                // 돌 범위 확인
                if(stoneY < 8 && stoneX < 8){
                    kingY++;
                    kingX++;
                    stoneY++;
                    stoneX++;
                }
            }
            else{
                if(kingY < 8 && kingX < 8){
                    kingY++;
                    kingX++;
                }
            }
        }
        // 왼쪽 위 대각선
        else if(input.equals("LT")){
            if(kingX == stoneX + 1 && kingY + 1 == stoneY){
                // 돌 범위 확인
                if(stoneY < 8 && stoneX > 1){
                    kingY++;
                    kingX--;
                    stoneY++;
                    stoneX--;
                }
            }
            else{
                if(kingY < 8 && kingX > 1){
                    kingY++;
                    kingX--;
                }
            }
        }
        // 오른쪽 아래 대각선
        else if(input.equals("RB")){
            if(kingX +1  == stoneX && kingY == stoneY + 1){
                // 돌 범위 확인
                if(stoneY > 1 && stoneX < 8){
                    kingY--;
                    kingX++;
                    stoneY--;
                    stoneX++;
                }
            }
            else{
                if(kingY > 1 && kingX < 8){
                    kingY--;
                    kingX++;
                }
            }
        }
        // 왼쪽 아래 대각선
        else if(input.equals("LB")){
            if(kingX == stoneX + 1 && kingY == stoneY + 1){
                // 돌 범위 확인
                if(stoneY > 1 && stoneX > 1){
                    kingY--;
                    kingX--;
                    stoneY--;
                    stoneX--;
                }
            }
            else{
                if(kingY > 1 && kingX > 1){
                    kingY--;
                    kingX--;
                }
            }
        }
    }
    private static int CharToNum(char input){
        int result = (int) (input - 'A' + 1);
        return result;
    }
    private static char NumToChar(int input){
        char result = (char) ('A' + input - 1);
        return result;
    }
}