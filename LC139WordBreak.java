class LC139WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0 && wordDict.size() == 0) return true;
        if(s.length() == 0 || wordDict.size() == 0) return false;

        HashSet<String> dict = new HashSet<>();
        int maxLength = 0;
        for(String word: wordDict){
            dict.add(word);
            maxLength = Math.max(maxLength, word.length());
        }
        Boolean[] dp = new Boolean[s.length() + 1];
        dp[s.length()] = true;
        return helper(s, 0, dict, maxLength, dp);
    }
    
    private boolean helper(String s, int start, HashSet<String> dict, int maxLength, Boolean[] dp){
        if(start > s.length()) return false;
        if(start == s.length()) return true;
        if(dp[start] != null) return dp[start];
        
        for(int end = start + 1; end <= s.length() && end - start <= maxLength; end++){
            String substring = s.substring(start, end);
            if(dict.contains(substring) && helper(s, end, dict, maxLength, dp)){
                return dp[start] = true;
            }
        }
        return dp[start] = false;
    }
    
   
}
