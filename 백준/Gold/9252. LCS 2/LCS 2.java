
import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String a = br.readLine();
        String b = br.readLine();
        int[][] arr = new int[a.length()+1][b.length()+1];
        for(int i=1;i<=a.length();i++){
            for(int j=1;j<=b.length();j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1] + 1;
                }
                else arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
            }
        }
        bw.write(arr[a.length()][b.length()] + "\n");
        List<Character> list = new ArrayList<>();

        int y = a.length();
        int x = b.length();

        while(true){
            if(y > 0 && arr[y][x] == arr[y-1][x]) y--;
            else if(x > 0 && arr[y][x] == arr[y][x-1]) x--;
            else{
                list.add(a.charAt(y-1));
                y--;
                x--;

            }
            if(y == 0 || x == 0) break;
        }
        for(int i=list.size()-1;i>=0;i--){
            bw.write(list.get(i));
        }

        bw.flush();
        bw.close();
    }
}
