class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};
        int min = Integer.MAX_VALUE;
        for(int i : arr) if(min > i) min = i;
        int[] answer = new int[arr.length-1];
        int idx = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == min) continue;
            answer[idx] = arr[i];
            idx++;
        }
        return answer;
    }
}