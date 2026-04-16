class Solution {
    public int solution(int n) {
        int MOD = 1000000007;
        
        if (n == 1) return 1;
        if (n == 2) return 3;
        if (n == 3) return 10;
        
        long[] dp = new long[n + 1];
        long[] s = new long[n + 1]; // 특수 패턴(2, 2, 4)의 누적 합을 저장할 배열
        
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 10;
        
        for (int i = 4; i <= n; i++) {
            long sum = 0;
            
            // k가 4, 5, 6일 때의 고유 패턴 수 (2, 2, 4) 곱셈
            if (i >= 4) sum = (sum + dp[i - 4] * 2) % MOD;
            if (i >= 5) sum = (sum + dp[i - 5] * 2) % MOD;
            if (i >= 6) sum = (sum + dp[i - 6] * 4) % MOD;
            
            // 주기가 3이므로, i-3의 누적 합에 현재 sum을 더함
            s[i] = (s[i - 3] + sum) % MOD;
            
            // 최종 dp[i] 계산
            dp[i] = (dp[i - 1] + dp[i - 2] * 2 + dp[i - 3] * 5 + s[i]) % MOD;
        }
        
        return (int) dp[n];
    }
}