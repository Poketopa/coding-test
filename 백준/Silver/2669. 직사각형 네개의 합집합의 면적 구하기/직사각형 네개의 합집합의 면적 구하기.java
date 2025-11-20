import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isPrime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[][] map = new boolean[100][100];

        int[][] rectangular = new int[4][4];
        for(int i=0;i<4;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++){
                rectangular[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<4;i++){
            for(int j=rectangular[i][0];j<rectangular[i][2];j++){
                for(int k=rectangular[i][1];k<rectangular[i][3];k++){
                    map[j][k] = true;
                }
            }
        }

        int count = 0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(map[i][j]) count++;
            }
        }
        System.out.print(count);
    }
}
