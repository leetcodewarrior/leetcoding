class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length == 0) return 0;
        int result = 0;
        for(int index = 0; index < timeSeries.length - 1; index++){
            result += Math.min(timeSeries[index + 1] - timeSeries[index], duration);
        }
        // for(int index = 0; index < timeSeries.length - 1; index++){
        //     if(timeSeries[index + 1] - timeSeries[index] >= duration){
        //         result += duration;
        //     }else{
        //         result += timeSeries[index + 1] - timeSeries[index];
        //     }
        // }
        return result + duration;
//         int[] prev = new int[]{ timeSeries[0], timeSeries[0] + duration - 1};
        
//         for(int index = 1; index < timeSeries.length; index++){
//              int[] current = new int[]{timeSeries[index], timeSeries[index] + duration - 1};
//              if(prev[1] >= current[0]){
//                 prev[0] = Math.min(prev[0], current[0]);
//                 prev[1] = Math.max(prev[1], current[1]);
//              }else{
//                 result += prev[1] - prev[0] + 1;
//                 prev = current;
//             }
//         }
//         if(prev != null){
//             result += prev[1] - prev[0] + 1;
//         }
//         return result;
    }
}
