class Solution {
    public int solution(int n, int[] stations, int w) {
        int math = (2 * w) + 1;
        int index = 0;
        int start = 1;
        int end = 0;
        int temp = 0;
        int answer = 0;

        while(index<stations.length){
            end = stations[index] - w;
            temp = end - start;
            // 겹치면
            if(temp>=1) {
                if (temp % math == 0) {
                    answer += (temp / math);
                } else {
                    answer += (temp / math) + 1;
                }
            }
            start = stations[index] + w + 1;
            index++;
        }
        if(n - (stations[index-1] + w)>0){
            start = stations[index-1] + w;
            end = n;
            temp = end - start;
            if(temp>=1) {
                if (temp % math == 0) {
                    answer += (temp / math);
                } else {
                    answer += (temp / math) + 1;
                }
            }
        }


        return answer;
    }
}