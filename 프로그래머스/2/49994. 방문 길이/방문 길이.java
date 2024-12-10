import java.util.*;

// 띵킹띵킹
// 출발, 도착이 달라도 선이 같으면 이미 지나간 길
// 만약 y값이 같을 때, x값 기준 정렬, x같이 같으면 y값 기준 정렬
class Solution {
    public int solution(String dirs) {
        HashMap<String, int[]> map = new HashMap<>();
        // 0인덱스 위로
        // 1인덱스 오른쪽으로
        // 각 좌표 리스트 만들어놓기
        for(int i=-5;i<=5;i++){
            for(int j=-5;j<=5;j++){
                String temp = "";
                temp+=String.valueOf(i);
                temp+=String.valueOf(j);
                map.put(temp, new int[2]);
            }
        }
        String[] move = dirs.split("");
        int[] index = {0,0};
        for(String i : move){
            if(i.equals("U")&&index[1]<5){
                String temp = "";
                temp+=String.valueOf(index[0]);
                temp+=String.valueOf(index[1]);
                map.get(temp)[0]++;

                // 인덱스 증가
                index[1]++;
                continue;
            }
            else if(i.equals("D")&&index[1]>-5){
                String temp = "";
                temp+=String.valueOf(index[0]);
                temp+=String.valueOf(index[1]-1);
                map.get(temp)[0]++;

                // 인덱스 증가
                index[1]--;
                continue;
            }
            else if(i.equals("R")&&index[0]<5){
                String temp = "";
                temp+=String.valueOf(index[0]);
                temp+=String.valueOf(index[1]);
                map.get(temp)[1]++;

                // 인덱스 증가
                index[0]++;
                continue;
            }
            else if(i.equals("L")&&index[0]>-5){
                String temp = "";
                temp+=String.valueOf(index[0]-1);
                temp+=String.valueOf(index[1]);
                map.get(temp)[1]++;

                // 인덱스 증가
                index[0]--;
                continue;
            }
        }
        int answer = 0;
        for(int i= -5;i<=5;i++){
            for(int j=-5;j<=5;j++){
                String temp = "";
                temp+=String.valueOf(i);
                temp+=String.valueOf(j);
                for(int k=0;k<2;k++){
                    if(map.get(temp)[k]>0){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}