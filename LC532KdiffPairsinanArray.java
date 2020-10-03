class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        for(int i = 0; i < nums.length; ){
            int currentValue = nums[i];
            int target = currentValue + k;
            int left = i + 1;
            int right = nums.length - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                int val = nums[mid];
                if(target == val){
                    result++;
                    break;
                }
                if(target > val){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            
            do{
                i++;
            }while(i < nums.length && nums[i - 1] == nums[i]);
         
        }
        return result;

//         HashMap<Integer, Integer> hashmap = new HashMap<>();
//         // TreeMap<Integer, Integer> treemap = new TreeMap<>();
        
//         for(int value: nums){
//             hashmap.put(value, hashmap.getOrDefault(value, 0) + 1);
//             // treemap.put(value, treemap.getOrDefault(value, 0) + 1);
//         }
        
//         int result = 0;
//         for(Map.Entry<Integer, Integer> entry: hashmap.entrySet()){
//             int key = entry.getKey();
//             int target = key + k;
//             if(hashmap.containsKey(target)){
//                 if(key != target || hashmap.get(target) >= 2){
//                     result++;
//                 }
//             }
//         }
       
//         return result;
    }
}
