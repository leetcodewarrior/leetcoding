class LC713SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int result = 0;
        int product = 1;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                // reset;
                product = 1;
                left = right = right + 1;
            }
            product = product * nums[right];
            while(left < nums.length && product >= k){
                product = product / nums[left++];
            }
            if(left == nums.length) return result;
            result += right - left + 1;
        }
        return result;
    }
}
