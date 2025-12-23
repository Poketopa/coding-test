import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static int y;
    static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int[][] map = new int[input][input];
        int[][] visited = new int[input][input];
        for (int i = 0; i < input; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < input; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int direction = 0;
        y = (input / 2);
        x = (input / 2);
        visited[y][x] = 1;
        while (true) {
            if (direction == 0) { // 왼쪽으로~
                left(map, visited);
                if ((y == input - 1 || visited[y + 1][x] == 0) && (y == 0 || visited[y - 1][x] == 0)) {
                    direction++;
                }
            } else if (direction == 1) {
                down(map, visited);
                if ((x == input - 1 || visited[y][x + 1] == 0) && (x == 0 || visited[y][x - 1] == 0)) {
                    direction++;
                }
            } else if (direction == 2) {
                right(map, visited);
                if ((y == input - 1 || visited[y + 1][x] == 0) && (y == 0 || visited[y - 1][x] == 0)) {
                    direction++;
                }
            } else {
                up(map, visited);
                if ((x == input - 1 || visited[y][x + 1] == 0) && (x == 0 || visited[y][x - 1] == 0)) {
                    direction++;
                }
            }
            direction %= 4;
            if (y == 0 && x == 0) {
                break;
            }
        }
        System.out.print(answer);
    }

    public static void down(int[][] map, int[][] visited) {
        y++;
        visited[y][x] = 1;
        int sand = map[y][x];
        int newSand = sand;
        try {
            map[y][x + 1] += (int) ((double) sand * (0.07));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.07));
        }
        try {
            map[y][x - 1] += (int) ((double) sand * (0.07));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.07));
        }

        try {
            map[y][x + 2] += (int) ((double) sand * (0.02));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.02));
        }
        try {
            map[y][x - 2] += (int) ((double) sand * (0.02));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.02));
        }
        try {
            map[y - 1][x + 1] += (int) ((double) sand * (0.01));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.01));
        }
        try {
            map[y - 1][x - 1] += (int) ((double) sand * (0.01));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.01));
        }
        try {
            map[y + 1][x + 1] += (int) ((double) sand * (0.1));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.1));
        }
        try {
            map[y + 1][x - 1] += (int) ((double) sand * (0.1));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.1));
        }
        try {
            map[y + 2][x] += (int) ((double) sand * (0.05));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.05));
        }
        newSand -= ((int) ((double) sand * (0.07)) + (int) ((double) sand * (0.07))
                + (int) ((double) sand * (0.02)) + (int) ((double) sand * (0.02))
                + (int) ((double) sand * (0.01)) + (int) ((double) sand * (0.01))
                + (int) ((double) sand * (0.1)) + (int) ((double) sand * (0.1))
                + (int) ((double) sand * (0.05)));
        try {
            map[y + 1][x] += newSand;
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += newSand;
        }
        map[y][x] = 0;
    }

    public static void right(int[][] map, int[][] visited) {
        x++;
        visited[y][x] = 1;
        int sand = map[y][x];
        int newSand = sand;
        try {
            map[y + 1][x] += (int) ((double) sand * (0.07));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.07));
        }
        try {
            map[y - 1][x] += (int) ((double) sand * (0.07));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.07));
        }
        try {
            map[y - 2][x] += (int) ((double) sand * (0.02));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.02));
        }
        try {
            map[y + 2][x] += (int) ((double) sand * (0.02));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.02));
        }
        try {
            map[y + 1][x - 1] += (int) ((double) sand * (0.01));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.01));
        }
        try {
            map[y - 1][x - 1] += (int) ((double) sand * (0.01));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.01));
        }
        try {
            map[y + 1][x + 1] += (int) ((double) sand * (0.1));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.1));
        }
        try {
            map[y - 1][x + 1] += (int) ((double) sand * (0.1));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.1));
        }
        try {
            map[y][x + 2] += (int) ((double) sand * (0.05));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.05));
        }
        newSand -= ((int) ((double) sand * (0.07)) + (int) ((double) sand * (0.07))
                + (int) ((double) sand * (0.02)) + (int) ((double) sand * (0.02))
                + (int) ((double) sand * (0.01)) + (int) ((double) sand * (0.01))
                + (int) ((double) sand * (0.1)) + (int) ((double) sand * (0.1))
                + (int) ((double) sand * (0.05)));
        try {
            map[y][x + 1] += newSand;
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += newSand;
        }
        map[y][x] = 0;
    }

    public static void up(int[][] map, int[][] visited) {
        y--;
        visited[y][x] = 1;
        int sand = map[y][x];
        int newSand = sand;
        try {
            map[y][x + 1] += (int) ((double) sand * (0.07));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.07));
        }
        try {
            map[y][x - 1] += (int) ((double) sand * (0.07));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.07));
        }
        try {
            map[y][x + 2] += (int) ((double) sand * (0.02));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.02));
        }
        try {
            map[y][x - 2] += (int) ((double) sand * (0.02));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.02));
        }
        try {
            map[y + 1][x + 1] += (int) ((double) sand * (0.01));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.01));
        }
        try {
            map[y + 1][x - 1] += (int) ((double) sand * (0.01));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.01));
        }
        try {
            map[y - 1][x + 1] += (int) ((double) sand * (0.1));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.1));
        }
        try {
            map[y - 1][x - 1] += (int) ((double) sand * (0.1));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.1));
        }
        try {
            map[y - 2][x] += (int) ((double) sand * (0.05));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.05));
        }
        newSand -= ((int) ((double) sand * (0.07)) + (int) ((double) sand * (0.07))
                + (int) ((double) sand * (0.02)) + (int) ((double) sand * (0.02))
                + (int) ((double) sand * (0.01)) + (int) ((double) sand * (0.01))
                + (int) ((double) sand * (0.1)) + (int) ((double) sand * (0.1))
                + (int) ((double) sand * (0.05)));
        try {
            map[y - 1][x] += newSand;
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += newSand;
        }
        map[y][x] = 0;
    }

    public static void left(int[][] map, int[][] visited) {
        x--;
        visited[y][x] = 1;
        int sand = map[y][x];
        int newSand = sand;
        try {
            map[y + 1][x] += (int) ((double) sand * (0.07));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.07));
        }
        try {
            map[y - 1][x] += (int) ((double) sand * (0.07));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.07));
        }
        try {
            map[y - 2][x] += (int) ((double) sand * (0.02));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.02));
        }
        try {
            map[y + 2][x] += (int) ((double) sand * (0.02));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.02));
        }
        try {
            map[y + 1][x + 1] += (int) ((double) sand * (0.01));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.01));
        }
        try {
            map[y - 1][x + 1] += (int) ((double) sand * (0.01));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.01));
        }
        try {
            map[y + 1][x - 1] += (int) ((double) sand * (0.1));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.1));
        }
        try {
            map[y - 1][x - 1] += (int) ((double) sand * (0.1));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.1));
        }
        try {
            map[y][x - 2] += (int) ((double) sand * (0.05));
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += (int) ((double) sand * (0.05));
        }
        newSand -= ((int) ((double) sand * (0.07)) + (int) ((double) sand * (0.07))
                + (int) ((double) sand * (0.02)) + (int) ((double) sand * (0.02))
                + (int) ((double) sand * (0.01)) + (int) ((double) sand * (0.01))
                + (int) ((double) sand * (0.1)) + (int) ((double) sand * (0.1))
                + (int) ((double) sand * (0.05)));
        try {
            map[y][x - 1] += newSand;
        } catch (ArrayIndexOutOfBoundsException e) {
            answer += newSand;
        }
        map[y][x] = 0;
    }
}
