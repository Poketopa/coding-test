import java.util.*;
import java.math.*;

class Solution {
    static int answer = 0;
    public int solution(String[] user_id, String[] banned_id) {
        // visited 배열로 이루어진 배열 2차원배열 생성
        // 하나씩 비교해서 만약 가능하다면 가능한 인덱스를 1로 바꾼다
        // 결과에서 뒤쪽 인덱스를 비교하면서 같은게 1로 되어있으면 합을 1 내림
        // 합을 모두 곱해서 리턴
        int[][] visited = new int[banned_id.length][user_id.length];

        for(int i=0;i<banned_id.length;i++){
            // 밴 아이디 확인
            user :
            for(int j=0;j<user_id.length;j++){
                // 유저 아이디 확인
                for(int k=0;k<banned_id[i].length();k++){
                    // 길이가 다르면 다음
                    if(banned_id[i].length()!=user_id[j].length()) continue user;
                    // 밴 아이디 이름 확인
                    if(banned_id[i].charAt(k) == '*') continue;
                    else if(banned_id[i].charAt(k) != user_id[j].charAt(k)) continue user;
                }
                // 통과한 경우
                visited[i][j] = 1;
            }
        }

        int[] sum = new int[banned_id.length];
        for(int i=0;i<sum.length;i++){
            int temp = 0;
            for(int j=0;j<visited[i].length;j++){
                if(visited[i][j] == 1) temp++;
            }
            sum[i] = temp + 1;
        }

        Set<Set<Integer>> set = new HashSet<>();
        Set<Integer> tempSet = new HashSet<>();

        int[] visitedIndex = new int[visited[0].length];

        for(int i=0;i<visited[0].length;i++){
            // 0번 인덱스 들어간다
            if(visited[0][i] == 1) dfs(visited, 0 , visitedIndex, set, tempSet, i);
        }


        return set.size();
    }

    private void dfs(int[][] visited, int nowIndex, int[] visitedIndex, Set<Set<Integer>> set, Set<Integer> tempSet, int now2Index){
        // visited 확인
        // 0번 인덱스 visited 1로 할당
        visitedIndex[now2Index] = 1;
        tempSet.add(now2Index);


        // 조건 확인
        if (tempSet.size() == visited.length) {
            set.add(new HashSet<>(tempSet)); // 복사본 추가
            visitedIndex[now2Index] = 0;
            tempSet.remove(now2Index);
            return;
        }
        else{
            if(nowIndex != visited.length-1){
                for(int i=0;i<visited[0].length;i++){
                    if(visited[nowIndex+1][i] == 1 && visitedIndex[i] == 0) dfs(visited, nowIndex+1, visitedIndex, set, tempSet, i);
                }
            }
        }
        visitedIndex[now2Index] = 0;
        tempSet.remove(now2Index);
    }
}