import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class Main {
    static String[][] map;
    static int input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        input = Integer.parseInt(br.readLine());
        map = new String[input][input];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<input;i++){
            String[] temp = br.readLine().split("");
            for(int j=0;j<input;j++){
                map[i][j] = temp[j];
            }
        }
        for(int i=0;i<input;i++){
            for(int j=0;j<input;j++){
                max = Math.max(max, Math.max(checkDown(i, j), checkRight(i, j)));
            }
        }
        System.out.print(max);
    }

    public static int checkDown(int i, int j){
        if(i == input - 1) return Integer.MIN_VALUE;
        changeDown(i, j);
        int max = checkLongest();
        changeDown(i, j);
        return max;
    }

    public static int checkRight(int i, int j){
        if(j == input - 1) return Integer.MIN_VALUE;
        changeRight(i, j);
        int max = checkLongest();
        changeRight(i, j);
        return max;
    }

    public static int checkLongest(){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<input;i++){
            int temp = 1;
            for(int j=0;j<input-1;j++){
                if(map[i][j].equals(map[i][j+1])) temp++;
                else temp = 1;
                max = Math.max(max, temp);
            }
        }
        for(int j=0;j<input;j++){
            int temp = 1;
            for(int i=0;i<input-1;i++){
                if(map[i][j].equals(map[i+1][j])) temp++;
                else temp = 1;
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    public static void changeDown(int i, int j){
        String temp = map[i][j];
        map[i][j] = map[i+1][j];
        map[i+1][j] = temp;
    }

    public static void changeRight(int i, int j){
        String temp = map[i][j];
        map[i][j] = map[i][j+1];
        map[i][j+1] = temp;
    }
}






