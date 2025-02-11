class Solution {
    public int solution(int n, int k) {
        int service = n / 10;
        return n * 12000 + (k-service) * 2000;
    }
}