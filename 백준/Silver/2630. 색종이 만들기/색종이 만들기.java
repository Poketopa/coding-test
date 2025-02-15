
import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[][] map = new int[input][input];
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<input;j++){
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        // 심규원 토익 화이팅
        int blue = 0;
        int white = 0;
        int length = input;
        while(true){
            for(int i=0;i<input;i+=length){
                x :
                for(int j=0;j<input;j+=length){
                    // 모든 구간 보면서 모두 같은 색종이인지 확인하다
                    // 초록색인지 하얀색인지 확인
                    if(map[i][j] == 1){
                        // 파랑색이면
                        for(int k=i;k<i+length;k++){
                            for(int l=j;l<j+length;l++){
                                if(map[k][l] == 0) continue x;
                            }
                        }
                        blue++;
                        // 덮기
                        for(int k=i;k<i+length;k++){
                            for(int l=j;l<j+length;l++){
                                map[k][l] = -1;
                            }
                        }
                    }
                    else if(map[i][j] == 0){
                        // 하얀색이면
                        for(int k=i;k<i+length;k++){
                            for(int l=j;l<j+length;l++){
                                if(map[k][l] == 1) continue x;
                            }
                        }
                        white++;
                        // 덮기
                        for(int k=i;k<i+length;k++){
                            for(int l=j;l<j+length;l++){
                                map[k][l] = -1;
                            }
                        }
                    }
                    else continue;
                }
            }
            if(length == 1) break;
            length /= 2;
        }
        System.out.println(white);
        System.out.println(blue);
    }
}