import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int[][] map = new int[input][input];
        List<Integer> students = new ArrayList<>();
        Map<Integer, Set<Integer>> loveMap = new HashMap<>();

        for(int i=0;i<input * input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Set<Integer> set = new HashSet<>();
            int tempStudent = Integer.parseInt(st.nextToken());
            students.add(tempStudent);
            for(int j=0;j<4;j++){
                set.add(Integer.parseInt(st.nextToken()));
            }
            loveMap.put(tempStudent, set);
        }

        int[] y = new int[]{1, -1, 0, 0};
        int[] x = new int[]{0, 0, 1, -1};

        for(int i=0;i<students.size();i++){
            int maxValue = -1;
            int maxY = 0;
            int maxX = 0;
            for(int j=0;j<input;j++){
                for(int k=0;k<input;k++){
                    if(map[j][k] != 0) continue;
                    int tempValue = 0;
                    // 조건 1: 열
                    tempValue += j;
                    // 조건 2: 행
                    tempValue += 100 * k;

                    for(int l=0;l<4;l++) {
                        int newY = j + y[l];
                        int newX = k + x[l];
                        if(0 <= newY && newY < input
                        && 0 <= newX && newX < input){
                            // 조건 3: 비어있는 칸
                            if (map[newY][newX] == 0) {
                                tempValue += 10000;
                            }
                            // 조건 4: 좋아하는 학생이 인접
                            if (loveMap.get(students.get(i)).contains(map[newY][newX])){
                                tempValue += 100000;
                            }
                        }
                    }
                    if(maxValue < tempValue){
                        maxY = j;
                        maxX = k;
                        maxValue = tempValue;
                    }
                }
            }
            map[maxY][maxX] = students.get(i);
        }


        int answer = 0;
        for(int i=0;i<input;i++){
            for(int j=0;j<input;j++){
                int count = 0;
                for(int l=0;l<4;l++){
                    int newY = i + y[l];
                    int newX = j + x[l];
                    if(0 <= newY && newY < input
                            && 0 <= newX && newX < input){
                        if(loveMap.get(map[i][j]).contains(map[newY][newX])){
                            count++;
                        }
                    }
                }
                if(count == 0){
                    answer += 0;
                } else if(count == 1){
                    answer += 1;
                } else if(count == 2){
                    answer += 10;
                } else if(count == 3){
                    answer += 100;
                } else {
                    answer += 1000;
                }
            }
        }
        System.out.print(answer);
    }
}
