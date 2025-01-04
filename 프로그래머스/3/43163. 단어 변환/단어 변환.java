import java.util.*;

class Solution {
    static int min = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        int[] visited = new int[words.length];

        dfs(begin, target, words, visited, 0);
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private void dfs(String begin, String target, String[] words, int[] visited, int count){
        if(begin.equals(target)){
            min = Math.min(min, count);
            return;
        }

        for(int i=0;i<words.length;i++){
            if(visited[i]==1) continue;
            if(canTransform(begin, words[i])){
                visited[i] = 1;
                dfs(words[i], target, words, visited, count + 1);
                visited[i] = 0;
            }
        }
    }

    private boolean canTransform(String begin, String words){
        int diff = 0;
        for(int i=0;i<begin.length();i++){
            if(begin.charAt(i)!=words.charAt(i)){
                diff++;
            }
            if(diff>1) return false;
        }
        return diff == 1;
    }
}