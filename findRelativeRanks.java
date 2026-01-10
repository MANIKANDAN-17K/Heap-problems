class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        PriorityQueue<Pair<Integer,Integer>> heap = new PriorityQueue<>((a,b) ->(b.getValue() - a.getValue()));
        for(int i = 0;i<= n-1;i++){
            heap.add(new Pair(i,score[i]));
        }
        int place = 1;
        String[] ans = new String[n];
        while(!heap.isEmpty()){
            Pair<Integer,Integer> top  = heap.poll();
            int curidx = top.getKey();
            if(place == 1){
                ans[curidx] = "Gold Medal";
            }else if(place == 2){
                ans[curidx] = "Silver Medal";
            }else if(place == 3){
                ans[curidx] = "Bronze Medal";
            }else{
                ans[curidx] = String.valueOf(place);
            }
            place++;
       }
       return ans;
    }
}
