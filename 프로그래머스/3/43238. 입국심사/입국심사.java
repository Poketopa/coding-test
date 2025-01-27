class Solution {
    public long solution(int n, int[] times) {
        // max 찾기
        long min = 0;
        long max = -1;
        for(int i : times) if(max<i) max = i;
        max *= n;
        long answer = 0;

        // 1. 최저시간, 최대시간을 설정한다.
        // 2. 각 시간을 나눠서 더한 뒤 n보다 크면 최대시간을 줄인다
        //      n보다 작으면 최저시간을 늘린다
        if(times.length == 1)  return (long)n * times[0];
        while(min<=max){
            long mid = (max + min) / 2;
            long sum = 0;
            for(int i : times) {
                sum += (mid / i);
                if(sum >= n) break;
            }

            // 시간이 부족한 경우
            if(n>sum){
                min = mid + 1;
            }
            // 시간이 충분한 경우
            else if(n<=sum){
                answer = mid;
                max = mid - 1;
            }
        }
        return answer;
    }
}