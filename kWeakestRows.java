class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(
            (a,b) ->{
                if(a[0] != b[0]){
                    return b[0] - a[0];
                }
                return b[1] - a[1];
            }
        );
        for(int i = 0;i<mat.length;i++){
            int strong = 0;
            for(int t : mat[i]){
                strong += t;
            }
            q.offer(new int[]{strong,i});
            if(q.size() > k){
                q.poll();
            }
        }
        int[] res = new int[k];
        for(int i = k -1;i>= 0;i--){
            res[i] = q.poll()[1];
        }
        return res;
    }
}
