import java.util.*;

class Solution {
    static int answer = 0;
    static HashMap<Integer, Boolean> map = new HashMap<>();
    public int solution(String numbers) {
        String[] number = numbers.split("");
        int[] visited = new int[number.length];
        String result = "";
        for(int length = 1;length<=number.length;length++){
            dfs(number, visited, length, result);
        }
        return answer;
    }

    private static void dfs(String[] number, int[] visited, int length, String result){
        if(result.length()==length){
            test(result);
            return;
        }
        for(int i=0;i<number.length;i++){
            if(visited[i] == 1) continue;
            visited[i] = 1;
            dfs(number, visited, length, result+number[i]);
            visited[i] = 0;
        }
    }

    private static void test(String result){
        int number = Integer.valueOf(result);
        if(map.getOrDefault(number, false)){
            return;
        }
        int count = 0;
        for(int i=1;i<=number;i++){
            if(number%i==0) count++;
            if(count>2) break;
        }
        if(count==2){
            answer++;
            map.put(number, true);
        }
    }
}

