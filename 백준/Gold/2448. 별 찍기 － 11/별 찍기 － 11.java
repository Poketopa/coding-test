
import java.io.*;
import java.util.*;

public class Main {
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        String[][] map = new String[input][2 * input - 1];

        for (int i = 0; i < map.length; i++) Arrays.fill(map[i], " ");
        
        star(input, 0, input - 1, map);

        // BufferedWriter를 이용하여 출력
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                bw.write(map[i][j]);
            }
            bw.newLine(); // 줄 바꿈
        }
        
        bw.flush(); // 버퍼 비우기
        bw.close(); // BufferedWriter 닫기
    }

    private static void star(int length, int y, int x, String[][] map) {
        if (length == 3) {
            map[y][x] = "*";
            map[y + 1][x - 1] = "*";
            map[y + 1][x + 1] = "*";
            map[y + 2][x - 2] = "*";
            map[y + 2][x - 1] = "*";
            map[y + 2][x] = "*";
            map[y + 2][x + 1] = "*";
            map[y + 2][x + 2] = "*";
            return;
        }

        int half = length / 2;
        star(half, y, x, map);
        star(half, y + half, x - half, map);
        star(half, y + half, x + half, map);
    }
}
