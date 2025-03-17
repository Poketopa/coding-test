

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[][]  map = new int[input][3];
        for(int i=0;i<input;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;
        int[][] clone = new int[input][3];
        clone[0][0] = map[0][0];
        clone[0][1] = Integer.MAX_VALUE;
        clone[0][2] = Integer.MAX_VALUE;
        for(int i=1;i<input;i++){
            for(int j=0;j<3;j++) clone[i][j] = map[i][j];
        }

        for(int i=1;i<input;i++){
            if(clone[i-1][1] != Integer.MAX_VALUE || clone[i-1][2] != Integer.MAX_VALUE){
                clone[i][0] += Math.min(clone[i-1][1], clone[i-1][2]);
            }
            else clone[i][0] = Integer.MAX_VALUE;
            if(clone[i-1][0] != Integer.MAX_VALUE || clone[i-1][2] != Integer.MAX_VALUE){
                clone[i][1] += Math.min(clone[i-1][0], clone[i-1][2]);
            }
            else clone[i][1] = Integer.MAX_VALUE;
            if(clone[i-1][1] != Integer.MAX_VALUE || clone[i-1][0] != Integer.MAX_VALUE){
                clone[i][2] += Math.min(clone[i-1][1], clone[i-1][0]);
            }
            else clone[i][2] = Integer.MAX_VALUE;
        }
        min = Math.min(min, Math.min(clone[input-1][1], clone[input-1][2]));

        clone[0][1] = map[0][1];
        clone[0][0] = Integer.MAX_VALUE;
        for(int i=1;i<input;i++){
            for(int j=0;j<3;j++) clone[i][j] = map[i][j];
        }

        for(int i=1;i<input;i++){
            if(clone[i-1][1] != Integer.MAX_VALUE || clone[i-1][2] != Integer.MAX_VALUE){
                clone[i][0] += Math.min(clone[i-1][1], clone[i-1][2]);
            }
            else clone[i][0] = Integer.MAX_VALUE;
            if(clone[i-1][0] != Integer.MAX_VALUE || clone[i-1][2] != Integer.MAX_VALUE){
                clone[i][1] += Math.min(clone[i-1][0], clone[i-1][2]);
            }
            else clone[i][1] = Integer.MAX_VALUE;
            if(clone[i-1][1] != Integer.MAX_VALUE || clone[i-1][0] != Integer.MAX_VALUE){
                clone[i][2] += Math.min(clone[i-1][1], clone[i-1][0]);
            }
            else clone[i][2] = Integer.MAX_VALUE;
        }
        min = Math.min(min, Math.min(clone[input-1][0], clone[input-1][2]));

        clone[0][2] = map[0][2];
        clone[0][1] = Integer.MAX_VALUE;
        clone[0][0] = Integer.MAX_VALUE;
        for(int i=1;i<input;i++){
            for(int j=0;j<3;j++) clone[i][j] = map[i][j];
        }

        for(int i=1;i<input;i++){
            if(clone[i-1][1] != Integer.MAX_VALUE || clone[i-1][2] != Integer.MAX_VALUE){
                clone[i][0] += Math.min(clone[i-1][1], clone[i-1][2]);
            }
            else clone[i][0] = Integer.MAX_VALUE;
            if(clone[i-1][0] != Integer.MAX_VALUE || clone[i-1][2] != Integer.MAX_VALUE){
                clone[i][1] += Math.min(clone[i-1][0], clone[i-1][2]);
            }
            else clone[i][1] = Integer.MAX_VALUE;
            if(clone[i-1][1] != Integer.MAX_VALUE || clone[i-1][0] != Integer.MAX_VALUE){
                clone[i][2] += Math.min(clone[i-1][1], clone[i-1][0]);
            }
            else clone[i][2] = Integer.MAX_VALUE;
        }
        min = Math.min(min, Math.min(clone[input-1][0], clone[input-1][1]));

        System.out.println(min);
    }
}
