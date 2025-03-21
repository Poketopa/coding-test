class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        int count = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<delete_list.length;j++){
                if(arr[i] == delete_list[j]) {
                    count++;
                    arr[i] = -1;
                }
            }
        }
        int[] answer = new int[arr.length - count];
        int index = 0;
        for(int i : arr){
            if(i != -1){
                answer[index] = i;
                index++;
            }
                
        }
        return answer;
    }
}