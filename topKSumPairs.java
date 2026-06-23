class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        if (a.length == 0 || b.length == 0 || k == 0) {
               return new ArrayList<>();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((d,c) -> c[0] - d[0]);
        int n = a.length;
        maxHeap.offer(new int[]{a[n-1] + b[n-1],n-1,n-1});
        HashSet<String> visit = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        while(k-- > 0 && !maxHeap.isEmpty()){
            int[] curr = maxHeap.poll();
            int sum = curr[0];
            int i = curr[1];
            int j = curr[2];
            result.add(sum);
            visit.add(i+","+j);
            if(i-1 >= 0){
                String key = (i - 1) + "," + j;
                if(!visit.contains(key)){
                    maxHeap.offer(new int[]{a[i-1]+b[j],i-1,j});
                    visit.add(key);
                }
            }
            if(j-1 >= 0){
                String key = i + "," +(j-1);
                if(!visit.contains(key)){
                    maxHeap.offer(new int[]{a[i]+b[j-1],i,j-1});
                    visit.add(key);
                }
            }
        }
        return result;
    }
}
