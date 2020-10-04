class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0]? b[1] - a[1]: a[0] - b[0]);
        
        int lowerBound = intervals[0][0];
        int upperBound = intervals[0][1];
        
        int result = intervals.length;
        for(int i = 1; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            // Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
            
//             if(lowerBound <= start && end <= upperBound){
//                 // Covered Intervals;
//                 result--;
//             }else if(lowerBound <= start && upperBound < end){
//                 upperBound = Math.max(upperBound, end);
//             }else{
//                 lowerBound = start;
//                 upperBound = end;
//             }
            if(end <= upperBound){
                result--;
            }else{
                upperBound = end;
            }
            
        }
        return result;
    }
}
