
import java.io.*;
import java.util.*;

public class Main {
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] array = new int[str1.length()+1][str2.length()+1];

        for(int i=1;i<array.length;i++){
            for(int j=1;j<array[0].length;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    array[i][j] = array[i-1][j-1] + 1;
                }
                else array[i][j] = Math.max(array[i][j-1], array[i-1][j]);
                answer = Math.max(array[i][j], answer);
            }
        }
        System.out.println(answer);
    }
}
