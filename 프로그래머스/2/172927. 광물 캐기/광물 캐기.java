import java.util.*;

class Solution {
    static int answer = 0;
    public int solution(int[] picks, String[] minerals) {
        int diamond = picks[0];
        int iron = picks[1];
        int stone = picks[2];
        // 5개씩 묶어서 나온 결과를 배열에 넣는다
        // 1. sum 배열, 2. index 배열
        // sum 배열의 내림차순으로 index배열을 정렬한다
        // index 배열 * 5 를 탐색하면서 가장 높은 등급 곡괭이를 사용하며 피로도를 더한다


        int length = Math.min((diamond + iron + stone) * 5, minerals.length);
        String[] newMinerals = new String[length];
        for (int i = 0; i < length; i++) {
            newMinerals[i] = minerals[i];
        }

        int[] sum = new int[(newMinerals.length+4)/5];
        Integer[] index = new Integer[sum.length];

        // index 배열 초기화
        for(int i=0;i<index.length;i++) index[i] = i;

        // 광물 등급에 따라 sum 배열 만들기
        for(int i=0;i<newMinerals.length;i++){
            if(newMinerals[i].equals("diamond")) sum[i/5] += 25;
            else if(newMinerals[i].equals("iron")) sum[i/5] += 5;
            else sum[i/5] += 1;
        }

        Arrays.sort(index, (a, b)->{
            if(sum[(int)a]<sum[(int)b]) return 1;
            else if(sum[(int) a]>sum[(int)b]) return -1;
            else return 0;
        });

        for(int i=0;i<index.length;i++){
            if(diamond==0&&iron==0&&stone==0) break;
            if(diamond>0) {
                mining(0, index[i] * 5, newMinerals);
                diamond--;
            }
            else if(iron>0) {
                mining(1, index[i]*5, newMinerals);
                iron--;
            }
            else {
                mining(2, index[i]*5, newMinerals);
                stone--;
            }
        }

        return answer;
    }

    private void mining(int pick, int start, String[] minerals){
        for(int i=0;i<5;i++){
            // 범위 넘으면 그만
            if(i+start==minerals.length) return;
            // 다이아
            if(pick == 0){
                if(minerals[start+i].equals("diamond")) answer += 1;
                else if(minerals[start+i].equals("iron")) answer += 1;
                else answer+=1;
            }
            // 철
            else if(pick == 1){
                if(minerals[start+i].equals("diamond")) answer += 5;
                else if(minerals[start+i].equals("iron")) answer += 1;
                else answer+=1;
            }
            // 돌
            else{
                if(minerals[start+i].equals("diamond")) answer += 25;
                else if(minerals[start+i].equals("iron")) answer += 5;
                else answer+=1;
            }
        }
    }
}