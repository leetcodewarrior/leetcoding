class LC41FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        
        int oneCount = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0){
                nums[i] = 1;
            }else if(nums[i] == 1){
                oneCount++;
            }
        }
        if(oneCount == 0) return 1;
        
        for(int i = 0; i < nums.length; i++){
            if(Math.abs(nums[i]) <= nums.length && nums[Math.abs(nums[i]) - 1] > 0){
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return nums.length + 1;
        
    }
}
