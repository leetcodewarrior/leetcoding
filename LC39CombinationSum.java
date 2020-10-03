class LC39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>[] dp = new ArrayList[target + 1];
        for(int i = 0; i <= target; i++){
            dp[i] = new ArrayList<>();
        }
        dp[0].add(new ArrayList<>());
        
        for(int candidate: candidates){
            for(int value = candidate; value <= target; value++){
                for(List<Integer> list: dp[value - candidate]){
                    List<Integer> clone = new ArrayList<>(list);
                    clone.add(candidate);
                    dp[value].add(clone);
                }
            }
        }
        
        return dp[target];
        
        
        // Arrays.sort(candidates);
        // List<List<Integer>> result = new ArrayList<>();
        // helper(result, new ArrayList<>(), candidates, 0, target);
        // return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> carry, int[] candidates, int index, int target){
        if(target == 0){
            result.add(new ArrayList<>(carry));
            return;
        }        
        if(target - candidates[index] >= 0){
            carry.add(candidates[index]);
            helper(result, carry, candidates, index, target - candidates[index]);
            carry.remove(carry.size() - 1);
        }
        
        if(index + 1 < candidates.length){
            helper(result, carry, candidates, index + 1, target);
        }
    
    }
}
