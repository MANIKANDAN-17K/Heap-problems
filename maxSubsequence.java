
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        for(int i = 0 ;i<nums.length;i++){
            q.offer(new int[]{nums[i],i});
            if(q.size() > k){
                q.poll();
            }
        }
        int[][] indices = q.toArray(new int[0][0]);
        Arrays.sort(indices,Comparator.comparingInt(a -> a[1]));
        int[] res = new int[k];
        for(int i = 0;i<k;i++){
            res[i] = nums[indices[i][1]];
        }
        return res;
    }
}
