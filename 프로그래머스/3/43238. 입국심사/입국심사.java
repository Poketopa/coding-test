class Solution {
    public long solution(int n, int[] times) {
        // min : 최소시간 (초기값 0)
        // max : 최대시간 (초기값 가장 긴 시간 * n)
        // mid = 이분 탐색을 위한 가운데 점
        long min = -1;
        long max = 0;
        for(int i : times) if(max<i) max = i;
        max *= n;
        long answer = 0;

        // 1. mid시간을 기준으로 times로 나누어서 n과 비교한다
        // n >= sum / 모든 사람을 검사하지 못했다 -> 시간 부족하므로 mid 상승
        // n < sum / 모든 사람을 검사하고 시간이 남음 -> mid 줄인다
        // 2. 시간이 부족한 경우 min = mid + 1로 설정해여서 크기가 작을 때 min > max인 상황을 만든다

        while(min <= max){
            long mid = (min + max) / 2;
            long sum = 0;
            for(int i : times) sum += mid / i;

            if(n <= sum){
                max = mid - 1;
                    answer = mid;

            }
            else{
                min = mid + 1;
            }
        }
        return answer;
    }
}