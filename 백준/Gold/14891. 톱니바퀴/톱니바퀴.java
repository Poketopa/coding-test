import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] gear = new int[4][8];
        for(int i=0;i<4;i++){
            String str = br.readLine();
            String[] arr = str.split("");
            for(int j=0;j<8;j++){
                gear[i][j] = Integer.parseInt(arr[j]);
            }
        }
        int input = Integer.parseInt(br.readLine());
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNumber = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            // 1: 시계방향
            // 0: 안돌아감
            // -1: 반시계방향
            // 입력받은 톱니에서 왼쪽, 오른쪽으로 계속 이동
            int[] spin = new int[4];
            spin[gearNumber-1] = dir;
            for(int j=gearNumber-1;j<3;j++){
                // 만약 돌아가면?
                if(gear[j][2] != gear[j + 1][6]){
                    spin[j + 1] = spin[j] * -1;
                }
                else break;
            }
            for(int j=gearNumber-1;j>=1;j--){
                if(gear[j][6] != gear[j - 1][2]){
                    spin[j - 1] = spin[j] * -1;
                }
                else break;
            }
            for(int j=0;j<4;j++){
                if(spin[j] == 1){
                    forwardClock(gear[j]);
                } else if(spin[j] == -1){
                    reverseClock(gear[j]);
                }
            }
        }
        // 자~ 렛츠띵킹~~
        // 2번 톱니바퀴가 돌아갔어
        // 그럼? 1, 3번 톱니바퀴 인덱스 2 확인
        // 근데? 함수 갔다오면 값이 변하니까 배열에 잠깐 저장
        int answer = 0;
        if(gear[0][0] == 1) answer += 1;
        if(gear[1][0] == 1) answer += 2;
        if(gear[2][0] == 1) answer += 4;
        if(gear[3][0] == 1) answer += 8;
        System.out.println(answer);
    }
    public static void forwardClock(int[] gear){
        int temp = gear[7];
        for(int i=7;i>=1;i--){
            gear[i] = gear[i-1];
        }
        gear[0] = temp;
    }
    public static void reverseClock(int[] gear){
        int temp = gear[0];
        for(int i=0;i<7;i++){
            gear[i] = gear[i+1];
        }
        gear[7] = temp;
    }
}