import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int[] y = {1, -1, 0, 0};
        int[] x = {0, 0, 1, -1};
        Map<Integer, Integer> areaMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int[][] map = new int[row][column];

        for (int i = 0; i < row; i++) {
            String input = br.readLine();
            for (int j = 0; j < column; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        int area = 2;
        int[][] visited = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (map[i][j] == 0) {
                    int count = 1;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = 1;
                    map[i][j] = area;

                    while (!queue.isEmpty()) {
                        int[] temp = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int newY = temp[0] + y[k];
                            int newX = temp[1] + x[k];
                            if (0 <= newY && newY < row
                                    && 0 <= newX && newX < column
                                    && visited[newY][newX] == 0
                                    && map[newY][newX] == 0) {
                                queue.add(new int[]{newY, newX});
                                visited[newY][newX] = 1;
                                map[newY][newX] = area;
                                count++;
                            }
                        }
                    }
                    areaMap.put(area, count);
                    area++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (map[i][j] == 1) {
                    int sum = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int newY = i + y[k];
                        int newX = j + x[k];
                        if (0 <= newY && newY < row && 0 <= newX && newX < column && map[newY][newX] > 1) {
                            set.add(map[newY][newX]);
                        }
                    }
                    for (int areaId : set) {
                        sum += areaMap.get(areaId);
                    }
                    sb.append(sum % 10);
                } else {
                    sb.append("0");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
    
}
