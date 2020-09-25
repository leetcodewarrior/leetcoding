class LC179LargestNumber {
    public String largestNumber(int[] nums) {
        
        String[] list = new String[nums.length];
        for(int index = 0; index < nums.length; index++){
            list[index] = nums[index]+"";
        }
        Arrays.sort(list, (a, b) -> (b+""+a).compareTo(a+""+b));
        StringBuilder result = new StringBuilder();
        for(String str: list){
            result.append(str);
        }
        
        
        return result.toString().charAt(0) == '0'? "0": result.toString();
        // PriorityQueue<String> maxHeap = new PriorityQueue<>(nums.length, (a, b) -> (b+""+a).compareTo(a+""+b));
        
        
//         for(int value: nums){
//             maxHeap.add(value+"");
//         }
        
//         while(!maxHeap.isEmpty()){
//             String value = maxHeap.poll();
//             result.append(value);
//         }
        
        
        // return result.toString().charAt(0) == '0'? "0": result.toString();
    }
}
