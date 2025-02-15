

import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        double sqrt = Math.sqrt(input);
        // 나누어 떨어지면
        if(sqrt%1 == 0){
            System.out.println("1");
            return;
        }
        int num = (int)sqrt + 1;
        // 2개로 가능
        for(int i=1;i<=num;i++){
            for(int j=1;j<=num;j++){
                if(Math.pow(i, 2) + Math.pow(j, 2) == input){
                    System.out.println("2");
                    return;
                }
            }
        }
        // 3개로 가능
        for(int i=1;i<=num;i++) {
            for (int j = 1; j <= num; j++) {
                for (int k = 1; k <= num; k++) {
                    if (Math.pow(i, 2) + Math.pow(j, 2) + Math.pow(k, 2) == input) {
                        System.out.println("3");
                        return;
                    }
                }
            }
        }
        System.out.println("4");
    }
}