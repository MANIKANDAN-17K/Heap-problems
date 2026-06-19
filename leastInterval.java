class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> freq = new HashMap<>();
        for(char ch : tasks){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            Collections.reverseOrder()
        );
        for(int count : freq.values()){
            maxHeap.add(count);
        }
        int time = 0;
        while(!maxHeap.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int cycle = n+1;
            int i = 0;
            while(i<cycle && !maxHeap.isEmpty()){
                int count = maxHeap.poll();
                count--;
                if(count > 0){
                    temp.add(count);
                }
                time++;
                i++;
            }
            for(int count : temp){
                maxHeap.add(count);
            }
            if(!maxHeap.isEmpty()){
                time += (cycle - i);
            }
        }
        return time;
    }
}
