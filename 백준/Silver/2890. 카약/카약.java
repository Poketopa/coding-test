import java.io.*;
import java.util.*;

public class Main {
    static boolean[] even = new boolean[1000001];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        String[][] map = new String[row][column];

        for(int i=0;i<row;i++){
            String input = br.readLine();
            map[i] = input.split("");
        }

        Map<Integer, Integer> mapping = new HashMap<>();

        for(int i=0;i<row;i++){
            x:
            for(int j=0;j<column;j++){
                if('0' < map[i][j].charAt(0) && map[i][j].charAt(0) <= '9'){
                    int number = Integer.parseInt(map[i][j]);
                    int count = 0;
                    int startIndex = j + 3;
                    while(map[i][startIndex].equals(".")){
                        count++;
                        startIndex++;
                    }
                    mapping.put(number, count);
                    break x;
                }
            }
        }
        Map<Integer, Integer> rank = new HashMap<>();
        int rankCount = 0;
        int ranking = 1;
        for(int j=1;j<=column;j++){
            boolean flag = false;
            for(int i=1;i<=9;i++){
                if(mapping.get(i) == rankCount){
                    flag = true;
                    rank.put(i, ranking);
                }
            }
            if(flag){
                ranking++;
            }
            rankCount++;
        }
        for(int i=1;i<=9;i++){
                System.out.println(rank.get(i));
        }
    }
}
