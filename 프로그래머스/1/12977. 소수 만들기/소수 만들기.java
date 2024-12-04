import java.util.*;

class Solution {
    static int answer = 0;
    static int length = 3;
    public int solution(int[] nums) {
        int sum = 0;
        int[] visited = new int[nums.length];
        int nowLen = 0;
        dfs(nums, visited, sum, nowLen);

        return answer;
    }

    private static void dfs(int[] nums, int[] visited, int sum, int nowLen){
        for(int i=0;i<nums.length;i++){
            int check = 0;
            for(int k = i+1;k<visited.length;k++){
                if(visited[k]==1){
                    check++;
                    break;
                }
            }
            if(check == 1){
                continue;
            }
            if(nowLen == length){
                int num = 0;
                for(int j=1;j*j<=sum;j++){
                    if(sum%j==0){
                        num++;
                    }
                    if(num>1){
                        break;
                    }
                }
                if(num>1){
                    break;
                }
                answer++;
                break;
            }
            if(visited[i] == 1){
                continue;
            }

            visited[i] = 1;
            dfs(nums, visited, sum+nums[i], nowLen+1);
            visited[i]= 0;
        }

    }
}