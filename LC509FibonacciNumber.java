class LC509FibonacciNumber {
    public int fib(int N) {
        if(N <= 1) return N;
        // HashMap<Integer, Integer> dp = new HashMap<>();
        // Integer[] dp = new Integer[N + 1];
        // dp[0] = 0;
        // dp[1] = 1;
        int a = 0;
        int b = 1;
        for(int i = 2; i <= N; i++){
            int c = a + b;
            a = b;
            b = c;
            // dp[i] = dp[i - 1] + dp[i - 2];
        }
        return b;
        // return dp[N];
        // return helper(N, dp);
        // if(N <= 1) return N;
        // return fib(N - 1) + fib(N - 2);
    }
    private int helper(int N, Integer[] dp){
        if(dp[N] != null) return dp[N];
        return dp[N] = helper(N - 1, dp) + helper(N - 2, dp);
    }
}
