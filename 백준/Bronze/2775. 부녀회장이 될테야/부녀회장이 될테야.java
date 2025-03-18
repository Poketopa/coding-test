

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[][] apt = new int[15][15];
        for(int i=1;i<=15;i++) apt[0][i-1] = i;
        for(int i=1;i<15;i++){
            for(int j=0;j<15;j++){
                if(j == 0) apt[i][0] = 1;
                else apt[i][j] = apt[i][j-1] + apt[i - 1][j];
            }
        }

        for(int i=0;i<input;i++){
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            System.out.println(apt[a][b-1]);
        }

        bw.flush();
        bw.close();
    }
}

