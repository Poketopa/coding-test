
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[][] student = new int[input][5];
        int[] score = new int[input];
        int[] grade = new int[5];
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                student[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = -1;
        int maxIndex = -1;
        for(int k=0;k<input;k++){
            int temp = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0;i<5;i++){
                for(int j=0;j<input;j++){
                    if(k != j && student[k][i] == student[j][i]) {
                        map.put(j, 1);
                    }
                }
            }
            for(int i=0;i<input;i++){
                if(map.containsKey(i)) temp++;
            }
            if(temp > max){
                max = temp;
                maxIndex = k + 1;
            }
        }
        System.out.println(maxIndex);

    }
}