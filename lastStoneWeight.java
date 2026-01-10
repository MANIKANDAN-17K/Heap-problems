class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];
        Queue<Integer> q = new PriorityQueue<>((a,b) -> b - a);
        for(int i : stones){
            q.offer(i);
        }
        while(q.size() != 1){
            q.offer(q.poll() - q.poll());
        }
        return q.poll();
    }
}
