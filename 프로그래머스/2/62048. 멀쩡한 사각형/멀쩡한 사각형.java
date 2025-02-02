
class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        double width = (double)w;
        double height = (double)h;
        // 기울기 구하기
        // y(x) 값을 구한다.

        double incline = height / width;
        double start = 0;

        for(double i=1;i<=width;i++){
            // start : 시작
            // end : 끝
            // 만약 시작이 소수점일 경우 작은 정수로 만듦
            // 만약 끝이 소수점일 경우 큰 정수로 만들고 +1
            // 이후 end - start
            double end = height * i / width;
            double tempStart = start;
            double tempEnd = end;
            if(tempEnd % 1 != 0) tempEnd = (double)(long)tempEnd + 1;
            if(tempStart % 1 != 0) tempStart = (double)(long)tempStart;
            answer += (long)(tempEnd - tempStart);
            start += (end - start);
        }
        long square = (long)w * (long)h;
        return square - answer;
    }
}