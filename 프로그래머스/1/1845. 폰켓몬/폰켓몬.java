import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            if(map.get(nums[i]) == 1){
                answer++;
            }
        }
        if(answer> nums.length / 2){
            return nums.length/2;
        }
        else{
            return answer;
        }
    }
}