import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 1. 해시맵 (이름 - 인덱스)
        // 2. 2차원배열 (y축 신고 하는사람, x축 신고 당하는사람)
        // 3. 1차원배열 (정지 됐는지 확인한다)
        // 이때 2차원 배열에서 x에 대한 y를 긁어와서 k개 이상이면 (1이상인게) 정지
        // 4. 메일 배열
        // 2차원 배열 돌면서 신고한 사람이 정지됐으면 해당 인덱스 메일 + 1
        HashMap<String, Integer> nameIndexMap = new HashMap<>();
        int[][] name = new int[id_list.length][id_list.length];
        int[] ban = new int[id_list.length];
        int[] result = new int[id_list.length];

        // 맵 (이름 - 인덱스) 생성
        for(int i=0;i<id_list.length;i++) nameIndexMap.put(id_list[i], i);

        // 신고 당하면 2차원 배열 +1
        for(int i=0;i<report.length;i++){
            String[] reportTemp = report[i].split(" ");
            name[nameIndexMap.get(reportTemp[0])][nameIndexMap.get(reportTemp[1])] = 1;
        }

        // 2차원 배열 확인하여 k번 이상 신고시 ban 배열 1 할당
        for(int i=0;i<id_list.length;i++){
            int reportCount = 0;
            for(int j=0;j<id_list.length;j++){
                if(name[j][i] > 0) reportCount++;
                if(reportCount == k){
                    ban[i] = 1;
                    break;
                }
            }
        }

        for(int i=0;i<name.length;i++){
            for(int j=0;j<name.length;j++){
                // 이 사람이 누군가를 신고 했다면
                if(name[i][j]>0){
                    // 그 사람이 정지됐는지 확인
                    if(ban[j]== 1){
                        result[i]++;
                    }
                }
            }
        }

        return result;
    }
}