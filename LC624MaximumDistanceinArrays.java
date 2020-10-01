class LC624MaximumDistanceinArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int result = 0;
        for(List<Integer> array: arrays){
            int end = array.get(array.size() - 1);
            int front = array.get(0);
            if(min != Integer.MAX_VALUE)
                result = Math.max(result, Math.max(Math.abs(end - min), Math.abs(max - front)));
            max = Math.max(max, end);
            min = Math.min(min, front);
        }
        return result;
    }
}
