class RecentCounter {
    LinkedList<Integer> queue;
    public RecentCounter() {
        this.queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        this.queue.addLast(t);
        while(this.queue.size() > 0 && this.queue.getFirst() < t - 3000){
            this.queue.removeFirst();
        }
        return this.queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
