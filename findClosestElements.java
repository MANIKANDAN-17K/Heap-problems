class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = k;
        for(int i : arr){
            if(k > 0){
                minHeap.offer(i);
                k--;
            }else if(Math.abs(minHeap.peek() - x) > Math.abs(i - x)){
                minHeap.poll();
                minHeap.offer(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i =0;i<n;i++){
            res.add(minHeap.poll());
        }
        return res;
    }
}
